package com.howtodoinjava.example.apigateway.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@Api(value = "Swagger2DemoRestController", description = "REST Apis related to film Entity!!!!")
public class Controller {

    @Autowired
    RestTemplate restTemplate;

    @ApiOperation(value = "Get film", response = String.class, tags = "filmDetails")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Suceess|OK"), @ApiResponse(code = 401, message = "not authorized!"), @ApiResponse(code = 403, message = "forbidden!!!"), @ApiResponse(code = 404, message = "not found!!!") })
    @RequestMapping(value = "/filmDetails/{filmName}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public String getFilms(@PathVariable int filmName)
    {
        System.out.println("Getting Film details for " + filmName);

        String response = restTemplate.exchange("http://my-movie/findFilmDetails/{filmName}",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, filmName).getBody();

        System.out.println("Response Body " + response);

        return "Film Name -  " + filmName + " [ Film Details " + response+" ]";
    }

    public String  fallbackMethod1(String filmName){

        return "Fallback response:: No film details available temporarily";
    }

    @ApiOperation(value = "Get acteur", response = String.class, tags = "acteurDetails")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Suceess|OK"), @ApiResponse(code = 401, message = "not authorized!"), @ApiResponse(code = 403, message = "forbidden!!!"), @ApiResponse(code = 404, message = "not found!!!") })
    @RequestMapping(value = "/acteurDetails/{acteurName}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public String getActeurs(@PathVariable int acteurName)
    {
        System.out.println("Getting Acteur details for " + acteurName);

        String response = restTemplate.exchange("http://my-movie/findActeurDetails/{acteurName}",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, acteurName).getBody();

        System.out.println("Response Body " + response);

        return "Acteur Name -  " + acteurName + " [ Acteur Details " + response+" ]";
    }

    public String  fallbackMethod2(String acteurName){

        return "Fallback response:: No acteur details available temporarily";
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}