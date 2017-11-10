package com.perfect.team.business.auth.from.prod;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class TokenAuthenticationFilter  extends OncePerRequestFilter {

    private AntPathMatcher matcher = new AntPathMatcher();

    private List<String> patterns = Arrays.asList(
            "/v1/devices/{deviceLibraryIdentifier}/registrations/{passTypeIdentifier}/{serialNumber}",
            "/v1/passes/{passTypeIdentifier}/{serialNumber}"
    );

    @Override
    public void doFilterInternal(HttpServletRequest req, HttpServletResponse res,
                         FilterChain chain) throws IOException, ServletException {
        String authHeader = req.getHeader("Authorization");
        if (authHeader != null) {
            if ((authHeader.startsWith("ApplePass ") || authHeader.startsWith("AndroidPass "))) {
                String[] authHeaderSplit = authHeader.split(" ");
                String token = authHeaderSplit[1];
                Map<String, String> pathParams = verifyPathAndExtractParams(req.getServletPath());
                if (pathParams != null) {
                    if (StringUtils.isEmpty(token)) {
                        SecurityContextHolder.getContext().setAuthentication(new TokenAuthentication(null));
                    } else {
                        Authentication auth = new TokenAuthentication(token, pathParams.get("passTypeIdentifier"), pathParams.get("serialNumber"));
                        SecurityContextHolder.getContext().setAuthentication(auth);
                    }
                }
            }
            if (authHeader.startsWith("Basic ")) {
                String[] headerDecoded = extractAndDecodeHeader(authHeader);
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(headerDecoded[0], headerDecoded[1]);
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }

        chain.doFilter(req, res);
    }


    private Map<String,String> verifyPathAndExtractParams(String path) {
        for(String pattern : patterns) {
            if (matcher.match(pattern, path)) {
                return matcher.extractUriTemplateVariables(pattern, path);
            }
        }
        return null;
    }

    private String[] extractAndDecodeHeader(String header) throws IOException {
        byte[] base64Token = header.substring(6).getBytes("UTF-8");

        byte[] decoded;
        try {
            decoded = Base64.decode(base64Token);
        } catch (IllegalArgumentException e) {
            throw new BadCredentialsException("Failed to decode basic authentication token");
        }

        String token = new String(decoded);
        int delim = token.indexOf(":");
        if(delim == -1) {
            throw new BadCredentialsException("Invalid basic authentication token");
        } else {
            return new String[]{token.substring(0, delim), token.substring(delim + 1)};
        }
    }

}
