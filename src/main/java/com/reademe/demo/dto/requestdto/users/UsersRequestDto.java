package com.reademe.demo.dto.requestdto.users;

import com.reademe.demo.entity.post.Post;
import com.reademe.demo.entity.users.Users;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UsersRequestDto {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String phone;
    private String nickname;
    //private List<Post> posts = new ArrayList<>();

    public UsersRequestDto(Users users) {
        this.id = users.getId();
        this.name = users.getName();
        this.email = users.getEmail();
        this.password = users.getPassword();
        this.phone = users.getPhone();
        this.nickname = users.getNickname();
    }
}
