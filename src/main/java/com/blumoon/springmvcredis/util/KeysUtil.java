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
     * @param paramString
     * @return key or value
     */
    public String build(String... paramString) {
        StringBuilder sb = new StringBuilder();
        for (String s : paramString) {
            sb.append(s).append(DELIMITER);
        }
        return sb.toString().replaceAll(DELIMITER.concat("$"), "");
    }
}
