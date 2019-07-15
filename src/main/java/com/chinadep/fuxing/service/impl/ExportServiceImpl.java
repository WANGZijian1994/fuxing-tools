package com.chinadep.fuxing.service.impl;

import com.chinadep.fuxing.service.ExportSortService;
import lombok.extern.slf4j.Slf4j;

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
@Slf4j
public class ExportServiceImpl implements ExportSortService {
    /**
     * 通过读取文件获取导出顺序
     * @param filePath 导出顺序批次
     * @return
     */
    @Override
    public List<String> getExportSort(String filePath) {
        return null;
    }
}
