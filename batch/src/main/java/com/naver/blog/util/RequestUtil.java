package com.naver.blog.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RequestUtil {

    public static String restHttpPostRequest(String requestUrl, Object params){
//    	log.info("requestUrl : " + requestUrl);
        
		//RestTemplate 초기화
		RestTemplate restTemplate = new RestTemplate();
    	
    	HttpHeaders headers = new HttpHeaders();
    	headers.set("X-USER-ID", "1");      

    	HttpEntity<Object> request = new HttpEntity<>(params, headers);

    	String result = restTemplate.postForObject(requestUrl, request, String.class); 
		
		return result;
	}
 }
