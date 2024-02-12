package com.reademe.demo.Comment;

import org.hibernate.annotations.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long>{
}
