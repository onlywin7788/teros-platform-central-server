package com.teros.central_server.repository.apim.project;

import com.teros.central_server.entity.apiservice.project.APIProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface APIProjectRepository extends JpaRepository<APIProjectEntity, Long> {
}
