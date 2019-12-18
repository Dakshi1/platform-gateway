package com.sa.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * PaymentResource controller
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/payment")
public class SentimentController {

    @PostMapping("/print-me")
    public String printMe() {
        return "Hello World";
    }

    private final Logger log = LoggerFactory.getLogger(SentimentController.class);
        
    /**
     * PlatformResource controller
     */
    @PostMapping("/payment")
    public String payment(@RequestBody Map<String,String> payload) {
        String card = payload.get("cardType");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6Ik5VSTFNRVpHT1RreE5VRXpOalZDTUVSR1FqRkRPVUZDUmtOQk1qUXpOekV4TlVaQlFrWTVPUSJ9.eyJpc3MiOiJodHRwczovL2Rldi05cWxidXBuMy5hdXRoMC5jb20vIiwic3ViIjoiWjlSVmg0Y2NBdTFWUkFFR2pHQlNJZExPeWs1OHQ0cGJAY2xpZW50cyIsImF1ZCI6Imh0dHBzOi8vc2VudGltZW50LWFuYWx5c2lzLmlvIiwiaWF0IjoxNTc2NjU1MDA4LCJleHAiOjE1NzY3NDE0MDgsImF6cCI6Ilo5UlZoNGNjQXUxVlJBRUdqR0JTSWRMT3lrNTh0NHBiIiwiZ3R5IjoiY2xpZW50LWNyZWRlbnRpYWxzIn0.t3zr4SPajaTYV-UvsFtX-VktMTQJSloKTsqOoELL0uTcCXy7AKvuEt3fGR_uqfVt42x_4HNQEDXorBk_pv-qyVzKWebYczw9zyyoDvo-iwZrGR3R1fRTQLPieatXpkGmLyTslkDgkHOjTS7Bl8qb1DowqpW3Ve0Rygw-q2P7QlkfN_JorrWowHFZG1dHcx6-QGbl_Ptw3mB9N8d53yoj8-Jpf-yLEQFDNevbVZlH1cUPbCx9RsZiW_hbn5S47BVY9C_nNk1PZGfCpBdgJwEOZJ65mxIcWQgygmbqRKFSXO1uEU5ldWi0YWpbJfBlWlRjrg7Uuua-J3O4xd58lNnpQQ");
        Map<String,String> map=new HashMap<String, String>();
        map.put("card",card);
        String url = "http://35.239.195.224/api/payment/bank-1";
        HttpEntity<Map<String, String>> request = new HttpEntity<>(map, headers);
        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(url, request , String.class);
        return "Response from acquiring bank: ( "+response.getBody() + " )";
    }

}
