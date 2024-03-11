package com.reademe.demo.entity.post;

import com.reademe.demo.entity.book.Book;
import com.reademe.demo.entity.users.Users;
import com.reademe.demo.entity.util.BaseEntity;
import jakarta.persistence.*;
import lombok.*;



@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Post extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Users users;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Book book;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private int stars;

    //==연관관계 메서드=//
    private void setUsers(Users users){
        this.users = users;
        //users.getPosts().add(this);
    }
    //==생성 메서드==//
    //복잡한 생성은 별도의 생성 메서드가 있으면 좋다.
    public static Post createPost(Users users, Book book, String title, String content, int stars){
        Post post = new Post();
        post.setUsers(users);
        post.book = book;
        post.title=title;
        post.content=content;
        post.stars=stars;
        return post;
    }
    //==게시글 수정==//
    public void patch(Post post) {
        this.setUsers(post.getUsers());
        this.book = post.getBook();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.stars = post.getStars();
    }
}
