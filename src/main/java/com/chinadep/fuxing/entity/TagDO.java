package com.chinadep.fuxing.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;


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
    @Column(name = "tagNo")
    private String tagNo;
    /**k
     * 标签名称
     */
    @Column(name = "name")
    private String name;
    /**
     * 标签key
     */
    @Column(name = "key_")
    private String key;
    /**
     * 类型
     */
    @Column(name = "type")
    private String type;

}