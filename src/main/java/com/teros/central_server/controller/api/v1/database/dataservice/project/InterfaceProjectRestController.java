package com.teros.central_server.controller.api.v1.database.dataservice.project;

import com.teros.central_server.entity.apiservice.project.APIProjectEntity;
import com.teros.central_server.entity.dataservice.project.InterfaceProjectEntity;
import com.teros.central_server.model.apiservice.project.ModelParamAPIProject;
import com.teros.central_server.model.dataservice.project.ModelParamInterfaceProject;
import com.teros.central_server.model.response.CommonResult;
import com.teros.central_server.model.response.ListResult;
import com.teros.central_server.model.response.SingleResult;
import com.teros.central_server.service.database.apiservice.project.APIProjectService;
import com.teros.central_server.service.database.apiservice.response.ResponseService;
import com.teros.central_server.service.database.dataservice.project.InterfaceProjectService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"2-1. data-service : project"})
@RestController
@RequestMapping(value = "/v1/data-service/project")
public class InterfaceProjectRestController {

    private InterfaceProjectService interfaceProjectService;
    private ResponseService responseService;

    public InterfaceProjectRestController(InterfaceProjectService interfaceProjectService, ResponseService responseService) {
        this.interfaceProjectService = interfaceProjectService;
        this.responseService = responseService;
    }

    @GetMapping(value = "/{id}")
    public SingleResult<InterfaceProjectEntity> getOne(@PathVariable long id) {
        return responseService.getSingleResult(interfaceProjectService.getOneRow(id));
    }

    @GetMapping(value = "")
    public ListResult<InterfaceProjectEntity> getList() {
        return responseService.getListResult(interfaceProjectService.getList());
    }

    @PostMapping(value = "")
    public SingleResult<InterfaceProjectEntity> save(@RequestBody ModelParamInterfaceProject model) {
        return responseService.getSingleResult(interfaceProjectService.save(model));
    }

    @PutMapping(value = "/{id}")
    public Long update(@PathVariable long id, @RequestBody ModelParamInterfaceProject model) {
        return interfaceProjectService.updateAPIProject(id, model);
    }

    @DeleteMapping(value = "/{id}")
    public CommonResult delete(@PathVariable long id) {
        boolean ret = interfaceProjectService.deleteAPIProject(id);
        return responseService.getResult(ret);
    }
}