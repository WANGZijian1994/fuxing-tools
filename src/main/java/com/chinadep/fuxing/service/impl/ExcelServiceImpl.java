package com.chinadep.fuxing.service.impl;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.metadata.Sheet;
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
        List<Object>l = this.readExcel(filePath);
        List<TagDO> list = Lists.newArrayList();
        for(int i = 1;i<l.size();i++){
            String str = l.get(i).toString();
            str = str.replace("[","");
            str = str.replace("]","");

            TagDO tg = new TagDO();
            long lo = (long) i;
            tg.setId(lo);
            tg.setTagNo(Character.toString(str.charAt(0)));
            int k = str.indexOf(',',2);
            tg.setName(str.substring(2,k));
            tg.setKey(str.substring(++k,str.indexOf(',',++k)));
            String fin = Character.toString(str.charAt(str.length()-1));
            if(fin.equals("0")){
                tg.setType("String");
            }
            if(fin.equals("2")){
                tg.setType("Map");
            }
            if(fin.equals("4")){
                tg.setType("Array");
            }
            list.add(tg);
        }

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
            List<Object> data = EasyExcelFactory.read(inputStream, new Sheet(1, 0));
            return data;
        }catch (FileNotFoundException e){
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return Lists.newArrayList();

    }
}
