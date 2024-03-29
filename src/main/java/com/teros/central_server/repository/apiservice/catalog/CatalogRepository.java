package com.teros.central_server.repository.apiservice.catalog;

import com.teros.central_server.entity.apiservice.catalog.CatalogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogRepository extends JpaRepository<CatalogEntity, Long> {
}
