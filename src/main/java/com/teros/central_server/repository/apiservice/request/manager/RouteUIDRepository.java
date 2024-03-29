package com.teros.central_server.repository.apiservice.request.manager;

import com.teros.central_server.entity.apiservice.request.manager.RouteUIDEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RouteUIDRepository extends JpaRepository<RouteUIDEntity, Long> {

    @Query(value =
            "SELECT CONCAT('API_ROUTE', '-', COUNT(*), '-', SUM(DATE_FORMAT(API_PATH.MODIFY_DTIME, '%Y%m%d%H%i%s'))) AS ROUTE_UID\n" +
                    "FROM REP_APIM_API_PATH API_PATH"
            ,nativeQuery = true)
    RouteUIDEntity getRouteUIDEntity();
}
