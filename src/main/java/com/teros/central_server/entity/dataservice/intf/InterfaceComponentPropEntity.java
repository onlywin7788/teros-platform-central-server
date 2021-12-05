package com.teros.central_server.entity.dataservice.intf;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "rep_dsm_intf_component_prop")
@Getter
@Setter
@NoArgsConstructor
public class InterfaceComponentPropEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long propId;

    @Column
    private String propName;

    @Column
    private String displayName;

    @Column
    private String description;

    @Column
    private Long componentId;

    @Builder
    public InterfaceComponentPropEntity(String propName, String displayName, String description, Long componentId) {
        this.propName = propName;
        this.displayName = displayName;
        this.description = description;
        this.componentId = componentId;
    }

    public void update(String propName, String displayName, String description, Long componentId) {
        this.propName = propName;
        this.displayName = displayName;
        this.description = description;
        this.componentId = componentId;
    }
}