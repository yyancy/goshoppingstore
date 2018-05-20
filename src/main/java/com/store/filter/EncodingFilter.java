package com.store.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;


@WebFilter(displayName = "encoding",urlPatterns = "/*",
initParams = {
        @WebInitParam(name="encoding",value = "UTF-8")
})
public class EncodingFilter implements Filter {
    private String encoding ;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encoding = filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        HttpServletResponse httpServletResponse =(HttpServletResponse)response;
        httpRequest.setCharacterEncoding(encoding);
        httpServletResponse.setCharacterEncoding(encoding);
        chain.doFilter(new MyRequest(httpRequest),httpServletResponse);
    }

    @Override
    public void destroy() {

    }


     class MyRequest extends HttpServletRequestWrapper {

        private HttpServletRequest request;


        MyRequest(HttpServletRequest request) {
             super(request);
             this.request = request;
         }


         @Override
         public String getParameter(String name) {
             String value = request.getParameter(name);
             if (value == null) {
                 return  null;
             }
             if (!request.getMethod().equalsIgnoreCase("get")){
                 return value;
             }
             try {
                 value = new String(value.getBytes(),encoding);
             } catch (UnsupportedEncodingException e) {
                logger.error(e.getMessage(),e);
             }
             return value;
         }
     }
}
