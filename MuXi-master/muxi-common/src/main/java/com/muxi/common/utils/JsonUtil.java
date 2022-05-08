package com.muxi.common.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

/**
    * @ClassName: JsonUtil
    * @Description:json解析
    * @author weny.yang
    * @date 2020年10月10日
    */
    @Slf4j
    public class JsonUtil {

        /**
        * @Title: toAlibabaJSONObject
        * @Description:使用com.alibaba.fastjson工具解析报文
        * @author weny.yang
        */
        public static com.alibaba.fastjson.JSONObject parseObject(String json) {
            return com.alibaba.fastjson.JSONObject.parseObject(json);
        }
        /**
         * @Title: toJsonNode
         * @Description:使用jackson工具解析报文
         * @author weny.yang
         */
        public static JsonNode toJsonNode(String str) {
            try {
                return new ObjectMapper().readTree(str);
            } catch (Exception e) {
                log.error("调用JsonUtil.toJsonNode Exception, str=" + str, e);
            }
            return null;
        }

    }