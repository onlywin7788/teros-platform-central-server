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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appTypeId;

    @Column(name ="app_group_id")
    private Long appGroupId;

    @Column(length = 2048)
    private String typeName;

    @Column(length = 2048)
    private String description;

    @Builder
    public AppTypeEntity(long appGroupId, String typeName, String description) {
        this.appGroupId = appGroupId;
        this.typeName = typeName;
        this.description = description;
    }
}