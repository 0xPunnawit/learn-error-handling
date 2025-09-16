package com.punnawit.error_handling.common.config;

import com.punnawit.error_handling.dto.response.SessionUserPrincipal;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class SessionAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        var context = SecurityContextHolder.getContext();

        if (context.getAuthentication() == null) {
            var session = request.getSession(false);
            if (session != null) {
                Object userId = session.getAttribute("USER_ID");
                Object email  = session.getAttribute("USER_EMAIL");

                if (userId != null && email != null) {
                    var principal = new SessionUserPrincipal(
                            (userId instanceof Long) ? (Long) userId : Long.valueOf(userId.toString()),
                            email.toString()
                    );

                    var auth = new UsernamePasswordAuthenticationToken(
                            principal,
                            null,
                            List.of() // ยังไม่ใช้ role/authority
                    );
                    context.setAuthentication(auth);
                }
            }
        }

        filterChain.doFilter(request, response);
    }
}
