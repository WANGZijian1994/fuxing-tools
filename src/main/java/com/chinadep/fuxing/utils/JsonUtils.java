package com.chinadep.fuxing.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
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
public class JsonUtils {
    /**
     * 将json字符串转换成对象
     * @param jsonList
     */
    public static List<JSONObject> parseObject(List<String> jsonList){
        List<JSONObject> jsonObjects = Lists.newArrayList();
        for(String jsonStr:jsonList){
            try {
                JSONObject jsonObject = JSON.parseObject(jsonStr);
                jsonObjects.add(jsonObject);
            } catch (JSONException e){
                e.printStackTrace();
                log.error(jsonStr);
                log.error(e.getMessage());
            }


        }
        return jsonObjects;
    }
}
