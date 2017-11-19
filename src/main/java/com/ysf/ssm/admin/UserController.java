package com.ysf.ssm.admin;

import com.ysf.ssm.common.Result;
import com.ysf.ssm.common.ResultGenerator;
import com.ysf.ssm.entity.PageBean;
import com.ysf.ssm.entity.User;
import com.ysf.ssm.service.UserService;
import com.ysf.ssm.util.MD5Util;
import com.ysf.ssm.util.ResponseUtil;
import com.ysf.ssm.util.StringUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create by Tars on 2017/11/18
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @Resource
    private UserService userService;
    private static final Logger log = Logger.getLogger( UserController.class );

    @RequestMapping(value = "/cookie", method = RequestMethod.POST)
    @ResponseBody
    public Result login(User user) {
        /**
         * 这里设置进行密码加密
         */
        try {
            String MD5pwd = MD5Util.MD5Encode( user.getPassword(), "UTF-8" );
            user.setPassword( MD5pwd );
        } catch (Exception e) {
            //出现异常则密码为空
            user.setPassword( "" );
        }
        User resultUser = userService.login( user );
        log.info( "request:user/login,user:" + user.toString() );
        if (resultUser == null) {
            return ResultGenerator.genFailResult( "请认真核对账号密码" );
        } else {
            resultUser.setPassword( "PASSWARD" );
            Map data = new HashMap();
            data.put( "currentUser", resultUser );
            return ResultGenerator.genSuccessResult( data );
        }
    }

    @RequestMapping(value = "/datagrid", method = RequestMethod.POST)
    public String list(@RequestParam(value = "page", required = false) String page, @RequestParam(value = "rows", required = false) String rows, User s_user, HttpServletResponse response) throws Exception {
        PageBean pageBean = new PageBean( Integer.parseInt( page ), Integer.parseInt( rows ) );
        Map<String, Object> map = new HashMap<String, Object>();
        map.put( "userName", StringUtil.formatLike( s_user.getUsername() ) );
        map.put( "start", pageBean.getStart() );
        map.put( "size", pageBean.getPageSize() );
        List<User> userList = userService.findUser( map );
        Long total = userService.getTotalUser( map );
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject( userList );
        result.put( "rows", jsonArray );
        result.put( "total", total );
        log.info( "request: user/list , map: " + map.toString() );
        ResponseUtil.write( response, result );
        return null;
    }
}
