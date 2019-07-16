package com.chinadep.fuxing.utils;

import com.github.marschall.lineparser.LineParser;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import io.minio.MinioClient;
import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
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

    private static MinioClient minioClient;


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
     * @param splitterStr
     * @return
     */
    public static List<String> readFromMinio(String objectName,String splitterStr){
        String str = new String();
        try {
            MinioClient minioClient = new MinioClient(MINIO_URL, MINIO_ACCESS_KEY, MINIO_SECRET_KEY);
            minioClient.statObject(MINIO_BUCKET, objectName);
            InputStream stream = minioClient.getObject(MINIO_BUCKET, objectName);
            byte[] buf = new byte[16384];
            int bytesRead;
            while ((bytesRead = stream.read(buf, 0, buf.length)) >= 0) {
                str = new String(buf, 0, bytesRead, StandardCharsets.UTF_8);
            }
            stream.close();

        } catch (Exception e) {
            log.info("Error occurred: {}" + e.getMessage());
        }

        Splitter sp = Splitter.on(splitterStr).omitEmptyStrings().trimResults();
        List<String> list = sp.splitToList(str);

        return list;
    }

    /**
     * 上传至minio
     * @param objectName
     * @param objectName10
     * @return
     */
    public static void uploadToMinio(String filePath,InputStream  in,String objectName){
        String str = new String();
        try {
            MinioClient minioClient = new MinioClient(MINIO_URL, MINIO_ACCESS_KEY, MINIO_SECRET_KEY);
            minioClient.statObject(MINIO_BUCKET, objectName);
            minioClient.putObject(MINIO_BUCKET, objectName, in, Long.valueOf(in.available()), null, null, "application/octet-stream");
        } catch (Exception e) {
            log.info("Error occurred: {}" + e.getMessage());
        }
    }

}
