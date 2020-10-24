package by.tms.yandex.repository;

import by.tms.yandex.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long> {
    Optional<List<Like>> findLikeByPostId (long postId);
}
