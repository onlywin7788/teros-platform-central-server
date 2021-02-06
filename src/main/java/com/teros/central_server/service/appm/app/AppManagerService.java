package com.teros.central_server.service.appm.app;

import com.teros.central_server.controller.advice.exception.CommonException;
import com.teros.central_server.entity.appm.app.AppManagerEntity;
import com.teros.central_server.entity.dsm.flow.FlowClassPropEntry;
import com.teros.central_server.model.appm.app.ModelParamAppManager;
import com.teros.central_server.repository.appm.appm.app.AppManagerRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class AppManagerService {

    private AppManagerRepository appManagerRepository;

    public AppManagerService(AppManagerRepository appManagerRepository) {
        this.appManagerRepository = appManagerRepository;
    }

    public AppManagerEntity select(Long id) {
        return appManagerRepository.findById(id).orElseThrow(() ->
                new CommonException("EX"));
    }

    public List<AppManagerEntity> selectByHostId(Long hostId) {
        return appManagerRepository.findByHostId(hostId);
    }

    public List<AppManagerEntity> selectAll() {
        return appManagerRepository.findAll();
    }

    @Transactional
    public AppManagerEntity save(ModelParamAppManager modelParam) {
        AppManagerEntity entity = AppManagerEntity.builder()
                .managerName(modelParam.getManagerName())
                .host(modelParam.getHost())
                .port(modelParam.getPort())
                .description(modelParam.getDescription())
                .hostId(modelParam.getHostId())
                .build();

        Long lastID = appManagerRepository.save(entity).getManagerId();
        return select(lastID);
    }

    @Transactional
    public Long update(long id, ModelParamAppManager modelParam) {

        AppManagerEntity entity = select(id);
        entity.update(modelParam.getManagerName(), modelParam.getHost(), modelParam.getPort(), modelParam.getDescription(), modelParam.getHostId());
        return id;
    }

    @Transactional
    public boolean delete(long id) {
        AppManagerEntity entity = select(id);
        if (entity == null)
            return false;
        appManagerRepository.delete(entity);
        return true;
    }

    public long getCount() {
        return appManagerRepository.count();
    }
}