package com.teros.central_server.service.dsm.flow;

import com.teros.central_server.controller.advice.exception.CommonException;
import com.teros.central_server.entity.dsm.flow.FlowEntity;
import com.teros.central_server.model.dsm.flow.ModelParamFlow;
import com.teros.central_server.repository.dsm.flow.FlowRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class FlowService {

    private final FlowRepository flowRepository;

    public FlowService(FlowRepository flowRepository) {
        this.flowRepository = flowRepository;
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
                .description(modelParam.getDescription())
                .build();

        Long lastID = flowRepository.save(entity).getFlowId();
        return select(lastID);
    }

    @Transactional
    public Long update(long id, ModelParamFlow modelParam) {

        FlowEntity entity = select(id);
        entity.update(modelParam.getFlowName(), modelParam.getLayout(), modelParam.getDescription());
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