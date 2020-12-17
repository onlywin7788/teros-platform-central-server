package com.teros.central_server.repository.usm.group;

import com.teros.central_server.entity.usm.group.UserGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserGroupRepository extends JpaRepository<UserGroupEntity, Long> {
}
