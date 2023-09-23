package com.hemanth.springbootobservability;

import com.hemanth.springbootobservability.post.JsonPlaceHolderService;
import com.hemanth.springbootobservability.post.Post;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import io.micrometer.observation.annotation.Observed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringBootObservabilityApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringBootApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootObservabilityApplication.class, args);
        System.out.println("Hello spring boot observability");
    }


   /* @Bean
    CommandLineRunner commandLineRunner(JsonPlaceHolderService jsonPlaceHolderService){
        return args -> {
            List<Post> all = jsonPlaceHolderService.findAll();
            log.info("All Posts: {}",all.size());
        };
    }*/


   /* @Bean
    CommandLineRunner commandLineRunner(JsonPlaceHolderService jsonPlaceHolderService, ObservationRegistry observationRegistry) {
        return args -> {
            Observation.createNotStarted("posts.load-all-posts", observationRegistry)
                    .lowCardinalityKeyValue("author", "Hemanth")
                    .contextualName("post-service.find-all")
                    .observe(jsonPlaceHolderService::findAll);
        };
    }*/


    @Bean
    @Observed(name = "posts.load-all-posts",contextualName = "post.find-all")
    CommandLineRunner commandLineRunner(JsonPlaceHolderService jsonPlaceHolderService, ObservationRegistry observationRegistry) {
        return args -> {
            jsonPlaceHolderService.findAll();
        };
    }


}
