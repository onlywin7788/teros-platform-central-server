package com.teros.central_server.repository.dsm.group;

import com.teros.central_server.entity.dsm.group.ExecutionGroupFlowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ExecutionGroupFlowRepository extends JpaRepository<ExecutionGroupFlowEntity, Long> {
    ExecutionGroupFlowEntity findByFlowId(Long flowId);
}
