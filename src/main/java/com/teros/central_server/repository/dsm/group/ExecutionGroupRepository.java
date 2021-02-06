package com.teros.central_server.repository.dsm.group;

import com.teros.central_server.entity.dsm.flow.FlowClassEntry;
import com.teros.central_server.entity.dsm.group.ExecutionGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ExecutionGroupRepository extends JpaRepository<ExecutionGroupEntity, Long> {
    @Query(value
            = " SELECT GRP.*"
            + " FROM rep_dsm_exec_group AS GRP, rep_dsm_exec_group_flow AS GRP_FLOW"
            + " WHERE GRP.EXEC_GROUP_ID=GRP_FLOW.EXEC_GROUP_ID"
            + " AND GRP_FLOW.FLOW_ID=?1"
            , nativeQuery = true)
    ExecutionGroupEntity findGroupByGroupFlowId(long flowId);
}
