package com.reademe.demo.entity.post;

import com.reademe.demo.entity.book.Book;
import com.reademe.demo.entity.user.User;
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
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Book book;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private int stars;
}
