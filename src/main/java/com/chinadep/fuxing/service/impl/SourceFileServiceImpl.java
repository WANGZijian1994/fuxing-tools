package com.chinadep.fuxing.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.chinadep.fuxing.constant.TypeDef;
import com.chinadep.fuxing.entity.TagDO;
import com.chinadep.fuxing.service.SourceFileService;
import com.chinadep.fuxing.service.TagService;
import com.chinadep.fuxing.service.domain.SourceFileParam;
import com.chinadep.fuxing.utils.FileUtils;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 *
 * @author Jovi
 * @version 1.0
 */
@Slf4j
@Service
public class SourceFileServiceImpl implements SourceFileService {

    /**
     * SOURCE文件后缀
     */
    private static String SOURCE_SUFFIX = ".SOURCE";

    /**
     * 文件分隔符
     */
    public static String SEPARATO = "|@|";

    /**
     * 竖杠分隔符
     */
    public static String VERTICAL_SEPARATO = "|";

    /**
     * dls地址
     */
    @Value("${chansey.file.sourcePath}")
    private String sourcePath;

    @Autowired
    private TagService tagService;

    /**
     * minio地址
     */
    private static final String MINIO_URL = "http://10.101.12.44:9000/";
    /**
     * minio access key
     */
    private static final String MINIO_ACCESS_KEY = "chinadep";
    /**
     * minio secret key
     */
    private static final String MINIO_SECRET_KEY = "chinadep@123";
    /**
     * minio 桶名称
     */
    private static final String MINIO_BUCKET = "fuxing";

    /**
     * 从文件中获取数据
     *
     * @param param    参数
     * @param list     原文件
     * @param sortList 排序列表
     */
    @Override
    public void createSourceFile(SourceFileParam param, List<JSONObject> list, List<String> sortList) {
        //整理标签 按照sortList的顺序对整个的tag进行排序
        Map<String, TagDO> tagMap = tagService.findAllMap();
        List<TagDO> tagSortedList = Lists.newLinkedList();
        for(String tagNo:sortList){
            tagSortedList.add(tagMap.get(tagNo));
        }
        // 文件路径 生成文件
        String fileName = param.getJobId()+"_"+param.getIdType()+"_"+param.getBatchId()+"_"+"0000"+SOURCE_SUFFIX;

        StringBuilder fileBuilder = new StringBuilder();
        for(JSONObject object:list){
            StringBuilder sb = new StringBuilder();
            //如果有数据 则+1
            int count = 0;

            String XID = StringUtils.hasText(object.getString("xid")) ? object.getString("xid"):"null";
            sb.append(XID).append(SEPARATO);
            for(TagDO tagDO : tagSortedList){
                switch (tagDO.getType()){
                   case TypeDef.TYPE_STRING:
                       boolean flag = appendString(sb,object,tagDO.getKey());
                       if(flag){
                           count++;
                       }
                       break;
                   case TypeDef.TYPE_ARRAY:
                       flag = appendArray(sb,object,tagDO.getKey());
                       if(flag){
                           count++;
                       }
                       break;
                   case TypeDef.TYPE_MAP:
                       flag = appendMap(sb,object,tagDO.getKey());
                       if(flag){
                           count++;
                       }
                       break;
               }
            }
            sb.append("\n");

            if(count > 0){
                fileBuilder.append(sb);
            }
        }
        String objectName = "source/"+fileName;
        FileUtils.uploadToMinio(fileBuilder,objectName);

    }

    /**
     * 添加字符串
     * @param sb
     * @param o
     * @param data
     */
    private static boolean appendString(StringBuilder sb,JSONObject o,String data){
        boolean flag = false;
        String x;
        if(StringUtils.hasText(o.getString(data) )){
            x = o.getString(data);
            flag = true;
        }else {
            x = "null";
        }
        sb.append(x).append(VERTICAL_SEPARATO);
        return flag;
    }

    /**
     * 添加数组 带（‘|’）
     * @param sb
     * @param o
     * @param key
     */
    private static boolean appendArray(StringBuilder sb,JSONObject o,String key){
        JSONArray array = o.getJSONArray(key);
        if(array==null){
            sb.append("null").append("|");
            return false;
        }
        if(array.size()==0){
            sb.append("null").append("|");
            return false;
        }
        String str = Joiner.on(',').join(array);
        sb.append(str).append("|");
        return true;
    }

    /**
     * 添加MAP
     * @param sb
     * @param o
     * @param key
     */
    private static boolean appendMap(StringBuilder sb,JSONObject o,String key){
        String value = o.getString(key);
        Map<String,String> map = JSONObject.parseObject(value,Map.class);
        if(map==null){
            sb.append("null").append("|");
            return false;
        }
        if(map.size()==0){
            sb.append("null").append("|");
            return false;
        }
        List<String> list = Lists.newArrayList();
        for(String keyStr:map.keySet()){
            String valueStr = map.get(keyStr);
            list.add(keyStr+":"+valueStr);
        }
        String str = Joiner.on(',').join(list);
        sb.append(str).append("|");
        return true;
    }

}
