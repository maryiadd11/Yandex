package by.tms.yandex.controller;

import by.tms.yandex.entity.Post;
import by.tms.yandex.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping (path = "/post")
public class PostResource {

    @Autowired
    private PostRepository postRepository;

    @GetMapping (path = "/getAll")
    public ResponseEntity<List<Post>> getAllPosts(){
        return ResponseEntity.ok(postRepository.findAll());
    }

    @GetMapping (path = "/getById")
    public Optional<Post> getById(@RequestParam long id){
        return postRepository.findById(id);
    }

    @PostMapping (path = "/add")
    public ResponseEntity<Post> addPost(@RequestBody Post post){
        Post newPost = postRepository.save(post);
        return new ResponseEntity(newPost, HttpStatus.CREATED);
    }

}
