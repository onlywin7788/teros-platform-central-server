package com.teros.central_server.repository.apiservice.api;

import com.teros.central_server.entity.apiservice.api.APIEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface APIRepository extends JpaRepository<APIEntity, Long> {
}