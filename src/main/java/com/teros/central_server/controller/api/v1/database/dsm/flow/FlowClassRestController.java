package com.teros.central_server.controller.api.v1.database.dsm.flow;

import com.teros.central_server.entity.dsm.flow.FlowClassEntry;
import com.teros.central_server.model.response.ListResult;
import com.teros.central_server.model.response.SingleResult;
import com.teros.central_server.service.database.apim.response.ResponseService;
import com.teros.central_server.service.database.dsm.flow.FlowClassService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"dsm : flow-class"})
@RestController
@RequestMapping(value = "/v1")
public class FlowClassRestController {

    private final FlowClassService flowClassService;
    private final ResponseService responseService;

    public FlowClassRestController(FlowClassService flowClassService, ResponseService responseService) {
        this.flowClassService = flowClassService;
        this.responseService = responseService;
    }


    @GetMapping(value = "/flow/class/{id}")
    public SingleResult<FlowClassEntry> selectData(@PathVariable long id) {
        return responseService.getSingleResult(flowClassService.select((id)));
    }

    @GetMapping(value = "/flow/class/class-name")
    public SingleResult<FlowClassEntry> selectDataByClassName(@RequestParam("className") String className)
            {
        return responseService.getSingleResult(flowClassService.selectByClassName(className));
    }

    @GetMapping(value = "/flow/class")
    public ListResult<FlowClassEntry> selectDataAll() {
        return responseService.getListResult(flowClassService.selectAll());
    }

}