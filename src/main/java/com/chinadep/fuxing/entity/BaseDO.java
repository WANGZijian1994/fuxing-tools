package com.chinadep.fuxing.entity;

import com.chinadep.fuxing.entity.listener.BaseEntityListener;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.util.Date;

import com.alibaba.excel.metadata.BaseRowModel;

/**
 * <p>
 * Title: 基础entity类
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
@Getter
@Setter
@ToString
@NoArgsConstructor
@MappedSuperclass
@EntityListeners(BaseEntityListener.class)
public class BaseDO extends BaseRowModel{
    /**
     * 首次录入时间
     */
    @Column(name = "firstinsert")
    private Date firstInsert;
    /**
     * 最后修改时间
     */
    @Column(name = "lastmodified")
    private Date lastModified;
}
