/*
 *   Blumoon Technologies Corp.
 *   Copyright 2013.
 */
package com.blumoon.springmvcredis.util;

import java.util.UUID;

/**
 *
 * @author Gene Diaz Jr. <gene@blumoon.mobi>
 */
public class KeysUtil {

    public static final String WILDCARD = "*";
    public static final String DELIMITER = ":";
    public static final String FINISHER = ";";

    /**
     * @return no dash UUID
     */
    public String generateUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * @param key
     * @param param
     * @return no dash UUID
     */
    public String buildKey(String key, String param) {
        return new StringBuilder(key).append(param).toString();
    }

    /**
     * @param value1
     * @param value2
     * @return no dash UUID
     */
    public String buildValue(String value1, String value2) {
        return new StringBuilder(value1).append(DELIMITER)
                .append(value2).toString();
    }

    /**
     * @param value1
     * @param value2
     * @param value3
     * @return no dash UUID
     */
    public String buildValue(String value1, String value2, String value3) {
        return new StringBuilder(value1).append(DELIMITER)
                .append(value2).append(DELIMITER)
                .append(value3).toString();
    }

    /**
     * @param value1
     * @param value2
     * @param value3
     * @param value4
     * @return no dash UUID
     */
    public String buildValue(String value1, String value2, String value3, String value4) {
        return new StringBuilder(value1).append(DELIMITER)
                .append(value2).append(DELIMITER)
                .append(value3).append(DELIMITER)
                .append(value4).toString();
    }
}
