package com.reademe.demo.service.users;

import com.reademe.demo.dto.requestdto.users.UsersRequestDto;
import com.reademe.demo.dto.responsedto.users.UsersResponseDto;
import com.reademe.demo.entity.users.Users;
import com.reademe.demo.repository.users.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    @Autowired
    UsersRepository usersRepository;

    public UsersResponseDto create(UsersRequestDto dto) {
        Users users = Users.createUsers(dto);
        Users created = usersRepository.save(users);
        return new UsersResponseDto(created);
    }
}
