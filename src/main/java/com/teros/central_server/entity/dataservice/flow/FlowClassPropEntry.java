package com.teros.central_server.entity.dataservice.flow;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "rep_dsm_flow_class_prop")
@Getter
@Setter
@NoArgsConstructor
public class FlowClassPropEntry implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long classPropId;

    @Column
    private String propName;

    @Column
    private String displayName;

    @Column
    private String description;

    @Column
    private Long classId;

    @Builder
    public FlowClassPropEntry(String propName, String displayName, String description) {
        this.propName = propName;
        this.displayName = displayName;
        this.description = description;
    }

    public void update(String propName, String displayName, String description) {
        this.propName = propName;
        this.displayName = displayName;
        this.description = description;
    }
}