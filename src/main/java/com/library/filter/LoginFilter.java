package com.library.filter;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description: 过滤未登录的ur
 */
public class LoginFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //获浏览器的cookie
        Cookie[] cookies = ((HttpServletRequest) servletRequest).getCookies();
        if (cookies == null) {
            ((HttpServletResponse) servletResponse).sendRedirect("/");
            return;
        }
        for (Cookie cookie : cookies) {
            //如果存在存储用户信息的cookie,说明已经登陆过，直接放行
            if ("userId".equals(cookie.getName())) {
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
        }
        //不存在存储用户登录过的信息，跳转登录页面
        ((HttpServletResponse) servletResponse).sendRedirect("/");
    }

    public void destroy() {

    }
}
