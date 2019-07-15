package com.chinadep.fuxing.utils;

import com.github.marschall.lineparser.LineParser;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
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
public class FileUtils {

    /**
     * 读取文件
     * @param filePath 文件
     * @return
     */
    public static List<String> readFile(String filePath)  {
        List<String> list = Lists.newArrayList();
        LineParser parser = new LineParser();
        Charset cs = StandardCharsets.UTF_8;
        Path path = Paths.get(filePath);
        try{
            parser.forEach(path, cs, (line) -> {
                list.add(line.getContent().toString());
            });
        }catch (IOException e){
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return list;
    }

    /**
     * 从minio中文件中的数据
     * @param objectName
     * @return
     */
    public static List<String> readFromMinio(String objectName){
        return null;
    }
}
