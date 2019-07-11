package com.chinadep.fuxing.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Entity;

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
@Getter
@Setter
@ToString
@Accessors(chain = true)
@Entity(name = "chinadep_tag")
public class TagDO extends BaseDO {
    /**
     * 物理主键
     */
    private Long id;
    /**
     * 标签key
     */
    private String key;
    /**
     * 标签名称
     */
    private String name;
    /**
     * 类型
     */
    private String type;
}
