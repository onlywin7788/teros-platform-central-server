package com.teros.central_server.repository.dsm.flow;

import com.teros.central_server.entity.dsm.flow.FlowClassEntry;
import com.teros.central_server.entity.dsm.flow.FlowClassPropEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlowClassRepository extends JpaRepository<FlowClassEntry, Long> {
    FlowClassEntry findByClassName(String className);
}
