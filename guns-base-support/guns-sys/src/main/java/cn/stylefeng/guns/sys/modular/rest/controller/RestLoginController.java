/**
 * Copyright 2018-2020 stylefeng & fengshuonan (https://gitee.com/stylefeng)
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.stylefeng.guns.sys.modular.rest.controller;

import cn.stylefeng.guns.base.auth.service.AuthService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.util.ToolUtil;
import cn.stylefeng.roses.kernel.model.exception.RequestEmptyException;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import cn.stylefeng.roses.kernel.model.response.SuccessResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * rest方式的登录控制器
 *
 * @author fengshuonan
 * @Date 2017年1月10日 下午8:25:24
 */
@Controller
@RequestMapping("/rest")
@Api(tags = "系统登录")
public class RestLoginController extends BaseController {

    @Resource
    private AuthService authService;

    /**
     * 点击登录执行的动作
     *
     * @author fengshuonan
     * @Date 2018/12/23 5:42 PM
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("登录接口")
    public ResponseData restLogin(@RequestParam("username") String username,
                                  @RequestParam("password") String password) {

        if (ToolUtil.isOneEmpty(username, password)) {
            throw new RequestEmptyException("账号或密码为空！");
        }

        //登录并创建token
        String token = authService.login(username, password);

        return new SuccessResponseData(token);
    }

    /**
     * 退出接口
     *
     * @author fengshuonan
     * @Date 2020/2/16 22:26
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("退出接口")
    public ResponseData logout() {
        authService.logout();
        return new SuccessResponseData();
    }
}