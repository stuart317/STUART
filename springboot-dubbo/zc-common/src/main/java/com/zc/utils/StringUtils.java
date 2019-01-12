package com.zc.utils;

/**
 * 版权所有：宝润兴业科技股份有限公司
 * 类描述：${DESCRIPTION}
 * 创建时间：2019/1/9 22:52
 *
 * @author 朱超
 */
public class StringUtils {

    /**
     * 判断字符串是否为 null
     * @param str
     * @return
     */
    public static boolean isEmtry(String str){

        if(str == null || str.length()==0 || "null".equalsIgnoreCase(str)){
            return true;
        }
        return false;
    }

    /**
     * 判断字符串是否为数字
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        if(isEmtry(str)){
            return false;
        }
        for (int i = str.length(); --i >= 0; ) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }


}
