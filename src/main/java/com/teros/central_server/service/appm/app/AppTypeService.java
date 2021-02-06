package com.teros.central_server.service.appm.app;

import com.teros.central_server.controller.advice.exception.CommonException;
import com.teros.central_server.entity.appm.app.AppTypeEntity;
import com.teros.central_server.model.appm.app.ModelParamAppType;
import com.teros.central_server.repository.appm.appm.app.AppTypeRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class AppTypeService {

    private AppTypeRepository appTypeRepository;

    public AppTypeService(AppTypeRepository appTypeRepository) {
        this.appTypeRepository = appTypeRepository;
    }

    public List<AppTypeEntity> selectAll() {
        return appTypeRepository.findAll();
    }
}