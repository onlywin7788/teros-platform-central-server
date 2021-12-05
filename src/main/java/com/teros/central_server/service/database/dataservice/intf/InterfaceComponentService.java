package com.teros.central_server.service.database.dataservice.intf;

import com.teros.central_server.controller.advice.exception.CommonException;
import com.teros.central_server.entity.dataservice.intf.InterfaceComponentEntity;
import com.teros.central_server.repository.dataservice.intf.InterfaceComponentRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class InterfaceComponentService {

    private final InterfaceComponentRepository repository;

    public InterfaceComponentService(InterfaceComponentRepository repository) {
        this.repository = repository;
    }

    public InterfaceComponentEntity select(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new CommonException("EX"));
    }

    public InterfaceComponentEntity selectByClassName(String componentName) {
        return repository.findByComponentName(componentName);
    }

    public List<InterfaceComponentEntity> selectAll() {
        return repository.findAll();
    }

    public long getCount() {
        return repository.count();
    }
}