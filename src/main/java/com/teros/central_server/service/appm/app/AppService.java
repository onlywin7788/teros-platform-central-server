package com.teros.central_server.service.appm.app;


import com.teros.central_server.controller.advice.exception.CommonException;
import com.teros.central_server.entity.appm.app.AppEntity;
import com.teros.central_server.entity.appm.app.AppGroupEntity;
import com.teros.central_server.entity.appm.app.AppTypeEntity;
import com.teros.central_server.model.appm.app.ModelParamApp;
import com.teros.central_server.repository.appm.appm.app.AppGroupRepository;
import com.teros.central_server.repository.appm.appm.app.AppRepository;
import com.teros.central_server.repository.appm.appm.app.AppTypeRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AppService {

    private final AppGroupRepository appGroupRepository;
    private final AppTypeRepository appTypeRepository;
    private final AppRepository appRepository;

    public AppService(AppGroupRepository appGroupRepository
            ,AppTypeRepository appTypeRepository
            ,AppRepository appRepository) {
        this.appGroupRepository = appGroupRepository;
        this.appTypeRepository = appTypeRepository;
        this.appRepository = appRepository;
    }

    public List<AppGroupEntity> getAppGroupList() {
        return appGroupRepository.findAll();
    }

    public List<AppTypeEntity> getAppTypeList() {
        return appTypeRepository.findAll();
    }

    public List<AppEntity> getAppList() {
        return appRepository.findAll();
    }

    public AppGroupEntity getAppGroup(Long id) {
        return appGroupRepository.findById(id).orElseThrow(() ->
                new CommonException("EX"));
    }

    public AppTypeEntity getAppType(Long id) {
        return appTypeRepository.findById(id).orElseThrow(() ->
                new CommonException("EX"));
    }

    public AppEntity getApp(Long id) {
        return appRepository.findById(id).orElseThrow(() ->
                new CommonException("EX"));
    }

    @Transactional
    public AppEntity saveApp(ModelParamApp modelParamApp) {
        AppEntity app = AppEntity.builder()
                .appTypeId(modelParamApp.getAppTypeId())
                .appName(modelParamApp.getAppName())
                .hostInfo(modelParamApp.getHostInfo())
                .description(modelParamApp.getDescription())
                .build();

        Long lastID = appRepository.save(app).getAppId();
        return getApp(lastID);
    }

    @Transactional
    public Long updateApp(long appId, ModelParamApp modelParamApp) {

        AppEntity app = getApp(appId);
        app.update(modelParamApp.getAppTypeId(), modelParamApp.getAppName()
                , modelParamApp.getHostInfo(), modelParamApp.getDescription());
        return appId;
    }

    @Transactional
    public boolean deleteApp(long appId) {
        AppEntity app = getApp(appId);
        if (app == null)
            return false;
        appRepository.delete(app);
        return true;
    }
}