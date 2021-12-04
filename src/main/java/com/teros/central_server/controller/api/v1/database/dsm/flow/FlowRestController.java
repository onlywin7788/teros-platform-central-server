package com.teros.central_server.controller.api.v1.database.dsm.flow;

import com.teros.central_server.entity.dsm.flow.FlowEntity;
import com.teros.central_server.model.dsm.flow.ModelParamFlow;
import com.teros.central_server.model.dsm.flow.update.ModelParamFlowConfig;
import com.teros.central_server.model.response.CommonResult;
import com.teros.central_server.model.response.ListResult;
import com.teros.central_server.model.response.SingleResult;
import com.teros.central_server.service.database.apim.response.ResponseService;
import com.teros.central_server.service.database.dsm.flow.FlowService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"dsm : flow"})
@RestController
@RequestMapping(value = "/v1")
public class FlowRestController {

    private final FlowService flowService;
    private final ResponseService responseService;

    public FlowRestController(FlowService flowService, ResponseService responseService) {
        this.flowService = flowService;
        this.responseService = responseService;
    }


    @PostMapping(value = "/flow")
    public SingleResult<FlowEntity> insertData(@RequestBody ModelParamFlow modelParam) throws Exception{
        return responseService.getSingleResult(flowService.save(modelParam));
    }

    @GetMapping(value = "/flow/{id}")
    public SingleResult<FlowEntity> selectData(@PathVariable long id) {
        return responseService.getSingleResult(flowService.select((id)));
    }

    @GetMapping(value = "/flow")
    public ListResult<FlowEntity> selectDataAll() {
        return responseService.getListResult(flowService.selectAll());
    }

    @PutMapping(value = "/flow/{id}")
    public Long updateData(@PathVariable long id, @RequestBody ModelParamFlow modelParam) throws Exception{
        return flowService.update(id, modelParam);
    }

    @PutMapping(value = "/flow/config/{id}")
    public Long updateDataConfigContents(@PathVariable long id, @RequestBody ModelParamFlowConfig modelParam) throws Exception{
        return flowService.updateConfigContents(id, modelParam);
    }

    @DeleteMapping(value = "/flow/{id}")
    public CommonResult deleteData(@PathVariable long id) {
        boolean ret = flowService.delete(id);
        return responseService.getResult(ret);
    }

}