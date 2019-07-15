package com.chinadep.fuxing.utils;

import com.github.marschall.lineparser.LineParser;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import io.minio.MinioClient;
import java.io.InputStream;


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
    public static List<String> readFromMinio(String chemin){
        String str = new String();
        try {
            MinioClient minioClient = new MinioClient("http://10.101.12.44:9000/", "chinadep",
                    "chinadep@123");
            minioClient.statObject("fuxing", chemin);
            InputStream stream = minioClient.getObject("fuxing", chemin);
            byte[] buf = new byte[16384];
            int bytesRead;
            while ((bytesRead = stream.read(buf, 0, buf.length)) >= 0) {
                str = new String(buf, 0, bytesRead, StandardCharsets.UTF_8);
            }
            stream.close();

        } catch (Exception e) {
            System.out.println("Error occurred: " + e);
        }

        Splitter sp = Splitter.on("\n").omitEmptyStrings().trimResults();
        List<String> list = sp.splitToList(str);
        List<String> result = Base64Utils.decode(list);

        return result;
    }
}
