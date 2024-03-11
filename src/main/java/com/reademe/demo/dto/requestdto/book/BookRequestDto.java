package com.reademe.demo.dto.requestdto.book;

import com.reademe.demo.entity.book.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BookRequestDto {
    private Long id;
    private String title;

    public BookRequestDto(Book book){
        this.id=book.getId();
        this.title=book.getTitle();
    }
}
