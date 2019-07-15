package com.chinadep.fuxing.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;

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
public class JsonUtils {
    /**
     * 将json字符串转换成对象
     * @param jsonList
     */
    public static List<JSONObject> parseObject(List<String> jsonList){
        List<JSONObject> jsonObjects = Lists.newArrayList();
        for(String jsonStr:jsonList){
            JSONObject jsonObject = JSON.parseObject(jsonStr);
            jsonObjects.add(jsonObject);
        }
        return jsonObjects;
    }
}
