package com.hjf.swaggerFoxdemo;

import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "测试ControllerTest", tags = {"测试访问接口"})
@RequestMapping("/test")
public class ControllerTest {

    @ApiOperation(value = "添加测试数据")
    @PostMapping("/insert")
    @ApiResponses(value = {
            @ApiResponse(code = 1000, message = "成功"),
            @ApiResponse(code = 1001, message = "失败"),
            @ApiResponse(code = 1002, message = "缺少参数",
                    response = TestUser.class)
    })
    public String insertInfo(@ApiParam("用户名字") @RequestParam("userName") String userName,
                             @ApiParam(value = "年龄", allowEmptyValue = true) @RequestParam("age") Integer age) {

        String username = userName;
        Integer Age = age;
        return username + age.toString();
    }
}
