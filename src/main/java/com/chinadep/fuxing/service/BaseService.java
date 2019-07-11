package com.chinadep.fuxing.service;

import com.chinadep.fuxing.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * <p>
 * Title: 基础服务类
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
public interface BaseService<T> {
    /**
     * 查询全部
     * @return
     */
    List<T> findAll();

    /**
     * 分页查询
     * @param pageable
     * @return
     */
    Page<T> findBy(Pageable pageable);

    /**
     * 保存对象
     * @param object
     * @return
     */
    T save(T object);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    T get(Long id);

    /**
     * 删除多个对象
     * @param ids
     */
    void delete(Long[] ids);

    /**
     * 删除单个对象
     * @param id
     */
    void delete(Long id);

    /**
     * 获取基础仓储类
     * @return
     */
    BaseRepository getBaseRepository();
}
