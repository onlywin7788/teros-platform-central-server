package com.teros.central_server.controller.api.v1.database.apiservice.project;

import com.teros.central_server.entity.apiservice.project.APIProjectEntity;
import com.teros.central_server.model.apiservice.project.ModelParamAPIProject;
import com.teros.central_server.model.response.CommonResult;
import com.teros.central_server.model.response.ListResult;
import com.teros.central_server.model.response.SingleResult;
import com.teros.central_server.service.database.apiservice.project.APIProjectService;
import com.teros.central_server.service.database.apiservice.response.ResponseService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"1-1. api-service : project"})
@RestController
@RequestMapping(value = "/v1/api-service/project")
public class APIProjectRestController {

    private APIProjectService apiProjectService;
    private ResponseService responseService;

    public APIProjectRestController(APIProjectService apiProjectService, ResponseService responseService) {
        this.apiProjectService = apiProjectService;
        this.responseService = responseService;
    }

    @GetMapping(value = "/{id}")
    public SingleResult<APIProjectEntity> getAPI(@PathVariable long id) {
        return responseService.getSingleResult(apiProjectService.getAPIProject(id));
    }

    @GetMapping(value = "")
    public ListResult<APIProjectEntity> getAPIList() {
        return responseService.getListResult(apiProjectService.getAPIProjectList());
    }

    @PostMapping(value = "")
    public SingleResult<APIProjectEntity> insertAPI(@RequestBody ModelParamAPIProject model) {
        return responseService.getSingleResult(apiProjectService.saveAPIProject(model));
    }

    @PutMapping(value = "/{id}")
    public Long updateAPI(@PathVariable long id, @RequestBody ModelParamAPIProject model) {
        return apiProjectService.updateAPIProject(id, model);
    }

    @DeleteMapping(value = "/{id}")
    public CommonResult deleteAPI(@PathVariable long id) {
        boolean ret = apiProjectService.deleteAPIProject(id);
        return responseService.getResult(ret);
    }
}