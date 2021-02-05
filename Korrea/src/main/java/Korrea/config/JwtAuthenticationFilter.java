package Korrea.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import Korrea.config.JwtTokenUtil;
import Korrea.services.UserService;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String token = getTokenFromRequest(request);
			//System.out.println(token);
			if(token != null && jwtTokenUtil.validateToken(token) ) {
				String userName = jwtTokenUtil.getUserName(token);
				UserDetails userDetails = this.userService.loadUserByUsername(userName);
				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userName, null, userDetails.getAuthorities());
				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authToken);
			}
		}catch(Exception e) {
			System.out.println(e);
			System.out.println("Could not set user authentication in security context");
		}
		filterChain.doFilter(request, response);
	}
	
	public String getTokenFromRequest(HttpServletRequest request) {
		
		String token = request.getHeader("Authorization");
		if(token != null && token.startsWith("Bearer ")) {
			return token.substring(7);
		}
		
		return null;
	}

}
