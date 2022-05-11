package com.example.instazoo_v1.repository;

import com.example.instazoo_v1.entity.Post;
import com.example.instazoo_v1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

    List<Post> findAllByUserOrderByCreatedDateDesc(User user);
    List<Post> findAllByOrderByCreatedDateDesc();
    Optional<Post> findPostByIdAndUser(Long PostId, User user);
}
