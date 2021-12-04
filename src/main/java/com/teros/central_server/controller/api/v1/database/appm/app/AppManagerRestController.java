package com.teros.central_server.controller.api.v1.database.appm.app;

import com.teros.central_server.entity.appm.app.AppManagerEntity;
import com.teros.central_server.model.appm.app.ModelParamAppManager;
import com.teros.central_server.model.response.CommonResult;
import com.teros.central_server.model.response.ListResult;
import com.teros.central_server.model.response.SingleResult;
import com.teros.central_server.service.database.apiservice.response.ResponseService;
import com.teros.central_server.service.database.appm.app.AppManagerService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"appm : app-manager"})
@RestController
@RequestMapping(value = "/v1")
public class AppManagerRestController {

    private final AppManagerService appManagerService;
    private final ResponseService responseService;

    public AppManagerRestController(AppManagerService appManagerService, ResponseService responseService) {
        this.appManagerService = appManagerService;
        this.responseService = responseService;
    }

    @PostMapping(value = "/appm/app/manager")
    public SingleResult<AppManagerEntity> insertData(@RequestBody ModelParamAppManager modelParam) throws Exception{
        return responseService.getSingleResult(appManagerService.save(modelParam));
    }

    @GetMapping(value = "/appm/app/manager/{id}")
    public SingleResult<AppManagerEntity> selectData(@PathVariable long id) {
        return responseService.getSingleResult(appManagerService.select((id)));
    }

    @GetMapping(value = "/appm/app/manager/host-id")
    public ListResult<AppManagerEntity> selectByHostId(@RequestParam("hostId") Long hostId) {
        return responseService.getListResult(appManagerService.selectByHostId(hostId));
    }

    @GetMapping(value = "/appm/app/manager")
    public ListResult<AppManagerEntity> selectDataAll() {
        return responseService.getListResult(appManagerService.selectAll());
    }

    @PutMapping(value = "/appm/app/manager/{id}")
    public Long updateData(@PathVariable long id, @RequestBody ModelParamAppManager modelParam) throws Exception{
        return appManagerService.update(id, modelParam);
    }

    @DeleteMapping(value = "/appm/app/manager/{id}")
    public CommonResult deleteData(@PathVariable long id) {
        boolean ret = appManagerService.delete(id);
        return responseService.getResult(ret);
    }

}