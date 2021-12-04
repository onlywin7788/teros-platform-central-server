package com.teros.central_server.service.database.dsm.flow;

import com.teros.central_server.controller.advice.exception.CommonException;
import com.teros.central_server.entity.dataservice.flow.FlowEntity;
import com.teros.central_server.entity.dataservice.group.ExecutionGroupFlowEntity;
import com.teros.central_server.model.dsm.flow.ModelParamFlow;
import com.teros.central_server.model.dsm.flow.update.ModelParamFlowConfig;
import com.teros.central_server.repository.dsm.flow.FlowRepository;
import com.teros.central_server.repository.dsm.group.ExecutionGroupFlowRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class FlowService {

    private final FlowRepository flowRepository;
    private final ExecutionGroupFlowRepository executionGroupFlowRepository;

    public FlowService(FlowRepository flowRepository, ExecutionGroupFlowRepository executionGroupFlowRepository) {
        this.flowRepository = flowRepository;
        this.executionGroupFlowRepository = executionGroupFlowRepository;
    }

    public FlowEntity select(Long id) {
        return flowRepository.findById(id).orElseThrow(() ->
                new CommonException("EX"));
    }

    public List<FlowEntity> selectAll() {
        return flowRepository.findAll();
    }

    @Transactional
    public FlowEntity save(ModelParamFlow modelParam) {
        FlowEntity entity = FlowEntity.builder()
                .flowName(modelParam.getFlowName())
                .layout(modelParam.getLayout())
                .description(modelParam.getDescription())
                .build();
        Long lastID = flowRepository.save(entity).getFlowId();

        // 미할당 그룹으로 groupflow 테이블에 등록
        Long emptyGroupId = 0L;
        ExecutionGroupFlowEntity groupFlowEntity = ExecutionGroupFlowEntity.builder()
                .execGroupId(emptyGroupId)
                .flowId(lastID)
                .build();

        executionGroupFlowRepository.save(groupFlowEntity).getExecGroupFlowId();

        return select(lastID);
    }

    @Transactional
    public Long update(long id, ModelParamFlow modelParam) {

        FlowEntity entity = select(id);
        entity.update(modelParam.getFlowName(), modelParam.getLayout(), modelParam.getDescription());
        return id;
    }

    @Transactional
    public Long updateConfigContents(long id, ModelParamFlowConfig modelParam) {

        FlowEntity entity = select(id);
        entity.updateConfigContents(modelParam.getConfigContents());
        return id;
    }

    @Transactional
    public boolean delete(long id) {
        FlowEntity entity = select(id);
        if (entity == null)
            return false;
        flowRepository.delete(entity);
        return true;
    }

    public long getCount() {
        return flowRepository.count();
    }
}