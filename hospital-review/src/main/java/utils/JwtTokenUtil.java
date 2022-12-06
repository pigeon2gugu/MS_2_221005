package utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtTokenUtil {

    private static Claims extractClaims(String token, String key) { //map
        return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
    }

    public static String getUserName(String token, String key) {
        return extractClaims(token, key).get("userName").toString();
    }
    public static boolean isExpired(String token, String key) {
        Date expiredDate = extractClaims(token, key).getExpiration(); // expire timestamp를 return함
        return expiredDate.before(new Date()); // 현재보다 전인지 check를 합니다.
    }
    public static String createToken(String userName, String key, long expireTimeMs) {
        Claims claims = Jwts.claims(); // 일종의 map
        claims.put("userName", userName); //token에 담는 정보 : Claim

        return Jwts.builder()
                .setClaims(claims) //인증하고 필요한 덜 민감한 정보들
                .setIssuedAt(new Date(System.currentTimeMillis())) // 언제 만들었는지
                .setExpiration(new Date(System.currentTimeMillis() + expireTimeMs)) // 언제 만료될지
                .signWith(SignatureAlgorithm.HS256, key) // 어떤 secretKey로 sign할지
                .compact();
    }
}
