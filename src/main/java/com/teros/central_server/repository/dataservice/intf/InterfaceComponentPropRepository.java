package com.teros.central_server.repository.dataservice.intf;

import com.teros.central_server.entity.dataservice.intf.InterfaceComponentPropEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InterfaceComponentPropRepository extends JpaRepository<InterfaceComponentPropEntity, Long> {

    List<InterfaceComponentPropEntity> findByComponentId(Long componentId);

}
