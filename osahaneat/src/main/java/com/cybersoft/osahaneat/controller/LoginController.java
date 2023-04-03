package com.cybersoft.osahaneat.controller;


import com.cybersoft.osahaneat.payload.ResponsePayload;
import com.cybersoft.osahaneat.utils.JwtUtilsHelpers;
import com.google.gson.Gson;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;
import java.util.ArrayList;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtilsHelpers jwtUtilsHelpers;

    @PostMapping("/signin")
    public ResponseEntity<?> signin(
                            @RequestParam String username,
                            @RequestParam String password
                            ) {

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
        //
        Authentication authentication = authenticationManager.authenticate(token);
        SecurityContext securityContext = SecurityContextHolder.getContext();
        securityContext.setAuthentication(authentication);
        // Tao key cho jwt
//        SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
//        String jwtKey = Encoders.BASE64.encode(secretKey.getEncoded());
        //
        Gson gson = new Gson();
        String data = gson.toJson(authentication);
        //
        ResponsePayload responsePayload = new ResponsePayload();
        responsePayload.setData(jwtUtilsHelpers.generateToken(data));

        return new ResponseEntity<>(responsePayload, HttpStatus.OK);
    }

    @PostMapping("/signup")
//    @PreAuthorize("hasAnyAuthority('ADMIN')") // trong co nhay kep thi sai nhay don
    public ResponseEntity<?> signup() {

        return new ResponseEntity<>("Heloo", HttpStatus.OK);
    }

}
