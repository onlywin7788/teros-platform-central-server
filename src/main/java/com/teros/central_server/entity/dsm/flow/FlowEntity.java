package com.teros.central_server.entity.dsm.flow;

import com.teros.central_server.entity.apim.common.CommonDateEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "rep_dsm_flow")
@Getter
@Setter
@NoArgsConstructor
public class FlowEntity extends CommonDateEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flowId;

    @Column(length = 64)
    private String flowName;

    @Column(length = 1048576)
    private String layout;

    @Column(length = 1048576)
    private String description;

    @Builder
    public FlowEntity(String flowName, String layout, String description) {
        this.flowName = flowName;
        this.layout = layout;
        this.description = description;
    }

    public void update(String flowName, String layout, String description) {
        this.flowName = flowName;
        this.layout = layout;
        this.description = description;
    }
}