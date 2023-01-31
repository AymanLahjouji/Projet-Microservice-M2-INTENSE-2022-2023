package com.howtodoinjava.example.apigateway.configuration;


import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


//TODO this is a configuration class, put right annotation
class ActuatorSecurityConfig extends WebSecurityConfigurerAdapter {



    @Override
    protected void configure(HttpSecurity http) {
        // TODO impl security component based in top commentary
    }
}