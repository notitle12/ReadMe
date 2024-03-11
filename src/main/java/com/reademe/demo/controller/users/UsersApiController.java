package com.reademe.demo.controller.users;

import com.reademe.demo.dto.requestdto.users.UsersRequestDto;
import com.reademe.demo.dto.responsedto.users.UsersResponseDto;
import com.reademe.demo.service.users.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersApiController {
    @Autowired
    UsersService usersService;

    //users 생성
    @PostMapping("/users")
    public ResponseEntity<UsersResponseDto> create(@RequestBody UsersRequestDto dto){
        UsersResponseDto createdDto = usersService.create(dto);
        return ResponseEntity.status(HttpStatus.OK).body(createdDto);
    }
}
