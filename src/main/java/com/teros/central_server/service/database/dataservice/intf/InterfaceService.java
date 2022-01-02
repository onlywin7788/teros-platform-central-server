package com.teros.central_server.service.database.dataservice.intf;

import com.teros.central_server.controller.advice.exception.CommonException;
import com.teros.central_server.entity.dataservice.group.ExecutionGroupFlowEntity;
import com.teros.central_server.entity.dataservice.intf.InterfaceEntity;
import com.teros.central_server.model.dataservice.intf.ModelParamInterface;
import com.teros.central_server.model.dataservice.intf.update.ModelParamInterfaceConfig;
import com.teros.central_server.repository.dataservice.group.ExecutionGroupFlowRepository;
import com.teros.central_server.repository.dataservice.intf.InterfaceRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class InterfaceService {

    private final InterfaceRepository interfaceRepository;
    private final ExecutionGroupFlowRepository executionGroupFlowRepository;

    public InterfaceService(InterfaceRepository interfaceRepository, ExecutionGroupFlowRepository executionGroupFlowRepository) {
        this.interfaceRepository = interfaceRepository;
        this.executionGroupFlowRepository = executionGroupFlowRepository;
    }

    public InterfaceEntity select(Long id) {
        return interfaceRepository.findById(id).orElseThrow(() ->
                new CommonException("EX"));
    }

    public List<InterfaceEntity> selectAll() {
        return interfaceRepository.findAll();
    }

    @Transactional
    public InterfaceEntity save(ModelParamInterface model) {
        InterfaceEntity entity = InterfaceEntity.builder()
                .intfName(model.getIntfName())
                .layout(model.getLayout())
                .description(model.getDescription())
                .build();
        Long lastID = interfaceRepository.save(entity).getIntfId();

        /*
        // 미할당 그룹으로 groupflow 테이블에 등록
        Long emptyGroupId = 0L;
        ExecutionGroupFlowEntity groupFlowEntity = ExecutionGroupFlowEntity.builder()
                .execGroupId(emptyGroupId)
                .intfId(lastID)
                .build();

        executionGroupFlowRepository.save(groupFlowEntity).getExecGroupFlowId();
        */

        return select(lastID);
    }

    @Transactional
    public Long update(long id, ModelParamInterface model) {

        InterfaceEntity entity = select(id);
        entity.update(model.getIntfName(), model.getLayout(), model.getDescription());
        return id;
    }

    @Transactional
    public Long updateConfigContents(long id, ModelParamInterfaceConfig model) {

        InterfaceEntity entity = select(id);
        entity.updateConfigContents(model.getConfigContents());
        return id;
    }

    @Transactional
    public boolean delete(long id) {
        InterfaceEntity entity = select(id);
        if (entity == null)
            return false;
        interfaceRepository.delete(entity);
        return true;
    }

    public long getCount() {
        return interfaceRepository.count();
    }
}