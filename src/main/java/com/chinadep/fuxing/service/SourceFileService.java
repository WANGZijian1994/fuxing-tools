package com.chinadep.fuxing.service;

import com.alibaba.fastjson.JSONObject;
import com.chinadep.fuxing.service.domain.SourceFileParam;

import java.util.List;

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
public interface SourceFileService {
    /**
     * 从文件中获取数据
     * @param param 参数
     * @param list 原文件
     * @param sortList 排序列表
     */
    void createSourceFile(SourceFileParam param, List<JSONObject> list,List<String> sortList);
}
