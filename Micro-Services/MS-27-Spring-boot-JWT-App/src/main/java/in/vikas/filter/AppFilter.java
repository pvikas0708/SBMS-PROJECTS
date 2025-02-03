package in.vikas.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import in.vikas.service.JwtService;
import in.vikas.service.MyUserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component  					//abstract class have dofilterinternal method
public class AppFilter extends OncePerRequestFilter {

	@Autowired
	private JwtService jwt;
	
	@Autowired
	private MyUserDetailsService userDtlsSvc;
	
	@Override //just invoked once per request within a single request thread.
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		//-check Autherization header presence or not.
		String token = request.getHeader("Autherization");
		String username=null;
		
		if(token!=null && token.startsWith("Bearer"))  //The format how token will go to server ,Key=Autherization & Value = Bearer<token>
						                               // out of which Bearer to token space is 7 space which we don't want so delete it
		{
			token=token.substring(7); //to get actual token 
									  // to validate the token inject JwtService
			 username = jwt.extractUsername(token);
		}
		//when token is valid then update security context to process the request to process request.
	
		 if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

	            UserDetails userDetails = this.userDtlsSvc.loadUserByUsername(username);

	            if (jwt.validateToken(token, userDetails))
	            {

	                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
	                        userDetails, null, userDetails.getAuthorities());
	                usernamePasswordAuthenticationToken
	                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
	                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
	            }
		 }
		 	filterChain.doFilter(request, response);
		 
		 }
	
	
}
