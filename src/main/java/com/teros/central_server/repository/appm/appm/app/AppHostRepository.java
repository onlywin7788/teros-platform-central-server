package com.teros.central_server.repository.appm.appm.app;

import com.teros.central_server.entity.apim.api.APIPathEntity;
import com.teros.central_server.entity.appm.app.AppHostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AppHostRepository extends JpaRepository<AppHostEntity, Long> {

    @Query(value = "SELECT * FROM rep_appm_app_host WHERE APP_TYPE_ID=?1", nativeQuery = true)
    List<AppHostEntity> getHostInfoByType(Long apiId);

}