package com.teros.central_server.service.database.dataservice.group;

import com.teros.central_server.controller.advice.exception.CommonException;
import com.teros.central_server.entity.dataservice.group.ExecutionGroupEntity;
import com.teros.central_server.model.dataservice.group.ModelParamExecutionGroup;
import com.teros.central_server.repository.dataservice.group.ExecutionGroupRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class ExecutionGroupService {

    private final ExecutionGroupRepository executionGroupRepository;

    public ExecutionGroupService(ExecutionGroupRepository executionGroupRepository) {
        this.executionGroupRepository = executionGroupRepository;
    }

    public ExecutionGroupEntity select(Long id) {
        return executionGroupRepository.findById(id).orElseThrow(() ->
                new CommonException("EX"));
    }

    public List<ExecutionGroupEntity> selectAll() {
        return executionGroupRepository.findAll();
    }

    public ExecutionGroupEntity findGroupByGroupFlowId(Long flowId){
        return executionGroupRepository.findGroupByGroupFlowId(flowId);
    }

    @Transactional
    public ExecutionGroupEntity save(ModelParamExecutionGroup modelParam) {
        ExecutionGroupEntity entity = ExecutionGroupEntity.builder()
                .execGroupName(modelParam.getExecGroupName())
                .description(modelParam.getDescription())
                .build();

        Long lastID = executionGroupRepository.save(entity).getExecGroupId();
        return select(lastID);
    }

    @Transactional
    public Long update(long id, ModelParamExecutionGroup modelParam) {

        ExecutionGroupEntity entity = select(id);
        entity.update(modelParam.getExecGroupName(), modelParam.getDescription());
        return id;
    }

    @Transactional
    public boolean delete(long id) {
        ExecutionGroupEntity entity = select(id);
        if (entity == null)
            return false;
        executionGroupRepository.delete(entity);
        return true;
    }

    public long getCount() {
        return executionGroupRepository.count();
    }
}