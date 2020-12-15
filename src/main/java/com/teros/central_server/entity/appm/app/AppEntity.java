package com.teros.central_server.entity.appm.app;

import com.teros.central_server.entity.apim.common.CommonDateEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "rep_appm_app")
@Getter
@Setter
@NoArgsConstructor
public class AppEntity extends CommonDateEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appId;

    @Column(name ="app_type_id")
    private Long appTypeId;

    @Column(length = 64)
    private String appName;

    @Column(length = 64)
    private String hostInfo;

    @Column(length = 2048)
    private String description;

    @Builder
    public AppEntity(long appTypeId, String appName, String hostInfo, String description) {
        this.appTypeId = appTypeId;
        this.appName = appName;
        this.hostInfo = hostInfo;
        this.description = description;
    }
    public void update(long appTypeId, String appName, String hostInfo, String description) {
        this.appTypeId = appTypeId;
        this.appName = appName;
        this.hostInfo = hostInfo;
        this.description = description;
    }
}