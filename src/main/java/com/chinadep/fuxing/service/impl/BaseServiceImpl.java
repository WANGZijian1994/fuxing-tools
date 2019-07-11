package com.chinadep.fuxing.service.impl;

import com.chinadep.fuxing.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * Title:基础服务
 * </p>
 * <p>
 * Description:其他service继承该类即可获取常用服务功能
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 *
 * @author Jovi
 * @version 1.0
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {

    @Override
    public List<T> findAll() {
        return getBaseRepository().findAll();
    }

    @Override
    public Page<T> findBy(Pageable pageable) {
        return getBaseRepository().findAll(pageable);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, timeout = 30, propagation = Propagation.REQUIRED)
    public T save(T object) {
        return (T) getBaseRepository().save(object);
    }

    @Override
    public T get(Long id) {
        return (T) getBaseRepository().getOne(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, timeout = 30, propagation = Propagation.REQUIRED)
    public void delete(Long[] ids) {
        for (Long id : ids) {
            getBaseRepository().delete(id);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class, timeout = 30, propagation = Propagation.REQUIRED)
    public void delete(Long id) {
        getBaseRepository().delete(id);
    }
}
