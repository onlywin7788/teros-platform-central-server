package com.teros.central_server.service.database.apiservice.api;

import com.teros.central_server.controller.advice.exception.CommonException;
import com.teros.central_server.entity.apiservice.api.APIEntity;
import com.teros.central_server.model.apiservice.api.ModelParamAPI;
import com.teros.central_server.repository.apiservice.api.APIRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class APIService {

    private final APIRepository apiRepository;

    public APIService(APIRepository apiRepository) {
        this.apiRepository = apiRepository;
    }

    public APIEntity getAPI(Long apiId) {
        return apiRepository.findById(apiId).orElseThrow(() ->
                new CommonException("EX"));
    }

    public List<APIEntity> getAPIList() {
        return apiRepository.findAll();
    }

    public void updateAPIConfigContents(String contents, Long id)
    {
        this.apiRepository.updateAPIContensConfigById(contents, id);
    }

    @Transactional
    public APIEntity saveAPI(ModelParamAPI modelParamAPI) {
        APIEntity api = APIEntity.builder()
                .apiName(modelParamAPI.getApiName())
                .version(modelParamAPI.getVersion())
                .targetUrl(modelParamAPI.getTargetUrl())
                .configContents("")
                .description(modelParamAPI.getDescription())
                .build();

        Long lastID = apiRepository.save(api).getApiId();
        return getAPI(lastID);
    }

    @Transactional
    public Long updateAPI(long apiId, ModelParamAPI modelParamAPI) {

        APIEntity api = getAPI(apiId);
        api.update(modelParamAPI.getApiName(), modelParamAPI.getVersion(), modelParamAPI.getTargetUrl()
                ,"", modelParamAPI.getDescription());
        return apiId;
    }

    @Transactional
    public boolean deleteAPI(long apiId) {
        APIEntity api = getAPI(apiId);
        if (api == null)
            return false;
        apiRepository.delete(api);
        return true;
    }

    public long getCount() {
        return apiRepository.count();
    }
}