package com.chinadep.fuxing.service.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

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
@Accessors(chain = true)
public class SourceFileParam {
    /**
     * 订单号
     */
    private String jobId;
    /**
     * 批次号
     */
    private String batchId;
    /**
     * ID标识类型
     */
    private String idType;
}
