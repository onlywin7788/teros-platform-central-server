package com.teros.central_server.entity.dataservice.project;

import com.teros.central_server.entity.apiservice.common.CommonDateEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "rep_dsm_intf_project")
@Getter
@Setter
@NoArgsConstructor
public class InterfaceProjectEntity extends CommonDateEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long intfProjectId;

    @Column
    private String projectName;

    @Column
    private String description;

    @Builder
    public InterfaceProjectEntity(String projectName, String description) {

        this.projectName = projectName;
        this.description = description;
    }

    public void update(String projectName, String description) {

        this.projectName = projectName;
        this.description = description;
    }
}