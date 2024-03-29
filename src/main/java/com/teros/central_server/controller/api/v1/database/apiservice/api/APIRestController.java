package com.teros.central_server.controller.api.v1.database.apiservice.api;

import com.teros.central_server.entity.apiservice.api.APIEntity;
import com.teros.central_server.model.apiservice.api.ModelParamAPI;
import com.teros.central_server.model.response.CommonResult;
import com.teros.central_server.model.response.ListResult;
import com.teros.central_server.model.response.SingleResult;
import com.teros.central_server.service.database.apiservice.api.APIService;
import com.teros.central_server.service.database.apiservice.response.ResponseService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"1-2. api-service : api"})
@RestController
@RequestMapping(value = "/v1")
public class APIRestController {

    private APIService apiService;
    private ResponseService responseService;

    public APIRestController(APIService apiService, ResponseService responseService) {
        this.apiService = apiService;
        this.responseService = responseService;
    }

    @GetMapping(value = "/api/{id}")
    public SingleResult<APIEntity> getAPI(@PathVariable long id) {
        return responseService.getSingleResult(apiService.getAPI(id));
    }

    @GetMapping(value = "/api")
    public ListResult<APIEntity> getAPIList() {
        return responseService.getListResult(apiService.getAPIList());
    }

    @PostMapping(value = "/api")
    public SingleResult<APIEntity> insertAPI(@RequestBody ModelParamAPI modelParamAPI) {
        return responseService.getSingleResult(apiService.saveAPI(modelParamAPI));
    }

    @PutMapping(value = "/api/{id}")
    public Long updateAPI(@PathVariable long id, @RequestBody ModelParamAPI modelParamAPI) {
        return apiService.updateAPI(id, modelParamAPI);
    }

    @DeleteMapping(value = "/api/{id}")
    public CommonResult deleteAPI(@PathVariable long id) {
        boolean ret = apiService.deleteAPI(id);
        return responseService.getResult(ret);
    }
}