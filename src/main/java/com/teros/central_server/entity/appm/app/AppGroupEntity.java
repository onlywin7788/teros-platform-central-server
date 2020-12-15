package com.teros.central_server.entity.appm.app;

import com.teros.central_server.entity.apim.common.CommonDateEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "rep_appm_app_group")
@Getter
@Setter
@NoArgsConstructor
public class AppGroupEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appGroupId;

    @Column(length = 2048)
    private String groupName;

    @Column(length = 2048)
    private String description;

    @Builder
    public AppGroupEntity(String groupName, String description) {
        this.groupName = groupName;
        this.description = description;
    }

}