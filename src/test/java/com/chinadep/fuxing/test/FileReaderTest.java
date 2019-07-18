package com.chinadep.fuxing.test;

import com.alibaba.fastjson.JSONObject;
import com.chinadep.fuxing.ChanseyApplication;
import com.chinadep.fuxing.service.SourceFileService;
import com.chinadep.fuxing.service.domain.SourceFileParam;
import com.chinadep.fuxing.utils.Base64Utils;
import com.chinadep.fuxing.utils.FileUtils;
import com.chinadep.fuxing.utils.JsonUtils;
import com.google.common.base.Splitter;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private SourceFileService fileService;
    @Test
    public void test() {
        log.info("test...");

        // 1. 从minio中获取文件
        // https://github.com/minio/minio-java
        List<String> list = FileUtils.readFile("C:\\Users\\chinadep\\Desktop\\0000529_JON20190715000001742_ID010105_20190717114240_0000.RES");

        //2. 解码
        list = Base64Utils.decode(list);

        //3. 获取顺序数据
        List<String>  sortOrderList = FileUtils.readFile("C:\\Users\\chinadep\\Desktop\\0000529_JON20190715000001742_ID010105_20190717114240_0000.SORT");

        Splitter sp = Splitter.on(",").omitEmptyStrings().trimResults();
        List<String> sortList = sp.splitToList(sortOrderList.get(0));

        //转换json对象
        List<JSONObject> jsonObjects = JsonUtils.parseObject(list);
        //0000529_JON20190715000001742_ID010105_20190717114240_0000.RES
        //工单号
        String orderId = "JON20190715000001742";
        //批次号
        String batchNo = "20190717114240";
        //id类型
        String idType = "ID010105";
        SourceFileParam param = new SourceFileParam();
        param.setJobId(orderId).setBatchId(batchNo).setIdType(idType);
        //4. 创建SOURCE文件
        fileService.createSourceFile(param,jsonObjects,sortList);
    }

}




