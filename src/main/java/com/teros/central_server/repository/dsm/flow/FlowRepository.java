package com.teros.central_server.repository.dsm.flow;


import com.teros.central_server.entity.dataservice.flow.FlowEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlowRepository extends JpaRepository<FlowEntity, Long> {
}
