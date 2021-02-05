package Korrea.config;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtTokenUtil {
	
	@Value("${jwt.secret}")
	private String secretKey;
	
	public static final int EXPIRATION  = 1000*1000*60;
	
	//private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);
	
	
	public String generateToken(String username) {
		Date now = new Date();
		String token = Jwts.builder()
				.setSubject(username)
				.signWith(SignatureAlgorithm.HS512, this.secretKey)
				.setIssuedAt(now)
				.setExpiration(new Date(now.getTime() + EXPIRATION)).compact();
		return token;
	}
	
	public String getUserName(String token) {
		Claims claim = Jwts.parser()
				.setSigningKey(this.secretKey)
				.parseClaimsJws(token)
				.getBody();
		
		return claim.getSubject();
	}
	
	public boolean validateToken(String token) {
		System.out.println(token);
		try {
			Jwts.parser().setSigningKey(this.secretKey).parseClaimsJws(token);
			return true;
		}catch (SignatureException ex) {
            System.out.println("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
        	System.out.println("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
        	System.out.println("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
        	System.out.println("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
        	System.out.println("JWT claims string is empty.");
        }
        return false;
	}


}
