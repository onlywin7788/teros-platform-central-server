package com.teros.central_server.service.database.dataservice.project;

import com.teros.central_server.controller.advice.exception.CommonException;
import com.teros.central_server.entity.dataservice.project.InterfaceProjectEntity;
import com.teros.central_server.model.dataservice.project.ModelParamInterfaceProject;
import com.teros.central_server.repository.dataservice.project.InterfaceProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class InterfaceProjectService {

    @Autowired
    private InterfaceProjectRepository repository;

    public InterfaceProjectEntity getOneRow(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new CommonException("EX"));
    }

    public List<InterfaceProjectEntity> getList() {
        return repository.findAll();
    }

    @Transactional
    public InterfaceProjectEntity save(ModelParamInterfaceProject model) {
        InterfaceProjectEntity entity = InterfaceProjectEntity.builder()
                .projectName(model.getProjectName())
                .description(model.getDescription())
                .build();

        Long lastID = repository.save(entity).getIntfProjectId();
        return getOneRow(lastID);
    }

    @Transactional
    public Long updateAPIProject(long id, ModelParamInterfaceProject model) {

        InterfaceProjectEntity entity = getOneRow(id);
        entity.update(model.getProjectName(), model.getDescription());
        return id;
    }

    @Transactional
    public boolean deleteAPIProject(long id) {
        InterfaceProjectEntity entity = getOneRow(id);
        if (entity == null)
            return false;
        repository.delete(entity);
        return true;
    }

    public long getCount() {
        return repository.count();
    }
}