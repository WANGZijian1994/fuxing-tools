package com.chinadep.fuxing.test;

import com.chinadep.fuxing.ChanseyApplication;
import com.chinadep.fuxing.utils.Base64Utils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ChanseyApplication.class)
public class FileReaderTest {
    @Test
    public void test(){
        log.info("test");
        // 1. 从minio中获取文件
        // https://github.com/minio/minio-java
        // https://github.com/minio/minio-java/blob/master/examples/GetObject.java

        //2. 解码
        //com.chinadep.fuxing.utils.Base64Utils.decode(java.util.List<java.lang.String>)

    }
}
