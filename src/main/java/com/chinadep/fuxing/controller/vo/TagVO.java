package com.chinadep.fuxing.controller.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
@NoArgsConstructor
public class TagVO {
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
