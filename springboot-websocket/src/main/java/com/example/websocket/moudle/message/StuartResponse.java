package com.example.websocket.moudle.message;

/**
 * 版权所有：宝润兴业科技股份有限公司
 * 类描述：服务端向浏览器发送的此类的消息
 * 创建时间：2018/9/24 17:43
 *
 * @author 朱超
 */
public class StuartResponse {

    private String responseMessage;

    public StuartResponse(String responseMessage){
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage(){
        return responseMessage;
    }

}
