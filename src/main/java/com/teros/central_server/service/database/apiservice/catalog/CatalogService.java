package com.teros.central_server.service.database.apiservice.catalog;

import com.teros.central_server.controller.advice.exception.CommonException;
import com.teros.central_server.entity.apiservice.catalog.CatalogEntity;
import com.teros.central_server.model.apiservice.catalog.ModelParamCatalog;
import com.teros.central_server.repository.apiservice.catalog.CatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class CatalogService {

    @Autowired
    private CatalogRepository catalogRepository;

    public CatalogEntity getCatalog(Long id) {
        return catalogRepository.findById(id).orElseThrow(() ->
                new CommonException("EX"));
    }

    public List<CatalogEntity> getCatalogList()
    {
        return catalogRepository.findAll();
    }

    @Transactional
    public Long saveCatalog(ModelParamCatalog modelParamCatalog) {
        CatalogEntity catalog = CatalogEntity.builder()
                .catalogName(modelParamCatalog.getCatalogName())
                .description(modelParamCatalog.getDescription())
                .build();

        return catalogRepository.save(catalog).getCatalogId();
    }

    @Transactional
    public Long updateCatalog(long id, ModelParamCatalog modelParamCatalog) {

        CatalogEntity catalog = getCatalog(id);
        catalog.update(modelParamCatalog.getCatalogName(), modelParamCatalog.getDescription());
        return id;
    }

    @Transactional
    public boolean deleteCatalog(long id) {
        CatalogEntity catalog = getCatalog(id);
        if(catalog == null)
            return false;
        catalogRepository.delete(catalog);
        return true;
    }
}