package com.chinadep.fuxing.service.impl;

import com.chinadep.fuxing.entity.TagDO;
import com.chinadep.fuxing.repository.BaseRepository;
import com.chinadep.fuxing.repository.TagRepository;
import com.chinadep.fuxing.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service
public class TagServiceImpl extends BaseServiceImpl<TagDO> implements TagService {

    @Autowired
    private TagRepository repository;

    /**
     * 获取基础仓储类
     *
     * @return
     */
    @Override
    public BaseRepository getBaseRepository() {
        return repository;
    }
}
