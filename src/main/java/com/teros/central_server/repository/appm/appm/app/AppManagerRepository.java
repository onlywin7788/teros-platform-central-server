package com.teros.central_server.repository.appm.appm.app;

import com.teros.central_server.entity.appm.app.AppManagerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppManagerRepository extends JpaRepository<AppManagerEntity, Long> {
    List<AppManagerEntity> findByHostId(Long hostId);
}