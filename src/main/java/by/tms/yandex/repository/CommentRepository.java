package by.tms.yandex.repository;

import by.tms.yandex.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Optional<List<Comment>> findCommentByPostId (long postId);
}
