package com.reademe.demo.dto.responsedto.book;

import com.reademe.demo.entity.book.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BookResponseDto {
    private Long id;
    private String title;

    public BookResponseDto(Book book){
        this.id=book.getId();
        this.title=book.getTitle();
    }
}
