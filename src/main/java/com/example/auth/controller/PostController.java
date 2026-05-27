package com.example.auth.controller;

import com.example.auth.model.Post;
import com.example.auth.model.User;
import com.example.auth.payload.request.PostRequest;
import com.example.auth.payload.response.MessageResponse;
import com.example.auth.payload.response.PostResponse;
import com.example.auth.repository.PostRepository;
import com.example.auth.repository.UserRepository;
import com.example.auth.security.services.UserDetailsImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<?> createPost(@Valid @RequestBody PostRequest postRequest) {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findById(userDetails.getId()).orElse(null);

        if (user == null) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: User not found!"));
        }

        Post post = new Post(postRequest.getDescription(), postRequest.getPhoto(), user);
        postRepository.save(post);

        return ResponseEntity.ok(new MessageResponse("Post created successfully!"));
    }

    @GetMapping
    public ResponseEntity<List<PostResponse>> getAllPosts() {
        List<Post> posts = postRepository.findAllByOrderByCreatedAtDesc();
        
        List<PostResponse> postResponses = posts.stream().map(post -> new PostResponse(
                post.getId(),
                post.getDescription(),
                post.getPhoto(),
                post.getCreatedAt(),
                post.getUser().getName(),
                post.getUser().getPhoto()
        )).collect(Collectors.toList());

        return ResponseEntity.ok(postResponses);
    }
}
