package com.tlias.filter;

import jakarta.servlet.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

//@WebFilter(urlPatterns ="/*")
@Slf4j
public class DemoFilter implements Filter {
    @Override //初始化方法, 只调用一次
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("init 初始化方法执行了");
    }
    @Override //拦截到请求之后调用, 调用多次
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("Demo 拦截到了请求...放行前逻辑");
        //放行
        chain.doFilter(request,response);
        log.info("Demo 拦截到了请求...放行后逻辑");
    }
    @Override //销毁方法, 只调用一次
    public void destroy() {
        log.info("destroy 销毁方法执行了");
    }
}