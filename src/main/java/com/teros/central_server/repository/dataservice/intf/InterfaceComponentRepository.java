package com.teros.central_server.repository.dataservice.intf;

import com.teros.central_server.entity.dataservice.intf.InterfaceComponentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterfaceComponentRepository extends JpaRepository<InterfaceComponentEntity, Long> {
    InterfaceComponentEntity findByComponentName(String componentName);
}
