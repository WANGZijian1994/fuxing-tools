package com.chinadep.fuxing.service;

import com.chinadep.fuxing.entity.TagDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

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
public interface TagService extends BaseService<TagDO> {
    /**
     * 分页查询
     * @param tag
     * @param pageable
     * @return
     */
    Page<TagDO> findBy(TagDO tag,Pageable pageable);

    /**
     * 查询全部
     * @return
     */
    Map<String,TagDO> findAllMap();
}
