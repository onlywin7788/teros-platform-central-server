package com.teros.central_server.repository.dsm.group;

import com.teros.central_server.entity.dataservice.group.ExecutionGroupFlowEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExecutionGroupFlowRepository extends JpaRepository<ExecutionGroupFlowEntity, Long> {
    ExecutionGroupFlowEntity findByFlowId(Long flowId);
}
