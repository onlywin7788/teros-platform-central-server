package com.teros.central_server.service.database.dsm.flow;

import com.teros.central_server.controller.advice.exception.CommonException;
import com.teros.central_server.entity.dataservice.flow.FlowClassEntry;
import com.teros.central_server.repository.dsm.flow.FlowClassRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FlowClassService {

    private final FlowClassRepository flowClassRepository;

    public FlowClassService(FlowClassRepository flowClassRepository) {
        this.flowClassRepository = flowClassRepository;
    }

    public FlowClassEntry select(Long id) {
        return flowClassRepository.findById(id).orElseThrow(() ->
                new CommonException("EX"));
    }

    public FlowClassEntry selectByClassName(String className) {
        return flowClassRepository.findByClassName(className);
    }

    public List<FlowClassEntry> selectAll() {
        return flowClassRepository.findAll();
    }

    public long getCount() {
        return flowClassRepository.count();
    }
}