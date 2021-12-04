package com.teros.central_server.service.database.dsm.flow;

import com.teros.central_server.controller.advice.exception.CommonException;
import com.teros.central_server.entity.dataservice.flow.FlowClassPropEntry;
import com.teros.central_server.repository.dsm.flow.FlowClassPropRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlowClassPropService {

    private final FlowClassPropRepository flowClassPropRepository;

    public FlowClassPropService(FlowClassPropRepository flowClassPropRepository) {
        this.flowClassPropRepository = flowClassPropRepository;
    }

    public FlowClassPropEntry select(Long id) {
        return flowClassPropRepository.findById(id).orElseThrow(() ->
                new CommonException("EX"));
    }

    public List<FlowClassPropEntry> selectByClassId(Long classId) {
        return flowClassPropRepository.findByClassId(classId);
    }

    public List<FlowClassPropEntry> selectAll() {
        return flowClassPropRepository.findAll();
    }

    public long getCount() {
        return flowClassPropRepository.count();
    }
}