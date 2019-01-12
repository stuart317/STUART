package com.sgyy.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.sgyy.common.utils.StringUtils;
import com.sgyy.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 版权所有：宝润兴业科技股份有限公司
 * 类描述：${DESCRIPTION}
 * 创建时间：2018/4/28 15:32
 *
 * @author 朱超
 */
@Service
public class HelloServiceImpl implements HelloService{

    private static Logger log = LoggerFactory.getLogger(HelloServiceImpl.class);

    public String sayHello(String str) throws Exception {
        log.info("dubbo服务 [sayHello]----传入参数："+str);
        if(StringUtils.isNull(str)){
            throw new Exception("速度速度发");
        }
        return "给你的爱一直很安静---"+str;
    }
}
