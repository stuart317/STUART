package com.sgyy.common.utils;

/**
 * 版权所有：宝润兴业科技股份有限公司
 * 类描述：${DESCRIPTION}
 * 创建时间：2018/4/28 9:22
 *
 * @author 朱超
 */
public class StringUtils {

    //字符串 为空判断
    public static boolean isNull(String str){

        if(null == str || "".equals(str) || "null".equalsIgnoreCase(str)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isNull(""));
    }
}
