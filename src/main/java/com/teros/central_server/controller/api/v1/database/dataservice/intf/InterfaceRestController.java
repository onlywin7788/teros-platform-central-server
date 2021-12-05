package com.teros.central_server.controller.api.v1.database.dataservice.intf;

import com.teros.central_server.entity.dataservice.intf.InterfaceEntity;
import com.teros.central_server.model.dataservice.intf.ModelParamInterface;
import com.teros.central_server.model.dataservice.intf.update.ModelParamInterfaceConfig;
import com.teros.central_server.model.response.CommonResult;
import com.teros.central_server.model.response.ListResult;
import com.teros.central_server.model.response.SingleResult;
import com.teros.central_server.service.database.apiservice.response.ResponseService;
import com.teros.central_server.service.database.dataservice.intf.InterfaceService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"2-2. data-service : interface"})
@RestController
@RequestMapping(value = "/v1/data-service/interface")
public class InterfaceRestController {

    private final InterfaceService interfaceService;
    private final ResponseService responseService;

    public InterfaceRestController(InterfaceService interfaceService, ResponseService responseService) {
        this.interfaceService = interfaceService;
        this.responseService = responseService;
    }


    @PostMapping(value = "")
    public SingleResult<InterfaceEntity> insertData(@RequestBody ModelParamInterface model) throws Exception{
        return responseService.getSingleResult(interfaceService.save(model));
    }

    @GetMapping(value = "/{id}")
    public SingleResult<InterfaceEntity> selectData(@PathVariable long id) {
        return responseService.getSingleResult(interfaceService.select((id)));
    }

    @GetMapping(value = "")
    public ListResult<InterfaceEntity> selectDataAll() {
        return responseService.getListResult(interfaceService.selectAll());
    }

    @PutMapping(value = "/{id}")
    public Long updateData(@PathVariable long id, @RequestBody ModelParamInterface model) throws Exception{
        return interfaceService.update(id, model);
    }

    @PutMapping(value = "/{id}/config")
    public Long updateDataConfigContents(@PathVariable long id, @RequestBody ModelParamInterfaceConfig model) throws Exception{
        return interfaceService.updateConfigContents(id, model);
    }

    @DeleteMapping(value = "/{id}")
    public CommonResult deleteData(@PathVariable long id) {
        boolean ret = interfaceService.delete(id);
        return responseService.getResult(ret);
    }

}