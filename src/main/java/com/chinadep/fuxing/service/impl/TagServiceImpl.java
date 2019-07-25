package com.chinadep.fuxing.service.impl;

import com.chinadep.fuxing.repository.BaseRepository;
import com.chinadep.fuxing.repository.TagRepository;
import com.chinadep.fuxing.service.TagService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

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

    /**
     * 分页查询
     *
     * @param tag
     * @param pageable
     * @return
     */
    @Override
    public Page<TagDO> findBy(TagDO tag, Pageable pageable) {
        Page<TagDO> entities = repository.findAll((root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (!StringUtils.isEmpty(tag.getKey())){
                predicates.add(criteriaBuilder.like(root.get("key").as(String.class), "%" + tag.getKey() + "%"));
            }
            Predicate[] predicateArray = new Predicate[predicates.size()];
            return criteriaBuilder.and(predicates.toArray(predicateArray));
        }, pageable);
        return entities;
    }

    /**
     * 查询全部
     * key 为标签编码 value为标签实体
     * @return
     */
    @Override
    public Map<String, TagDO> findAllMap() {
        List<TagDO> list = this.findAll();
        return list.stream().collect(Collectors.toMap(TagDO::getTagNo, Function.identity()));
    }

    /**
     * 保存标签数据
     *
     * @param
     * @return
     */

}
