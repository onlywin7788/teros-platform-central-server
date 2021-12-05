package com.teros.central_server.repository.dataservice.intf;

import com.teros.central_server.entity.dataservice.intf.InterfaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterfaceRepository extends JpaRepository<InterfaceEntity, Long> {
}
