package com.teros.central_server.entity.dataservice.group;

import com.teros.central_server.entity.apiservice.common.CommonDateEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "rep_dsm_exec_group_flow")
@Getter
@Setter
@NoArgsConstructor
public class ExecutionGroupFlowEntity extends CommonDateEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long execGroupFlowId;

    @Column
    private Long execGroupId;

    @Column
    private Long flowId;

    @Builder
    public ExecutionGroupFlowEntity(Long execGroupId, Long flowId) {
        this.execGroupId = execGroupId;
        this.flowId = flowId;
    }

    public void update(Long execGroupId, Long flowId) {
        this.execGroupId = execGroupId;
        this.flowId = flowId;
    }
}