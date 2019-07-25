package com.chinadep.fuxing.service.impl;

import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.EasyExcelFactory;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExcelServicelmpl {

    private ExcelRepository excelRepository = new ExcelRepository() {
        @Override
        public List<TagDO> findAll() {
            return null;
        }

        @Override
        public List<TagDO> findAll(Sort sort) {
            return null;
        }

        @Override
        public List<TagDO> findAllById(Iterable<Long> iterable) {
            return null;
        }

        @Override
        public <S extends TagDO> List<S> saveAll(Iterable<S> iterable) {
            return null;
        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends TagDO> S saveAndFlush(S s) {
            return null;
        }

        @Override
        public void deleteInBatch(Iterable<TagDO> iterable) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public TagDO getOne(Long aLong) {
            return null;
        }

        @Override
        public <S extends TagDO> List<S> findAll(Example<S> example) {
            return null;
        }

        @Override
        public <S extends TagDO> List<S> findAll(Example<S> example, Sort sort) {
            return null;
        }

        @Override
        public Page<TagDO> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends TagDO> S save(S s) {
            return null;
        }

        @Override
        public Optional<TagDO> findById(Long aLong) {
            return Optional.empty();
        }

        @Override
        public boolean existsById(Long aLong) {
            return false;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(Long aLong) {

        }

        @Override
        public void delete(TagDO tagDO) {

        }

        @Override
        public void deleteAll(Iterable<? extends TagDO> iterable) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public <S extends TagDO> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends TagDO> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends TagDO> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends TagDO> boolean exists(Example<S> example) {
            return false;
        }
    };

    public ExcelServicelmpl(){}

    public List<Object> lireExcel(String filePath) throws FileNotFoundException {
        InputStream inputStream = new BufferedInputStream(new FileInputStream(filePath));
        List<Object> data = EasyExcelFactory.read(inputStream, new Sheet(1, 0));
        return data;
    }

    public List<TagDO> configurerExcelEnTag() throws FileNotFoundException{
        List<Object>l = lireExcel("/Users/zijian/ZijianStage/données/1.xlsx");
        List<TagDO>l1 = new ArrayList<>();
        for(int i = 0;i<l.size();i++){
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
            l1.add(tg);
        }
        l1.remove(0);
        excelRepository.saveAll(l1);
        return l1;
    }



/*
    public static void main(String[] args) throws IOException{
        ExcelServicelmpl e = new ExcelServicelmpl();
        System.out.println(e.configurerExcelEnTag());
    }

 */


}
