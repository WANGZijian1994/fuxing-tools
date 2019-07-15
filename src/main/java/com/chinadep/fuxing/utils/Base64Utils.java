package com.chinadep.fuxing.utils;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
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
public class Base64Utils {
    /**
     * BASE64解码工具
     */
    private static final Base64.Decoder decoder = Base64.getDecoder();

    /**
     * 批量解码base64
     * @param list 需要解码的字符串
     * @return 解码后的字符串
     */
    public static List<String> decode(List<String> list){
        List<String> decodeList = Lists.newArrayList();
        for(String line:list){
            String decodeLine = decode(line);
            decodeList.add(decodeLine);
        }
        return decodeList;
    }

    /**
     * 单条数据解码
     * @param str 需要解码的字符串
     * @return 解码后的字符串
     */
    public static String decode(String str){
        String decodeStr = "";
        try {
            decodeStr = new String(decoder.decode(str.trim()), StandardCharsets.UTF_8);
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return decodeStr;
    }

}
