package com.teros.central_server.controller.api.v1.appm.app;

import com.teros.central_server.entity.apim.api.APIEntity;
import com.teros.central_server.entity.appm.app.AppEntity;
import com.teros.central_server.entity.appm.app.AppGroupEntity;
import com.teros.central_server.entity.appm.app.AppTypeEntity;
import com.teros.central_server.model.apim.api.ModelParamAPI;
import com.teros.central_server.model.appm.app.ModelParamApp;
import com.teros.central_server.model.response.CommonResult;
import com.teros.central_server.model.response.ListResult;
import com.teros.central_server.model.response.SingleResult;
import com.teros.central_server.service.apim.response.ResponseService;
import com.teros.central_server.service.appm.app.AppService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"APP"})
@RestController
@RequestMapping(value = "/v1")
public class AppRestController {

    private final AppService appService;
    private final ResponseService responseService;

    public AppRestController(AppService appService, ResponseService responseService) {
        this.appService = appService;
        this.responseService = responseService;
    }

    // app group
    @GetMapping(value = "/app-group/{id}")
    public SingleResult<AppGroupEntity> getAppGroup(@PathVariable long id) {
        return responseService.getSingleResult(appService.getAppGroup(id));
    }

    @GetMapping(value = "/app-group")
    public ListResult<AppGroupEntity> getAppGroupList() {
        return responseService.getListResult(appService.getAppGroupList());
    }

    // app type
    @GetMapping(value = "/app-type/{id}")
    public SingleResult<AppTypeEntity> getAppType(@PathVariable long id) {
        return responseService.getSingleResult(appService.getAppType(id));
    }

    @GetMapping(value = "/app-type")
    public ListResult<AppTypeEntity> getAppTypeList() {
        return responseService.getListResult(appService.getAppTypeList());
    }

    // app
    @GetMapping(value = "/app/{id}")
    public SingleResult<AppEntity> getApp(@PathVariable long id) {
        return responseService.getSingleResult(appService.getApp(id));
    }

    @GetMapping(value = "/app")
    public ListResult<AppEntity> getAppList() {
        return responseService.getListResult(appService.getAppList());
    }

    @PostMapping(value = "/app")
    public SingleResult<AppEntity> insertApp(@RequestBody ModelParamApp modelParamApp) {
        return responseService.getSingleResult(appService.saveApp(modelParamApp));
    }

    @PutMapping(value = "/app/{id}")
    public Long updateApp(@PathVariable long id, @RequestBody ModelParamApp modelParamApp) {
        return appService.updateApp(id, modelParamApp);
    }

    @DeleteMapping(value = "/app/{id}")
    public CommonResult deleteApp(@PathVariable long id) {
        boolean ret = appService.deleteApp(id);
        return responseService.getResult(ret);
    }
}