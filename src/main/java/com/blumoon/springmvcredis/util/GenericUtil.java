/*
 * Blumoon Technologies Corp.
 * Copyright 2013.
 */
package com.blumoon.springmvcredis.util;

/**
 *
 * @author MC de Guzman <mc@blumoon.mobi>
 */
public class GenericUtil {

    /**
     * @param <T>
     * @param argument
     * @return boolean
     */
    public <T> boolean isNull(T argument) {
        return (argument == null);
    }

    /**
     * @param <T>
     * @param argument
     * @return boolean
     */
    public <T> boolean isNotNull(T argument) {
        return !(argument == null);
    }

    /**
     * @param string
     * @return boolean
     */
    public boolean isNumpty(String string) {
        return (null == string || string.trim().isEmpty());
    }

    /**
     * @param string
     * @return boolean
     */
    public boolean isNotNumpty(String string) {
        return (null != string && !string.trim().isEmpty());
    }
}
