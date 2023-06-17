package pl.mirekgab.myproject.security;

import javax.servlet.*;
import java.io.IOException;

public class JwtAuthorizationFilter implements Filter {
    public JwtAuthorizationFilter(String secret) {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
