package com.hemanth.springbootobservability.post;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final JsonPlaceHolderService jsonPlaceHolderService;

    public PostController(JsonPlaceHolderService jsonPlaceHolderService) {
        this.jsonPlaceHolderService = jsonPlaceHolderService;
    }

    @GetMapping("")
    List<Post> findAll() {
        return jsonPlaceHolderService.findAll();
    }

    @GetMapping("/{id}")
    Post findByID(@PathVariable Integer id){
        return jsonPlaceHolderService.findById(id);
    }
}
