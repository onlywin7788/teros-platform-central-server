package com.teros.central_server.service.database.apiservice.project;

import com.teros.central_server.controller.advice.exception.CommonException;
import com.teros.central_server.entity.apiservice.project.APIProjectEntity;
import com.teros.central_server.model.apim.project.ModelParamAPIProject;
import com.teros.central_server.repository.apim.project.APIProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class APIProjectService {

    @Autowired
    private APIProjectRepository apiProjectRepository;

    public APIProjectEntity getAPIProject(Long apiProjectId) {
        return apiProjectRepository.findById(apiProjectId).orElseThrow(() ->
                new CommonException("EX"));
    }

    public List<APIProjectEntity> getAPIProjectList() {
        return apiProjectRepository.findAll();
    }

    @Transactional
    public APIProjectEntity saveAPIProject(ModelParamAPIProject model) {
        APIProjectEntity entity = APIProjectEntity.builder()
                .projectName(model.getProjectName())
                .description(model.getDescription())
                .build();

        Long lastID = apiProjectRepository.save(entity).getApiProjectId();
        return getAPIProject(lastID);
    }

    @Transactional
    public Long updateAPIProject(long id, ModelParamAPIProject model) {

        APIProjectEntity entity = getAPIProject(id);
        entity.update(model.getProjectName(), model.getDescription());
        return id;
    }

    @Transactional
    public boolean deleteAPIProject(long id) {
        APIProjectEntity entity = getAPIProject(id);
        if (entity == null)
            return false;
        apiProjectRepository.delete(entity);
        return true;
    }

    public long getCount() {
        return apiProjectRepository.count();
    }
}