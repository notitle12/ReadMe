package com.reademe.demo.service.book;

import com.reademe.demo.dto.requestdto.book.BookRequestDto;
import com.reademe.demo.dto.responsedto.book.BookResponseDto;
import com.reademe.demo.entity.book.Book;
import com.reademe.demo.repository.book.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public BookResponseDto create(BookRequestDto dto) {
        Book book = bookRepository.save(new Book(dto.getId(), dto.getTitle()));
        return new BookResponseDto(book);
    }
}
