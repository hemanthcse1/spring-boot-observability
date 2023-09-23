package com.hemanth.springbootobservability.post.config;

import com.hemanth.springbootobservability.post.JsonPlaceHolderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class ClientConfig {

    @Bean
    JsonPlaceHolderService jsonPlaceHolderService(){
        RestClient restClient =
    }

}
