package com.chinadep.fuxing.test;

import com.chinadep.fuxing.ChanseyApplication;
import com.chinadep.fuxing.service.ExcelService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ExcelServiceTest {
    @Autowired
    private ExcelService excelService;
    @Test
    public void test(){
        String filePath = "C:\\Users\\chinadep\\Desktop\\复星标签整理 0717.xlsx";
        excelService.importTag(filePath);
    }
}
