package com.multi.sample.common.utils;

import java.util.HashMap;
import java.util.Map;

public class DataUtil {
    public static String getMapToString(Map<String, Object> obj, String key) {
        return getMapToString(obj, key, "");
    }

    public static String getMapToString(Map<String, Object> obj, String key, String defVal) {
        if(obj == null || obj.isEmpty()) {
            return defVal;
        }
        if(obj.containsKey(key)) {
            if( "String".equals(obj.get(key).getClass().getSimpleName()) ) {
                return (String)obj.get(key);
            }
        }
        return defVal;
    }

    public static Integer getMapToInteger(Map<String, Object> obj, String key) {
        return getMapToInteger(obj, key, 0);
    }

    public static Integer getMapToInteger(Map<String, Object> obj, String key, int defVal) {
        if(obj == null || obj.isEmpty()) {
            return defVal;
        }
        if(obj.containsKey(key)) {
            System.out.println(obj.get(key).getClass().getSimpleName());
            if( "Integer".equals(obj.get(key).getClass().getSimpleName()) ) {
                return (Integer)obj.get(key);
            }
        }
        return defVal;
    }

/*    public static void main(String[] args) {
        Map<String, Object> inParam = new HashMap<String, Object>();
        inParam.put("TEST1", "TEST");
        inParam.put("TEST2", 2);
        Map<String, Object> inParam1 = new HashMap<String, Object>();
        inParam1.put("TEST3", "TEST");


        inParam.put("TEST3", inParam1);
        DataUtil.getMapToInteger(inParam, "TEST2", 0);
    }*/
}
