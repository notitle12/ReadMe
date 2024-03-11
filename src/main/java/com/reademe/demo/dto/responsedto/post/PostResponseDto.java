package com.reademe.demo.dto.responsedto.post;

import com.reademe.demo.entity.post.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PostResponseDto {
    private Long id;
    private Long users_id;
    private Long book_id;
    private String title;
    private String content;
    private int stars;
    private LocalDateTime createdAt; //util로 빼는법?
    private LocalDateTime modifiedAt;

    public PostResponseDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.stars = post.getStars();
        this.users_id = post.getUsers().getId();
        this.book_id = post.getBook().getId();
        this.createdAt = post.getCreatedAt();
        this.modifiedAt = post.getModifiedAt();
    }
}
