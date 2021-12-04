package com.teros.central_server.entity.dataservice.flow;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "rep_dsm_flow_class")
@Getter
@Setter
@NoArgsConstructor
public class FlowClassEntry implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long classId;

    @Column
    private String className;

    @Builder
    public FlowClassEntry(String className) {
        this.className = className;
    }

    public void update(String className) {
        this.className = className;
    }
}