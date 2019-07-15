package com.chinadep.fuxing.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;

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
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    /**
     * 标签编码
     */
    @Column(name = "TAG_NO")
    private String tagNo;
    /**
     * 标签key
     */
    @Column(name = "key")
    private String key;
    /**
     * 标签名称
     */
    @Column(name = "name")
    private String name;
    /**
     * 类型
     */
    @Column(name = "type")
    private String type;
}
