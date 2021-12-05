package com.teros.central_server.repository.dataservice.project;

import com.teros.central_server.entity.apiservice.project.APIProjectEntity;
import com.teros.central_server.entity.dataservice.project.InterfaceProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterfaceProjectRepository extends JpaRepository<InterfaceProjectEntity, Long> {
}
