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

/**
 * Run on every Authenticated endpoint to check if a user's JWT token is valid
 * and authenticated.
 */

public class JWTAuthenticationFilter extends GenericFilterBean {

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
      throws IOException, ServletException {

    Authentication authentication = AuthTokenService.getAuthentication((HttpServletRequest)request);

    SecurityContextHolder.getContext().setAuthentication(authentication);
    filterChain.doFilter(request,response);
  }
}
