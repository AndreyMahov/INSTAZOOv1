package com.example.instazoo_v1.repository;

import com.example.instazoo_v1.entity.Comment;
import com.example.instazoo_v1.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {

    List<Comment> findAllByPost (Post post);

    Comment findByIdAndUserId(Long commentId,Long userId);
}
