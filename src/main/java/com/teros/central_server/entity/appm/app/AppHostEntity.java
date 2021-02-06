package com.teros.central_server.entity.appm.app;

import com.teros.central_server.entity.apim.common.CommonDateEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "rep_appm_app_host")
@Getter
@Setter
@NoArgsConstructor
public class AppHostEntity extends CommonDateEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hostId;

    @Column
    private String hostName;

    @Column
    private String description;

    @Column
    private String typeCode;

    @Builder
    public AppHostEntity(String hostName, String description, String typeCode) {
        this.hostName = hostName;
        this.description = description;
        this.typeCode = typeCode;
    }

    public void update(String hostName, String description, String typeCode) {
        this.hostName = hostName;
        this.description = description;
        this.typeCode = typeCode;
    }
}