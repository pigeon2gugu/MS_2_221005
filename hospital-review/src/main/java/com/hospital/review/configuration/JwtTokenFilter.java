package com.hospital.review.configuration;

import com.hospital.review.domain.User;
import com.hospital.review.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;
import utils.JwtTokenUtil;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


//OncePerRequestFilter : 입장시마다 티켓을 보여주는 형식. api기 때문에 누가 요청할 지 모르기 때문에.
@RequiredArgsConstructor
public class JwtTokenFilter extends OncePerRequestFilter {

    private final UserService userService;
    private final String secretKey;

    //권한 주거나 안주기
    //권한 안주는 경우 (토큰 x, 유효하지 않은 토큰(적절하지 않은것, 만료된것))
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        final String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION); //헤더에 토큰을 넘긴 것을 가져옴.
        
        //token이 없는 경우
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        //token 분리 성공 실패
        String token;
        try {
            token = authorizationHeader.split(" ")[1];
        } catch (Exception e) {
            filterChain.doFilter(request, response);
            return;
        }

        //만료 여부
        if(JwtTokenUtil.isExpired(token, secretKey)) { //만료가 true이면,
            filterChain.doFilter(request, response);
            return;
        };

        // UserDetail가져오기
        // Token에서 UserName꺼내기 (JwtTokenUtil에서 Claim에서 꺼냄)
        String userName = JwtTokenUtil.getUserName(token, secretKey);
        User user = userService.getUserByUserName(userName);

        //권한 주기. Role 바인딩
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(), null
        , List.of(new SimpleGrantedAuthority(user.getRole().name())));
        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request)); //권한 부여
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request,response);
        
    }

}
