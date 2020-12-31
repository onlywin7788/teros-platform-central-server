package com.teros.central_server.entity.dsm.group;

import com.teros.central_server.entity.apim.common.CommonDateEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "rep_dsm_exec_group")
@Getter
@Setter
@NoArgsConstructor
public class ExecutionGroupEntity extends CommonDateEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long execGroupId;

    @Column(length = 64)
    private String execGroupName;

    @Column(length = 1048576)
    private String description;

    @Builder
    public ExecutionGroupEntity(String execGroupName, String description) {
        this.execGroupName = execGroupName;
        this.description = description;
    }

    public void update(String execGroupName, String description) {
        this.execGroupName = execGroupName;
        this.description = description;
    }
}