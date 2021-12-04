package com.teros.central_server.controller.api.v1.database.apiservice.api;

import com.teros.central_server.entity.apiservice.api.APIPathEntity;
import com.teros.central_server.model.apim.api.ModelParamAPIPath;
import com.teros.central_server.model.response.CommonResult;
import com.teros.central_server.model.response.ListResult;
import com.teros.central_server.model.response.SingleResult;
import com.teros.central_server.service.database.apiservice.api.APIPathService;
import com.teros.central_server.service.database.apiservice.response.ResponseService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"api-service : api-path"})
@RestController
@RequestMapping(value = "/v1")
public class APIPathRestController {

    private final APIPathService apiPathService;
    private final ResponseService responseService;

    public APIPathRestController(APIPathService apiPathService, ResponseService responseService) {
        this.apiPathService = apiPathService;
        this.responseService = responseService;
    }

    @GetMapping(value = "/api-path/{id}")
    public SingleResult<APIPathEntity> getAPIPath(@PathVariable long id) {
        return responseService.getSingleResult(apiPathService.getAPIPath(id));
    }

    @GetMapping(value = "/api-path-by-api-id/{id}")
    public ListResult<APIPathEntity> getAPIPathByApiId(@PathVariable long id) {
        return responseService.getListResult(apiPathService.getAPIPathByApiId(id));
    }

    @GetMapping(value = "/api-path")
    public ListResult<APIPathEntity> getAPIPathList() {
        return responseService.getListResult(apiPathService.getAPIPathList());
    }

    @PostMapping(value = "/api-path")
    public void insertAPI(@RequestBody ModelParamAPIPath param) {
        apiPathService.saveAPIPath(param);
    }

    @PutMapping(value = "/api-path/{id}")
    public Long updateAPIPath(@PathVariable long id, @RequestBody ModelParamAPIPath param) {
        return apiPathService.updateAPIPath(id, param);
    }

    @DeleteMapping(value = "/api-path/{id}")
    public CommonResult deleteAPIPath(@PathVariable long id) {
        boolean ret = apiPathService.deleteAPIPath(id);
        return responseService.getResult(ret);
    }

    @DeleteMapping(value = "/api-path-by-api-id/{id}")
    public CommonResult deleteAPIPathByApiId(@PathVariable long id) {
        boolean ret = apiPathService.deleteAPIPathListByApiId(id);
        return responseService.getResult(ret);
    }
}