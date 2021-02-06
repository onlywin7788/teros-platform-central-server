package com.teros.central_server.repository.appm.appm.app;

import com.teros.central_server.entity.appm.app.AppHostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppHostRepository extends JpaRepository<AppHostEntity, Long> {
}