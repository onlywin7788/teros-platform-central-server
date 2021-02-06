package com.teros.central_server.controller.api.v1.appm.app;

import com.teros.central_server.entity.appm.app.AppHostEntity;
import com.teros.central_server.model.appm.app.ModelParamAppHost;
import com.teros.central_server.model.response.CommonResult;
import com.teros.central_server.model.response.ListResult;
import com.teros.central_server.model.response.SingleResult;
import com.teros.central_server.service.apim.response.ResponseService;
import com.teros.central_server.service.appm.app.AppHostService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"appm : app-host"})
@RestController
@RequestMapping(value = "/v1")
public class AppHostRestController {

    private final AppHostService appHostService;
    private final ResponseService responseService;

    public AppHostRestController(AppHostService appHostService, ResponseService responseService) {
        this.appHostService = appHostService;
        this.responseService = responseService;
    }

    @PostMapping(value = "/appm/app/host")
    public SingleResult<AppHostEntity> insertData(@RequestBody ModelParamAppHost modelParam) throws Exception{
        return responseService.getSingleResult(appHostService.save(modelParam));
    }

    @GetMapping(value = "/appm/app/host/{id}")
    public SingleResult<AppHostEntity> selectData(@PathVariable long id) {
        return responseService.getSingleResult(appHostService.select((id)));
    }

    @GetMapping(value = "/appm/app/host")
    public ListResult<AppHostEntity> selectDataAll() {
        return responseService.getListResult(appHostService.selectAll());
    }

    @PutMapping(value = "/appm/app/host/{id}")
    public Long updateData(@PathVariable long id, @RequestBody ModelParamAppHost modelParam) throws Exception{
        return appHostService.update(id, modelParam);
    }

    @DeleteMapping(value = "/appm/app/host/{id}")
    public CommonResult deleteData(@PathVariable long id) {
        boolean ret = appHostService.delete(id);
        return responseService.getResult(ret);
    }
}