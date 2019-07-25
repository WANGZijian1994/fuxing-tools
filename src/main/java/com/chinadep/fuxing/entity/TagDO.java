package com.chinadep.fuxing.entity;

import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;


@Accessors(chain = true)
@ToString
@Entity(name = "chinadep_tag")
public class TagDO {
    /**
     * 物理主键
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    /**
     * 标签编码
     */
    @Column(name = "tagNo")
    private String tagNo;
    /**
     * 标签名称
     */
    @Column(name = "name")
    private String name;
    /**
     * 标签key
     */
    @Column(name = "clé")
    private String key;
    /**
     * 类型
     */
    @Column(name = "type")
    private String type;

    public TagDO(){}

    public Integer getId(){
        return id;
    }

    public String getTagNo(){return tagNo;}

    public String getKey(){return key;}

    public String getName(){return name;}

    public String getType(){return type;}

    public void setId(Integer id1){this.id = id1;}

    public void setTagNo(String tag){this.tagNo = tag;}

    public void setKey(String key){this.key = key;}

    public void setName(String name){this.name = name;}

    public void setType(String type){this.type = type;}
}