package com.teros.central_server.controller.api.v1.database.dataservice.intf;

import com.teros.central_server.entity.dataservice.intf.InterfaceComponentPropEntity;
import com.teros.central_server.model.response.ListResult;
import com.teros.central_server.model.response.SingleResult;
import com.teros.central_server.service.database.apiservice.response.ResponseService;
import com.teros.central_server.service.database.dataservice.intf.InterfaceComponentPropService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"2-4. data-service : interface-component-prop"})
@RestController
@RequestMapping(value = "/v1/data-service/interface/component/prop")
public class InterfaceComponentPropRestController {

    private final InterfaceComponentPropService service;
    private final ResponseService responseService;

    public InterfaceComponentPropRestController(InterfaceComponentPropService service, ResponseService responseService) {
        this.service = service;
        this.responseService = responseService;
    }

    @GetMapping(value = "/{id}")
    public SingleResult<InterfaceComponentPropEntity> selectData(@PathVariable long id) {
        return responseService.getSingleResult(service.select(id));
    }

    @GetMapping(value = "/find-by-component-id")
    public ListResult<InterfaceComponentPropEntity> selectByComponentId(@RequestParam(value = "id")Long id) {
        return responseService.getListResult(service.selectBycomponentId(id));
    }

    @GetMapping(value = "/flow/class/prop")
    public ListResult<InterfaceComponentPropEntity> selectDataAll() {
        return responseService.getListResult(service.selectAll());
    }


}