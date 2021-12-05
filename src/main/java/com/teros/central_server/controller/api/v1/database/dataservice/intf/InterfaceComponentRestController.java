package com.teros.central_server.controller.api.v1.database.dataservice.intf;

import com.teros.central_server.entity.dataservice.intf.InterfaceComponentEntity;
import com.teros.central_server.model.response.ListResult;
import com.teros.central_server.model.response.SingleResult;
import com.teros.central_server.service.database.apiservice.response.ResponseService;
import com.teros.central_server.service.database.dataservice.intf.InterfaceComponentService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"2-3. data-service : interface-component"})
@RestController
@RequestMapping(value = "/v1/data-service/interface/component")
public class InterfaceComponentRestController {

    private final InterfaceComponentService flowClassService;
    private final ResponseService responseService;

    public InterfaceComponentRestController(InterfaceComponentService flowClassService, ResponseService responseService) {
        this.flowClassService = flowClassService;
        this.responseService = responseService;
    }


    @GetMapping(value = "/{id}")
    public SingleResult<InterfaceComponentEntity> selectData(@PathVariable long id) {
        return responseService.getSingleResult(flowClassService.select((id)));
    }

    @GetMapping(value = "/find-by-name/{id}")
    public SingleResult<InterfaceComponentEntity> selectDataByClassName(@PathVariable String name) {
        return responseService.getSingleResult(flowClassService.selectByClassName(name));
    }

    @GetMapping(value = "")
    public ListResult<InterfaceComponentEntity> selectDataAll() {
        return responseService.getListResult(flowClassService.selectAll());
    }

}