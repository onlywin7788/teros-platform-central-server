package com.teros.central_server.repository.dsm.flow;

import com.teros.central_server.entity.dataservice.flow.FlowClassPropEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlowClassPropRepository extends JpaRepository<FlowClassPropEntry, Long> {

    List<FlowClassPropEntry> findByClassId(Long classId);

}
