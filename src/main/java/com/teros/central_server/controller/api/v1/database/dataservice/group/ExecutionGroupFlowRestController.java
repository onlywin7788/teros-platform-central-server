package com.teros.central_server.controller.api.v1.database.dataservice.group;

import com.teros.central_server.entity.dataservice.group.ExecutionGroupFlowEntity;
import com.teros.central_server.model.dataservice.group.ModelParamExecutionGroupFlow;
import com.teros.central_server.model.response.CommonResult;
import com.teros.central_server.model.response.ListResult;
import com.teros.central_server.model.response.SingleResult;
import com.teros.central_server.service.database.apiservice.response.ResponseService;
import com.teros.central_server.service.database.dataservice.group.ExecutionGroupFlowService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"data-service : execution-group-flow"})
@RestController
@RequestMapping(value = "/v1")
public class ExecutionGroupFlowRestController {

    private final ExecutionGroupFlowService executionGroupFlowService;
    private final ResponseService responseService;

    public ExecutionGroupFlowRestController(ExecutionGroupFlowService executionGroupFlowService, ResponseService responseService) {
        this.executionGroupFlowService = executionGroupFlowService;
        this.responseService = responseService;
    }


    @PostMapping(value = "/exec-group-flow")
    public SingleResult<ExecutionGroupFlowEntity> insertData(@RequestBody ModelParamExecutionGroupFlow modelParam) {
        return responseService.getSingleResult(executionGroupFlowService.save(modelParam));
    }

    @GetMapping(value = "/exec-group-flow/{id}")
    public SingleResult<ExecutionGroupFlowEntity> selectData(@PathVariable long id) {
        return responseService.getSingleResult(executionGroupFlowService.select((id)));
    }

    @GetMapping(value = "/exec-group-flow/find-by-flow-id")
    public SingleResult<ExecutionGroupFlowEntity> selectDataByGroupIdAndFlowId(@RequestParam("flowId") Long flowId) {
        return responseService.getSingleResult(executionGroupFlowService.selectByIntfId(flowId));
    }

    @GetMapping(value = "/exec-group-flow")
    public ListResult<ExecutionGroupFlowEntity> selectDataAll() {
        return responseService.getListResult(executionGroupFlowService.selectAll());
    }

    @PutMapping(value = "/exec-group-flow/{id}")
    public Long updateData(@PathVariable long id, @RequestBody ModelParamExecutionGroupFlow modelParam) {
        return executionGroupFlowService.update(id, modelParam);
    }

    @DeleteMapping(value = "/exec-group-flow/{id}")
    public CommonResult deleteData(@PathVariable long id) {
        boolean ret = executionGroupFlowService.delete(id);
        return responseService.getResult(ret);
    }
}