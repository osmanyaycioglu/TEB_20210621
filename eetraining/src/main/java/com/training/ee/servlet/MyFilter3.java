package com.training.ee.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = {
                           "/tebservlet"
})
public class MyFilter3 implements Filter {

    @Override
    public void doFilter(final ServletRequest requestParam,
                         final ServletResponse responseParam,
                         final FilterChain chainParam) throws IOException, ServletException {
        String isimLoc = requestParam.getParameter("isim");
        if ("abc".equalsIgnoreCase(isimLoc)) {
            PrintWriter writerLoc = responseParam.getWriter();
            writerLoc.print("abc geldi");
        } else {
            chainParam.doFilter(requestParam,
                                responseParam);
        }


    }

}
