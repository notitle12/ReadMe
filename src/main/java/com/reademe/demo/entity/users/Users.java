package com.reademe.demo.entity.users;

import com.reademe.demo.dto.requestdto.users.UsersRequestDto;
import com.reademe.demo.entity.post.Post;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String phone;

    @Column
    private String nickname;

    //@OneToMany(mappedBy="users")
    //private List<Post> posts = new ArrayList<>();

    //==생성 메서드==//
    public static Users createUsers(UsersRequestDto dto){
        Users users = new Users();
        users.name= dto.getName();
        users.email = dto.getEmail();
        users.password = dto.getPassword();
        users.phone = dto.getPhone();
        users.nickname = dto.getNickname();
        return users;
    }
}
