package com.reademe.demo.controller.post;

import com.reademe.demo.dto.requestdto.post.PostRequestDto;
import com.reademe.demo.dto.responsedto.post.PostResponseDto;
import com.reademe.demo.entity.post.Post;
import com.reademe.demo.service.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.DeleteExchange;

import java.util.List;

@RestController
public class PostApiController {
    @Autowired PostService postService;

    //post 생성
    @PostMapping("/posts")
    public ResponseEntity<PostResponseDto> create(@RequestBody PostRequestDto dto){
        PostResponseDto createdDto = postService.create(dto);
        return ResponseEntity.status(HttpStatus.OK).body(createdDto);
    }

    //post 전체 조회
    @GetMapping("/posts")
    public ResponseEntity<List<PostResponseDto>> findAll(){
        List<PostResponseDto> dtos = postService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }
    //post 하나 조회
    @GetMapping("/posts/{id}")
    public ResponseEntity<PostResponseDto> findOne(@PathVariable("id") Long id){
        PostResponseDto dto = postService.findOne(id);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    //post 수정
    @PatchMapping("posts/{id}")
    public ResponseEntity<PostResponseDto> update(@PathVariable("id") Long id, @RequestBody PostRequestDto dto){
        PostResponseDto updatedDto = postService.update(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(updatedDto);
    }
    //post 삭제
    @DeleteMapping("posts/{id}")
    public ResponseEntity<PostResponseDto> delete(@PathVariable("id") Long id){
        PostResponseDto dto = postService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

}
