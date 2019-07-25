package com.chinadep.fuxing.controller;

import com.chinadep.fuxing.controller.vo.TagFindVO;
import com.chinadep.fuxing.controller.vo.TagVO;
import com.chinadep.fuxing.service.TagService;
import com.chinadep.fuxing.service.impl.ExcelServicelmpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
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
public class TagController {
    @Autowired
    private TagService service;

    @Autowired
    private ExcelServicelmpl excelServiceImpl;

    @PutMapping(value = "/chinadep_tag_1/add")
    public List<TagDO> renouveller()throws FileNotFoundException {
        return excelServiceImpl.configurerExcelEnTag();
    }

    /**
     * 查询列表(分页)
     *
     * @param page 分页对象
     * @return
     */
    @GetMapping
    public Page<TagVO> list(@PageableDefault Pageable page, TagFindVO tagFindVO) {
        TagDO params = new TagDO();
        params.setKey(tagFindVO.getKey());

        Page<TagDO> pages = service.findBy(params, page);
        Page<TagVO> respS = pages.map(tagDO -> this.convertTagVO(tagDO));
        return respS;
    }

    /**
     * DO转VO
     *
     * @param source
     * @return
     */
    private TagVO convertTagVO(TagDO source) {
        TagVO resp = new TagVO();
        if (source != null) {
            BeanUtils.copyProperties(source, resp);
        }
        return resp;
    }
/*
    @Autowired
    private DeleteService deleteService;

    @DeleteMapping(value = "/chinadep_tag/supprimer")
    public void supprimerTout(){
        List<TagDO>l = service.findAll();
        while(l.size()!=0){
            TagDO tg = l.get(0);
            deleteService.delete(tg);
        }
    }

 */
}
