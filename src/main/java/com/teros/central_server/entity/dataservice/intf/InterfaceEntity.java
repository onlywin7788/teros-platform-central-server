package com.teros.central_server.entity.dataservice.intf;

import com.teros.central_server.entity.apiservice.common.CommonDateEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "rp_ds_interface")
@Getter
@Setter
@NoArgsConstructor
public class InterfaceEntity extends CommonDateEntity implements Serializable {

    @Id
    @Column(name ="inteface_uid")
    private String routeId;

    @Column(name ="interface_name")
    private String method;

    
}
