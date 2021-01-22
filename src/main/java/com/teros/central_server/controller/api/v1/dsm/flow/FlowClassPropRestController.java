package com.teros.central_server.controller.api.v1.dsm.flow;

import com.teros.central_server.entity.dsm.flow.FlowClassPropEntry;
import com.teros.central_server.model.response.ListResult;
import com.teros.central_server.model.response.SingleResult;
import com.teros.central_server.service.apim.response.ResponseService;
import com.teros.central_server.service.dsm.flow.FlowClassPropService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"dsm : flow-class-prop"})
@RestController
@RequestMapping(value = "/v1")
public class FlowClassPropRestController {

    private final FlowClassPropService flowClassPropService;
    private final ResponseService responseService;

    public FlowClassPropRestController(FlowClassPropService flowClassPropService, ResponseService responseService) {
        this.flowClassPropService = flowClassPropService;
        this.responseService = responseService;
    }

    @GetMapping(value = "/flow/class/prop/{id}")
    public SingleResult<FlowClassPropEntry> selectData(@PathVariable long id) {
        return responseService.getSingleResult(flowClassPropService.select(id));
    }

    @GetMapping(value = "/flow/class/prop/class-id/{id}")
    public ListResult<FlowClassPropEntry> selectByClassId(@PathVariable long id) {
        return responseService.getListResult(flowClassPropService.selectByClassId(id));
    }

    @GetMapping(value = "/flow/class/prop")
    public ListResult<FlowClassPropEntry> selectDataAll() {
        return responseService.getListResult(flowClassPropService.selectAll());
    }


}