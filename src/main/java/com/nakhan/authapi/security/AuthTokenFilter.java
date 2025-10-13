package com.nakhan.authapi.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthTokenFilter extends OncePerRequestFilter {

    private JwtUtils jwtUtils;

    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    public void setJwtUtils(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    @Autowired
    public void setUserDetailsService(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        logger.info("=== AuthTokenFilter INVOKED ===");
        logger.info("Request: {} {}", request.getMethod(), request.getRequestURI());
        logger.info("Authorization header: {}", request.getHeader("Authorization"));

        try {
            String jwt = parseJwt(request);
            logger.info("JWT token parsed: {}", jwt != null ? "present" : "null");

            if (jwt != null) {
                logger.info("JWT token length: {}", jwt.length());

                if (jwtUtils != null) {
                    logger.info("JwtUtils is available");
                    boolean isValid = jwtUtils.validateJwtToken(jwt);
                    logger.info("JWT token validation result: {}", isValid);

                    if (isValid) {
                        String username = jwtUtils.getUserNameFromJwtToken(jwt);
                        logger.info("Valid JWT for user: {}", username);

                        if (userDetailsService != null) {
                            logger.info("Loading user details for: {}", username);
                            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                            logger.info("User details loaded: {}", userDetails.getUsername());

                            UsernamePasswordAuthenticationToken authentication =
                                new UsernamePasswordAuthenticationToken(userDetails,
                                                                       null,
                                                                       userDetails.getAuthorities());
                            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                            SecurityContextHolder.getContext().setAuthentication(authentication);
                            logger.info("Authentication set successfully for user: {}", username);
                        } else {
                            logger.error("UserDetailsService is null");
                        }
                    } else {
                        logger.warn("JWT token is invalid");
                    }
                } else {
                    logger.error("JwtUtils is null");
                }
            } else {
                logger.debug("No JWT token found in request");
            }
        } catch (Exception e) {
            logger.error("Cannot set user authentication: {}", e.getMessage());
            e.printStackTrace();
        }

        logger.info("Continuing filter chain...");
        filterChain.doFilter(request, response);
    }

    private String parseJwt(HttpServletRequest request) {
        String headerAuth = request.getHeader("Authorization");

        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
            return headerAuth.substring(7);
        }

        return null;
    }
}
