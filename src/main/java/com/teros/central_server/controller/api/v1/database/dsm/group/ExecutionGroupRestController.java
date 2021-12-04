package com.teros.central_server.controller.api.v1.database.dsm.group;

import com.teros.central_server.entity.dsm.group.ExecutionGroupEntity;
import com.teros.central_server.model.dsm.group.ModelParamExecutionGroup;
import com.teros.central_server.model.response.CommonResult;
import com.teros.central_server.model.response.ListResult;
import com.teros.central_server.model.response.SingleResult;
import com.teros.central_server.service.database.apim.response.ResponseService;
import com.teros.central_server.service.database.dsm.group.ExecutionGroupService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"dsm : execution-group"})
@RestController
@RequestMapping(value = "/v1")
public class ExecutionGroupRestController {

    private final ExecutionGroupService executionGroupService;
    private final ResponseService responseService;

    public ExecutionGroupRestController(ExecutionGroupService userGroupService, ResponseService responseService) {
        this.executionGroupService = userGroupService;
        this.responseService = responseService;
    }


    @PostMapping(value = "/exec-group")
    public SingleResult<ExecutionGroupEntity> insertData(@RequestBody ModelParamExecutionGroup modelParam) {
        return responseService.getSingleResult(executionGroupService.save(modelParam));
    }

    @GetMapping(value = "/exec-group/{id}")
    public SingleResult<ExecutionGroupEntity> selectData(@PathVariable long id) {
        return responseService.getSingleResult(executionGroupService.select((id)));
    }

    @GetMapping(value = "/exec-group/group-flow-id/{id}")
    public SingleResult<ExecutionGroupEntity> selectDataByGroupFlowId(@PathVariable long id) {
        return responseService.getSingleResult(executionGroupService.findGroupByGroupFlowId((id)));
    }

    @GetMapping(value = "/exec-group")
    public ListResult<ExecutionGroupEntity> selectDataAll() {
        return responseService.getListResult(executionGroupService.selectAll());
    }

    @PutMapping(value = "/exec-group/{id}")
    public Long updateData(@PathVariable long id, @RequestBody ModelParamExecutionGroup modelParam) {
        return executionGroupService.update(id, modelParam);
    }

    @DeleteMapping(value = "/exec-group/{id}")
    public CommonResult deleteData(@PathVariable long id) {
        boolean ret = executionGroupService.delete(id);
        return responseService.getResult(ret);
    }
}