package com.teros.central_server.repository.apiservice.api;

import com.teros.central_server.entity.apiservice.api.APIEntity;
import com.teros.central_server.entity.apiservice.api.APIPathEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface APIRepository extends JpaRepository<APIEntity, Long> {

    @Query(value = "UPDATE REP_APIM_API SET CONFIG_CONTENTS=?1 WHERE API_ID=?2", nativeQuery = true)
    List<APIPathEntity> updateAPIContensConfigById(String contents, Long apiId);

}
