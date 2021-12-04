package com.teros.central_server.entity.apiservice.project;

import com.teros.central_server.entity.apiservice.common.CommonDateEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "rep_apim_api_project")
@Getter
@Setter
@NoArgsConstructor
public class APIProjectEntity extends CommonDateEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long apiProjectId;

    @Column
    private String projectName;

    @Column
    private String description;

    @Builder
    public APIProjectEntity(String projectName, String description) {

        this.projectName = projectName;
        this.description = description;
    }

    public void update(String projectName, String description) {

        this.projectName = projectName;
        this.description = description;
    }

}