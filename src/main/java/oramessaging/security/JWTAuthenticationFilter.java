package oramessaging.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.security.core.Authentication;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import oramessaging.security.AuthTokenService;

public class JWTAuthenticationFilter extends GenericFilterBean {

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
      throws IOException, ServletException {

    Authentication authentication = AuthTokenService.getAuthentication((HttpServletRequest)request);

    SecurityContextHolder.getContext().setAuthentication(authentication);
    System.out.println(request);
    filterChain.doFilter(request,response);
  }
}
