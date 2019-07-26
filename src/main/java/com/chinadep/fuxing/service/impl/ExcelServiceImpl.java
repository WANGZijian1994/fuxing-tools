package com.chinadep.fuxing.service.impl;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.metadata.Sheet;
import com.chinadep.fuxing.constant.TypeDef;
import com.chinadep.fuxing.entity.TagDO;
import com.chinadep.fuxing.repository.TagRepository;
import com.chinadep.fuxing.service.ExcelService;
import com.google.api.client.util.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

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
public class ExcelServiceImpl implements ExcelService {
    @Autowired
    private TagRepository tagRepository;
    /**
     * 通过读取文件获取导出顺序
     * @param filePath 导出顺序批次
     * @return
     */
    @Override
    public List<String> getExportSort(String filePath) {
        return null;
    }

    /**
     * 导入标签数据
     *
     * @param filePath 文件地址
     */
    @Override
    public void importTag(String filePath) {
        List<Object> l = this.readExcel(filePath);
        List<TagDO> list = Lists.newArrayList();
        for(int i = 0;i<l.size();i++){
            List<String> row = (List<String>)l.get(i);

            String tagNo = row.get(0);
            String name = row.get(1);
            String key = row.get(2);
            String typeStr = row.get(3);
            String type = "";
            switch (typeStr){
                case "0":
                    type = TypeDef.TYPE_STRING;
                    break;
                case "2":
                    type = TypeDef.TYPE_MAP;
                    break;
                case "4":
                    type = TypeDef.TYPE_ARRAY;
                    break;
                default:
                    type = TypeDef.TYPE_OTHER;
            }

            TagDO tagDO = new TagDO();
            tagDO.setTagNo(tagNo).setKey(key).setType(type).setName(name);
            list.add(tagDO);
        }
        tagRepository.deleteAll();
        tagRepository.saveAll(list);
    }

    /**
     * 读取excel中的数据
     * @param filePath
     * @return
     * @throws FileNotFoundException
     */
    private List<Object> readExcel(String filePath) {
        try {
            InputStream inputStream = new BufferedInputStream(new FileInputStream(filePath));
            List<Object> data = EasyExcelFactory.read(inputStream, new Sheet(1, 1));
            return data;
        }catch (FileNotFoundException e){
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return Lists.newArrayList();

    }
}
