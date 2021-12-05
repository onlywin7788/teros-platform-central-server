package com.teros.central_server.service.database.dataservice.intf;

import com.teros.central_server.controller.advice.exception.CommonException;
import com.teros.central_server.entity.dataservice.intf.InterfaceComponentPropEntity;
import com.teros.central_server.repository.dataservice.intf.InterfaceComponentPropRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterfaceComponentPropService {

    private final InterfaceComponentPropRepository repository;

    public InterfaceComponentPropService(InterfaceComponentPropRepository repository) {
        this.repository = repository;
    }

    public InterfaceComponentPropEntity select(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new CommonException("EX"));
    }

    public List<InterfaceComponentPropEntity> selectBycomponentId(Long componentId) {
        return repository.findByComponentId(componentId);
    }

    public List<InterfaceComponentPropEntity> selectAll() {
        return repository.findAll();
    }

    public long getCount() {
        return repository.count();
    }
}