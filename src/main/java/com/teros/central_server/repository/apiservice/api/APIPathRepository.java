package com.teros.central_server.repository.apiservice.api;

import com.teros.central_server.entity.apiservice.api.APIPathEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface APIPathRepository extends JpaRepository<APIPathEntity, Long> {
    @Query(value = "SELECT * FROM REP_APIM_API_PATH WHERE API_ID=?1", nativeQuery = true)
    List<APIPathEntity> getAPIPathListByApiId(Long apiId);

    @Query(value = "DELETE FROM REP_APIM_API_PATH WHERE API_ID=?1", nativeQuery = true)
    void deleteAPIPathListByApiId(long apiId);
}
