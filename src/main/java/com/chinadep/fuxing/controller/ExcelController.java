package com.chinadep.fuxing.controller;


import com.chinadep.fuxing.service.impl.ExcelService;
import com.chinadep.fuxing.repository.ExcelRepository;
import com.chinadep.fuxing.entity.TagDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RestController
//@RequestMapping("/tag")
public class ExcelController {


    @Autowired
    ExcelRepository excelRepository;

    @GetMapping(value = "/chinadep_tag")
    public List<TagDO> lireTout(){
        return excelRepository.findAll();
    }

    @Autowired
    ExcelService excelService;

    @PostMapping(value = "/chinadep_tag/add")
    public List<TagDO> renouveller(){
        return excelService.configurerExcelEnTag();
    }
}
