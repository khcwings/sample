package com.multi.sample.common.utils;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class HttpServletRequestUtil {

    public static String getClientIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");

        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        return ip;
    }

    public static String getClientBrowser(HttpServletRequest request) {
        String browser 	 = "";
        String userAgent = request.getHeader("User-Agent");

        if(userAgent == null || userAgent.length() < 1) {
            return browser;
        }

        if(userAgent.indexOf("Trident") > -1 || userAgent.indexOf("MSIE") > -1) {	        // IE
            if(userAgent.indexOf("Trident/7") > -1) {
                browser = "IE 11";
            } else if(userAgent.indexOf("Trident/6") > -1) {
                browser = "IE 10";
            } else if(userAgent.indexOf("Trident/5") > -1) {
                browser = "IE 9";
            } else if(userAgent.indexOf("Trident/4") > -1) {
                browser = "IE 8";
            } if(userAgent.indexOf("edge") > -1) {
                browser = "IE Edge";
            }
        } else if(userAgent.indexOf("Whale") > -1) { 										// Naver Whale
            browser = "Naver Whale";
        } else if(userAgent.indexOf("Opera") > -1 || userAgent.indexOf("OPR") > -1) { 		// Opera
            browser = "Opera";
        } else if(userAgent.indexOf("Firefox") > -1) { 										 // Firefox
            browser = "Firefox";
        } else if(userAgent.indexOf("Safari") > -1 && userAgent.indexOf("Chrome") == -1 ) {	 // Safari
            browser = "Safari/";
        } else if(userAgent.indexOf("Chrome") > -1) {										 // Chrome
            browser = "Chrome";
        }

        return browser;
    }

    public static String getClientOs(HttpServletRequest request) {
        String os = "";
        String userAgent = request.getHeader("User-Agent");

        if(userAgent == null || userAgent.length() < 1) {
            return os;
        }

        if(userAgent.indexOf("Windows") > -1) {
            os = "Windows";
        } else if(userAgent.indexOf("Android") > -1) {
            os = "Android";
        } else if(userAgent.indexOf("iPhone") > -1) {
            os = "iPhone";
        } else if(userAgent.indexOf("iPad") > -1) {
            os = "iPad";
        } else if(userAgent.indexOf("iOS") > -1) {
            os = "iPhone/iPad/iPod";
        } else if(userAgent.indexOf("Max OS") > -1) {
            os = "Max";
        } else if(userAgent.indexOf("Linux") > -1) {
            os = "Linux";
        } else if(userAgent.indexOf("Macintosh") > -1) {
            os = "Macintosh";
        }
        return os;
    }

    public static String getClientWebType(HttpServletRequest request) {
        String userAgent = request.getHeader("User-Agent");

        // 모바일 기종 체크
        boolean isMobile = userAgent.matches(".*(iPhone|iPod|iPad|BlackBerry|Android|Windows CE|LG|MOT|SAMSUNG|SonyEricsson).*");

        // IOS_APP, ANDROID_APP 앱 특정 변수(변동)
        if(userAgent.indexOf("IOS_APP") > -1 || userAgent.indexOf("ANDROID_APP") >-1){
            return "APP";
        }else if(isMobile){
            return "MOBILE";
        }else {
            return "WEB";
        }
    }

    public static String getRequestParamMapToString(HttpServletRequest request) {
        Map<String, String[]> paramMap = request.getParameterMap();

        return paramMap.entrySet().stream()
                .map(entry -> String.format("%s : %s",
                        entry.getKey(), Arrays.toString(entry.getValue())))
                .collect(Collectors.joining(", "));
    }
}
