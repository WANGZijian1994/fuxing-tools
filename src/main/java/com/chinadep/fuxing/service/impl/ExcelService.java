package com.chinadep.fuxing.service.impl;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.metadata.Sheet;
import com.chinadep.fuxing.repository.ExcelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinadep.fuxing.entity.TagDO;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExcelService {

    @Autowired
    private ExcelRepository excelRepository;


    public List<Object> lireExcel(String filePath) throws FileNotFoundException {
        InputStream inputStream = new BufferedInputStream(new FileInputStream(filePath));
        List<Object> data = EasyExcelFactory.read(inputStream, new Sheet(1, 0));
        return data;
    }

    public List<TagDO> configurerExcelEnTag(){
        List<TagDO>l1 = new ArrayList<>();
        try{
            List<Object>l = new ArrayList<>();
            l = lireExcel("/Users/zijian/ZijianStage/données/1.xlsx");
        l1 = new ArrayList<>();
        for(int i = 0;i<l.size();i++){
            String str = l.get(i).toString();
            str = str.replace("[","");
            str = str.replace("]","");
            TagDO tg = new TagDO();
            //setId
            tg.setId(i);
            //setTagNo
            tg.setTagNo(Integer.toString(i));
            int k = str.indexOf(',');
            int k1 = str.indexOf(',',++k);
            //setName
            tg.setName(str.substring(k+1,k1));
            //setKey
            tg.setKey(str.substring(k1+2,str.indexOf(',',++k1)));
            //setType
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
            l1.add(tg);
        }}
        catch(FileNotFoundException e){e.printStackTrace();}
        l1.remove(0);
        excelRepository.saveAll(l1);
        return l1;
    }
}
