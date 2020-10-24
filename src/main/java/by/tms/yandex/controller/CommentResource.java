package by.tms.yandex.controller;

import by.tms.yandex.entity.Comment;
import by.tms.yandex.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/comment")
public class CommentResource {

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping (path = "/getAllByPostId")
    public ResponseEntity<Optional<List<Comment>>> getAllByPostId(@RequestParam long postId){
        return ResponseEntity.ok(commentRepository.findCommentByPostId(postId));
    }

    @PostMapping (path = "/add")
    public ResponseEntity<Comment> add(@RequestBody Comment comment){
        Comment newComment = commentRepository.save(comment);
        return new ResponseEntity(newComment, HttpStatus.CREATED);
    }

}
