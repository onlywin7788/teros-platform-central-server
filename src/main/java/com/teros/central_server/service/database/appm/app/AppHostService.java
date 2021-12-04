package com.teros.central_server.service.database.appm.app;

import com.teros.central_server.controller.advice.exception.CommonException;
import com.teros.central_server.entity.appm.app.AppHostEntity;
import com.teros.central_server.model.appm.app.ModelParamAppHost;
import com.teros.central_server.repository.appm.appm.app.AppHostRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class AppHostService {

    private AppHostRepository appHostRepository;


    public AppHostService(AppHostRepository appTypeRepository) {
        this.appHostRepository = appTypeRepository;
    }
    public List<AppHostEntity> getAppHostByTypeId(Long id) {
        return appHostRepository.getHostInfoByType(id);
    }

    public AppHostEntity select(Long id) {
        return appHostRepository.findById(id).orElseThrow(() ->
                new CommonException("EX"));
    }

    public List<AppHostEntity> selectAll() {
        return appHostRepository.findAll();
    }

    @Transactional
    public AppHostEntity save(ModelParamAppHost modelParam) {
        AppHostEntity entity = AppHostEntity.builder()
                .hostName(modelParam.getHostName())
                .description(modelParam.getDescription())
                .appTypeId(modelParam.getAppTypeId())
                .build();

        Long lastID = appHostRepository.save(entity).getHostId();
        return select(lastID);
    }

    @Transactional
    public Long update(long id, ModelParamAppHost modelParam) {

        AppHostEntity entity = select(id);
        entity.update(modelParam.getHostName(), modelParam.getDescription(), modelParam.getAppTypeId());
        return id;
    }

    @Transactional
    public boolean delete(long id) {
        AppHostEntity entity = select(id);
        if (entity == null)
            return false;
        appHostRepository.delete(entity);
        return true;
    }

    public long getCount() {
        return appHostRepository.count();
    }
}