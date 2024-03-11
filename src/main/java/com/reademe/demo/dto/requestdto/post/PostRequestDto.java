package com.reademe.demo.dto.requestdto.post;

import com.reademe.demo.entity.post.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PostRequestDto {
    private Long id;
    //게시글 작성 시 요청 보내는 dto
    private Long users_id;
    private Long book_id;
    private String title;
    private String content;
    private int stars;

    public PostRequestDto(Post post) {
        this.users_id = post.getUsers().getId();
        this.book_id = post.getBook().getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.stars = post.getStars();
    }
}
