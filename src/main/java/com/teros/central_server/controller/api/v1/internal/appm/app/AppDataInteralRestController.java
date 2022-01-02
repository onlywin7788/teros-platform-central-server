package com.teros.central_server.controller.api.v1.internal.appm.app;

import com.teros.central_server.model.response.CommonResult;
import com.teros.central_server.service.database.apiservice.response.ResponseService;
import com.teros.central_server.service.internal.apiservice.app.DataServiceInternalService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"appm : api-internal-service"})
@RestController
@RequestMapping(value = "/v1")
public class AppDataInteralRestController {

    private final DataServiceInternalService dataInternalService;
    private final ResponseService responseService;

    public AppDataInteralRestController(DataServiceInternalService dataInternalService, ResponseService responseService) {
        this.dataInternalService = dataInternalService;
        this.responseService = responseService;
    }

    @PostMapping(value = "/internal/appm/data/deploy")
    public CommonResult dataDeployConfig(@RequestParam String host, @RequestParam long port, @RequestParam long interfaceId) throws Exception{

        boolean ret =  dataInternalService.deployConfig(host, port, interfaceId);
        return responseService.getResult(ret);
    }
}
