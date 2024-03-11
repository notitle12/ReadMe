package com.reademe.demo.controller.book;

import com.reademe.demo.dto.requestdto.book.BookRequestDto;
import com.reademe.demo.dto.responsedto.book.BookResponseDto;
import com.reademe.demo.repository.book.BookRepository;
import com.reademe.demo.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookApiController {
    @Autowired
    BookService bookService;

    //책 등록
    @PostMapping("/books")
    public ResponseEntity<BookResponseDto> create(@RequestBody BookRequestDto dto){
        BookResponseDto createdDto = bookService.create(dto);
        return ResponseEntity.status(HttpStatus.OK).body(createdDto);
    }
}
