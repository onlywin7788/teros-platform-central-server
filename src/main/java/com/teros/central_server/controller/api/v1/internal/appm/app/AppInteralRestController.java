package com.teros.central_server.controller.api.v1.internal.appm.app;

import com.teros.central_server.model.response.CommonResult;
import com.teros.central_server.service.database.apiservice.response.ResponseService;
import com.teros.central_server.service.internal.apiservice.app.AppInternalService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"appm : internal-service"})
@RestController
@RequestMapping(value = "/v1")
public class AppInteralRestController {

    private final AppInternalService appInternalService;
    private final ResponseService responseService;

    public AppInteralRestController(AppInternalService appInternalService, ResponseService responseService) {
        this.appInternalService = appInternalService;
        this.responseService = responseService;
    }

    @GetMapping(value = "/internal/appm/app/host")
    public CommonResult isHostAlive(@RequestParam String host, @RequestParam long port) throws Exception{

        boolean ret =  appInternalService.isHostAlive(host, port);
        return responseService.getResult(ret);
    }

    @PostMapping(value = "/internal/appm/app/deploy")
    public CommonResult deployConfig(@RequestParam String host, @RequestParam long port, @RequestParam long apiId) throws Exception{

        boolean ret =  appInternalService.deployConfig(host, port, apiId);
        return responseService.getResult(ret);
    }
}
