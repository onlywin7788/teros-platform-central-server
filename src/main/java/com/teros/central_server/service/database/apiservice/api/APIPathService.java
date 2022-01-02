package com.teros.central_server.service.database.apiservice.api;

import com.teros.central_server.controller.advice.exception.CommonException;
import com.teros.central_server.entity.apiservice.api.APIEntity;
import com.teros.central_server.entity.apiservice.api.APIPathEntity;
import com.teros.central_server.model.apiservice.api.ModelParamAPIPath;
import com.teros.central_server.repository.apiservice.api.APIPathRepository;
import com.teros.central_server.service.database.apiservice.api.config.APIConfigRouteMaker;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class APIPathService {

    private final APIService apiService;
    private final APIPathRepository apiPathRepository;

    public APIPathService(APIService apiService, APIPathRepository apiPathRepository) {
        this.apiService = apiService;
        this.apiPathRepository = apiPathRepository;
    }

    public APIPathEntity getAPIPath(Long id) {
        return apiPathRepository.findById(id).orElseThrow(() ->
                new CommonException("EX"));
    }

    public List<APIPathEntity> getAPIPathByApiId(Long id) {
        return apiPathRepository.getAPIPathListByApiId(id);
    }

    public List<APIPathEntity> getAPIPathList() {
        return apiPathRepository.findAll();
    }

    public void updateConfigContens(ModelParamAPIPath modelParamAPIPath)
    {
        // update api config contents
        APIEntity apiEntity = apiService.getAPI(modelParamAPIPath.getApiId());
        APIConfigRouteMaker apiConfigRouteMaker = new APIConfigRouteMaker();

        String result = apiConfigRouteMaker.createRouteList(apiEntity.getApiName(), apiEntity.getVersion(),
                modelParamAPIPath.getSourceUri(), modelParamAPIPath.getTargetUri(), "GET", apiEntity.getTargetUrl());

        apiService.updateAPIConfigContents(result, modelParamAPIPath.getApiId());
    }

    @Transactional
    public Long saveAPIPath(ModelParamAPIPath modelParamAPIPath) {
        APIPathEntity apiPath = APIPathEntity.builder()
                .apiId(modelParamAPIPath.getApiId())
                .apiMethodId(modelParamAPIPath.getApiMethodId())
                .sourceUri(modelParamAPIPath.getSourceUri())
                .targetUri(modelParamAPIPath.getTargetUri())
                .description(modelParamAPIPath.getDescription())
                .build();

        updateConfigContens(modelParamAPIPath);

        return apiPathRepository.save(apiPath).getApiPathId();
    }

    @Transactional
    public Long updateAPIPath(long id, ModelParamAPIPath modelParamAPIPath) {

        APIPathEntity apiPath = getAPIPath(id);
        apiPath.update(modelParamAPIPath.getApiId(), modelParamAPIPath.getApiMethodId()
                , modelParamAPIPath.getSourceUri(), modelParamAPIPath.getTargetUri()
                , modelParamAPIPath.getDescription());

        updateConfigContens(modelParamAPIPath);

        return id;
    }

    @Transactional
    public boolean deleteAPIPath(long id) {
        APIPathEntity apiPath = getAPIPath(id);
        if (apiPath == null)
            return false;
        apiPathRepository.delete(apiPath);
        return true;
    }

    @Transactional
    public boolean deleteAPIPathListByApiId(long id) {
        apiPathRepository.deleteAPIPathListByApiId(id);
        return true;
    }
}