package com.teros.central_server.entity.dataservice.intf;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "rep_dsm_intf_component")
@Getter
@Setter
@NoArgsConstructor
public class InterfaceComponentEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long componentId;

    @Column
    private String componentName;

    @Column
    private String componentLoad;


    @Builder
    public InterfaceComponentEntity(String componentName, String componentLoad)
    {
        this.componentName = componentName;
        this.componentLoad = componentLoad;
    }

    public void update(String componentName, String componentLoad)
    {
        this.componentName = componentName;
        this.componentLoad = componentLoad;
    }
}