package com.what.cloud.controller;

import com.what.cloud.aop.MyLog;
import com.what.cloud.common.ResponseWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: 王能顺
 * @Date: 2018-8-23 11:59:35
 *
 * 用户登录注册的控制层
 */
@Slf4j
@Api(tags = {"USER REST"}, value = "用户管理")
@RestController
@RequestMapping("user")
public class UserController {

    /**
     * 用户登录
     *
     * @param
     * @return
     */
    @MyLog(value = "用户登录")  //这里添加了AOP的自定义注解
    @ApiOperation(value = "用户登录", notes = "测试用户登录")
    @RequestMapping(value = "login",method=RequestMethod.GET)
    public ResponseWrapper<String> login(String name) {
        ResponseWrapper<String> responseWrapper = new ResponseWrapper<>();
        responseWrapper.setSucc(true);
        responseWrapper.setMsg("登录成功");
        responseWrapper.setContent(name);
        log.info("UserController login success");
        return responseWrapper;
    }

}
