package com.teros.central_server.controller.api.v1.database.appm.app;

import com.teros.central_server.entity.appm.app.AppTypeEntity;
import com.teros.central_server.model.response.ListResult;
import com.teros.central_server.service.database.apiservice.response.ResponseService;
import com.teros.central_server.service.database.appm.app.AppTypeService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"appm : app-type"})
@RestController
@RequestMapping(value = "/v1")
public class AppTypeRestController {

    private final AppTypeService appTypeService;
    private final ResponseService responseService;

    public AppTypeRestController(AppTypeService appTypeService, ResponseService responseService) {
        this.appTypeService = appTypeService;
        this.responseService = responseService;
    }

    @GetMapping(value = "/appm/app/type")
    public ListResult<AppTypeEntity> selectDataAll() {
        return responseService.getListResult(appTypeService.selectAll());
    }
}