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
    * POST bank1
    */
    @PostMapping("/bank-1")
    public String bank1(@RequestBody Map<String,String> payload) {
        String card = payload.get("card");
        if(card.equalsIgnoreCase("CC"))
        {
                String url = "http://35.193.37.248/api/payment/network";
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                headers.set("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6Ik5VSTFNRVpHT1RreE5VRXpOalZDTUVSR1FqRkRPVUZDUmtOQk1qUXpOekV4TlVaQlFrWTVPUSJ9.eyJpc3MiOiJodHRwczovL2Rldi05cWxidXBuMy5hdXRoMC5jb20vIiwic3ViIjoiWjlSVmg0Y2NBdTFWUkFFR2pHQlNJZExPeWs1OHQ0cGJAY2xpZW50cyIsImF1ZCI6Imh0dHBzOi8vc2VudGltZW50LWFuYWx5c2lzLmlvIiwiaWF0IjoxNTc2NTY0MjM0LCJleHAiOjE1NzY2NTA2MzQsImF6cCI6Ilo5UlZoNGNjQXUxVlJBRUdqR0JTSWRMT3lrNTh0NHBiIiwiZ3R5IjoiY2xpZW50LWNyZWRlbnRpYWxzIn0.d5VELxj4PyNIEAy4c-WWayEG0V-i4ZCWCCzBGXgCXRiJlrvVcW816F7J2BbzL9Kx7mu5wzXM9PH0FmGrqTjmXvksr1IuHkXOKw26gPpjeCMjU3ySFZAVS3tz0KCqaGxkz0rH78AjuSEZFBtQHs0Gi3HMy352ZkgvtgPbASBkVwIL4ejRIwUhkeLckbMvlOAvqKGL7KatGkRXfoeRd9uUVDVnwhzQxey_Soj0cCw2gqC2Fw2EAbNC5YUVWJHV7dt4nyqPb814HlJ4ijzfXyLFMhOa-1cn25701l8uCQfb_Eu6oR7IX4moBq-ogPZXf_rGJz6s8LFiuzrHNFQoDjL_aA");
                Map<String,String> map=new HashMap<String, String>();
                map.put("status","accept");
                HttpEntity<Map<String, String>> request = new HttpEntity<>(map, headers);
                RestTemplate restTemplate=new RestTemplate();
                ResponseEntity<String> response = restTemplate.postForEntity(url, request , String.class);
                return "Response from network: ("+response.getBody() + ")";
        }
        return "Not a valid card";
    }
}
