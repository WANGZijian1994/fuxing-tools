package com.chinadep.fuxing.test;

import com.chinadep.fuxing.ChanseyApplication;
import com.chinadep.fuxing.utils.Base64Utils;
import com.chinadep.fuxing.utils.FileUtils;
import com.google.common.base.Splitter;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.io.InputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;

import java.nio.charset.StandardCharsets;

import org.xmlpull.v1.XmlPullParserException;

import io.minio.MinioClient;
import io.minio.errors.MinioException;
import java.util.List;

/* <p>
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
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ChanseyApplication.class)
public class FileReaderTest {
    @Test
    public void test()throws IOException, NoSuchAlgorithmException, InvalidKeyException, XmlPullParserException {
        log.info("test");

        // 1. 从minio中获取文件
        // https://github.com/minio/minio-java
        List<String> list = FileUtils.readFromMinio("res/0000529_JON20190709000001709_ID010105_20190710104040_0000.RES");
        //2. 解码
        List<String> result = Base64Utils.decode(list);
        System.out.println(result);
    }

}




