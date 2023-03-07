package org.serf.magazineshop.filter;

import org.serf.magazineshop.domain.UserRole;
import org.serf.magazineshop.shared.FilterService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Arrays;

@WebFilter("/createProduct.jsp")
public class CreateProductFilter implements Filter {
    private FilterService filterService = FilterService.getFilterService();

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        filterService.doFilterValidation(request, response, chain, Arrays.asList(UserRole.ADMINISTRATOR));
    }

    public void init(FilterConfig fConfig) throws ServletException {
    }
}
