package com.reademe.demo.repository.users;

import com.reademe.demo.entity.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
