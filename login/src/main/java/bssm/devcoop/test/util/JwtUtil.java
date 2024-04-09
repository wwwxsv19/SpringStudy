package bssm.devcoop.test.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {
    public static String createJwt(Long id, String email, String secretKey, Long exprTime) {
        Claims claims = Jwts.claims();
        claims.put("id", id);
        claims.put("email", email);

        return Jwts
                .builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + exprTime))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }
}
