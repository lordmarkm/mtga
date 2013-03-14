package com.mtga.web.utils;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class ControllerUtils {

    /**
     * @Returns one of the following, in order of preference:
     * <ol>
     *   <li>Principal's name
     *   <li>True remote addr ("x-forwarded-for" header)
     *   <li>Remote addr (might be proxy IP)
     * </ol>
     */
    public static String name(HttpServletRequest request, Principal principal) {
        return principal != null ? principal.getName() : request.getHeader("x-forwarded-for") != null ? request.getHeader("x-forwarded-for") : request.getRemoteAddr();    
    }

    public static HttpHeaders imageHeader() {
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return headers;
    }
    
}
