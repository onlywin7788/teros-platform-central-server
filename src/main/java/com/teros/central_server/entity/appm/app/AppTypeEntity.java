package com.teros.central_server.entity.appm.app;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "rep_appm_app_type")
@Getter
@Setter
@NoArgsConstructor
public class AppTypeEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String typeCode;

    @Column
    private String description;


    @Builder
    public AppTypeEntity(String typeName, String description, Long groupId) {
        this.description = description;
    }

    public void update(String typeName, String description, Long groupId) {
        this.description = description;
    }
}