package com.teros.central_server.entity.appm.app;

import com.teros.central_server.entity.apim.common.CommonDateEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "rep_appm_app_manager")
@Getter
@Setter
@NoArgsConstructor
public class AppManagerEntity extends CommonDateEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long managerId;

    @Column
    private String managerName;

    @Column
    private String host;

    @Column
    private Long port;

    @Column
    private String description;

    @Column
    private Long hostId;

    @Builder
    public AppManagerEntity(String managerName, String host, Long port, String description, Long hostId) {
        this.managerName = managerName;
        this.host = host;
        this.port = port;
        this.description = description;
        this.hostId = hostId;
    }

    public void update(String managerName, String host, Long port, String description, Long hostId) {
        this.managerName = managerName;
        this.host = host;
        this.port = port;
        this.description = description;
        this.hostId = hostId;
    }
}