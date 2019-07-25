package com.chinadep.fuxing.service;

import java.util.List;

/**
 * <p>
 * Title:导出顺序列表
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
public interface ExcelService {
    /**
     * 通过读取文件获取导出顺序
     * @param filePath 导出顺序批次
     * @return
     */
    List<String> getExportSort(String filePath);

    /**
     * 导入标签数据
     * @param filePath 文件地址
     */
    void importTag(String filePath);
}
