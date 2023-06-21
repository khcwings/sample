package com.multi.sample.common.utils;

import org.springframework.context.support.MessageSourceAccessor;

import java.util.Locale;

public class CommonMessage {
    private static MessageSourceAccessor msa = null;

    public void setMessageSourceAccessor(MessageSourceAccessor msa) {
        CommonMessage.msa = msa;
    }

    public static String getMessage(String key) {
        return msa.getMessage(key);
    }

    public static String getMessage(String key, String locale) {
        return msa.getMessage(key, new Locale(locale));
    }
}
