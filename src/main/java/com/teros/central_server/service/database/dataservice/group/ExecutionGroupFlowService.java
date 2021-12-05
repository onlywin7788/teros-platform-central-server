package com.teros.central_server.service.database.dataservice.group;

import com.teros.central_server.controller.advice.exception.CommonException;
import com.teros.central_server.entity.dataservice.group.ExecutionGroupFlowEntity;
import com.teros.central_server.model.dataservice.group.ModelParamExecutionGroupFlow;
import com.teros.central_server.repository.dataservice.group.ExecutionGroupFlowRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class ExecutionGroupFlowService {

    private final ExecutionGroupFlowRepository executionGroupFlowRepository;

    public ExecutionGroupFlowService(ExecutionGroupFlowRepository executionGroupFlowRepository) {
        this.executionGroupFlowRepository = executionGroupFlowRepository;
    }

    public ExecutionGroupFlowEntity select(Long id) {
        return executionGroupFlowRepository.findById(id).orElseThrow(() ->
                new CommonException("EX"));
    }

    public ExecutionGroupFlowEntity selectByFlowId(Long flowId) {
        return executionGroupFlowRepository.findByFlowId(flowId);
    }


    public List<ExecutionGroupFlowEntity> selectAll() {
        return executionGroupFlowRepository.findAll();
    }

    @Transactional
    public ExecutionGroupFlowEntity save(ModelParamExecutionGroupFlow modelParam) {
        ExecutionGroupFlowEntity entity = ExecutionGroupFlowEntity.builder()
                .execGroupId(modelParam.getExecGroupId())
                .flowId(modelParam.getFlowId())
                .build();

        Long lastID = executionGroupFlowRepository.save(entity).getExecGroupId();
        return select(lastID);
    }

    @Transactional
    public Long update(long id, ModelParamExecutionGroupFlow modelParam) {

        ExecutionGroupFlowEntity entity = select(id);
        entity.update(modelParam.getExecGroupId(), modelParam.getFlowId());
        return id;
    }

    @Transactional
    public boolean delete(long id) {
        ExecutionGroupFlowEntity entity = select(id);
        if (entity == null)
            return false;
        executionGroupFlowRepository.delete(entity);
        return true;
    }

    public long getCount() {
        return executionGroupFlowRepository.count();
    }
}