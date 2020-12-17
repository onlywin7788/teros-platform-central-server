package com.teros.central_server.repository.usm.user;

import com.teros.central_server.entity.usm.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
