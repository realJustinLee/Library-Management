package com.library.filter;

import com.library.service.book.UserWokeService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Date: Created in 2018/4/10 14:21
 * @Description: 权限管理的过滤器，用户不能登录manage
 */
public class PermissionFilter implements Filter {
    @Autowired
    UserWokeService userWokeService;

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //获浏览器的cookie
        Cookie[] cookies = ((HttpServletRequest) servletRequest).getCookies();
        //请求路径
        String url = ((HttpServletRequest) servletRequest).getRequestURI();
        for (Cookie cookie : cookies) {
            //如果存在存储用户信息的cookie,说明已经登陆过,再判断权限
            if ("userId".equals(cookie.getName())) {
                String userId = cookie.getValue();
                Object[] params = new Object[]{userId};
                //获取用户角色
                try {
                    Map map = userWokeService.userInfo(params);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
//                if("/")
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
        }
        //不存在存储用户登录过的信息，跳转登录页面
//        ((HttpServletResponse) servletResponse).sendRedirect("/forbidden");
        //没登陆过直接放行
        filterChain.doFilter(servletRequest,servletResponse);
    }

    public void destroy() {

    }
}
