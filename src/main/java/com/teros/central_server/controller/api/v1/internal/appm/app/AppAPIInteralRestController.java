package com.teros.central_server.controller.api.v1.internal.appm.app;

import com.teros.central_server.model.response.CommonResult;
import com.teros.central_server.service.database.apiservice.response.ResponseService;
import com.teros.central_server.service.internal.apiservice.app.APIServiceInternalService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"appm : api-internal-service"})
@RestController
@RequestMapping(value = "/v1")
public class AppAPIInteralRestController {

    private final APIServiceInternalService appInternalService;
    private final ResponseService responseService;

    public AppAPIInteralRestController(APIServiceInternalService appInternalService, ResponseService responseService) {
        this.appInternalService = appInternalService;
        this.responseService = responseService;
    }

    @PostMapping(value = "/internal/appm/app/deploy")
    public CommonResult deployConfig(@RequestParam String host, @RequestParam long port, @RequestParam long apiId) throws Exception{

        boolean ret =  appInternalService.deployConfig(host, port, apiId);
        return responseService.getResult(ret);
    }
}
