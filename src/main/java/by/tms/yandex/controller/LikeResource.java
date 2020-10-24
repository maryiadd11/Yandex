package by.tms.yandex.controller;

import by.tms.yandex.entity.Like;
import by.tms.yandex.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/like")
public class LikeResource {

    @Autowired
    private LikeRepository likeRepository;

    @GetMapping (path = "/getAllByPostId")
    public ResponseEntity<Optional<List<Like>>> getAllByPostId(@RequestParam long postId){
        return ResponseEntity.ok(likeRepository.findLikeByPostId(postId));
    }

    @GetMapping (path = "add")
    public ResponseEntity<Like> add(@RequestBody Like like){
        Like newLike = likeRepository.save(like);
        return new ResponseEntity(newLike, HttpStatus.CREATED);
    }

}
