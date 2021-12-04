package com.teros.central_server.repository.dsm.flow;

import com.teros.central_server.entity.dataservice.flow.FlowClassEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlowClassRepository extends JpaRepository<FlowClassEntry, Long> {
    FlowClassEntry findByClassName(String className);
}
