package com.teros.central_server.entity.dataservice.intf;

import com.teros.central_server.entity.apiservice.common.CommonDateEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "rep_dsm_intf")
@Getter
@Setter
@NoArgsConstructor
public class InterfaceEntity extends CommonDateEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long intfId;

    @Column(length = 64)
    private String intfName;

    @Column(length = 1048576)
    private String layout;

    @Column(length = 1048576)
    private String configContents;

    @Column(length = 1048576)
    private String description;

    @Builder
    public InterfaceEntity(String intfName, String layout, String description) {
        this.intfName = intfName;
        this.layout = layout;
        this.description = description;
    }

    public void update(String intfName, String layout, String description) {
        this.intfName = intfName;
        this.layout = layout;
        this.description = description;
    }

    public void updateConfigContents(String configContents) {
        this.configContents = configContents;
    }
}
