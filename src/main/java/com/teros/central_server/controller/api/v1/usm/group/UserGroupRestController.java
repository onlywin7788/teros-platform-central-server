package com.teros.central_server.controller.api.v1.usm.group;

import com.teros.central_server.entity.appm.app.AppEntity;
import com.teros.central_server.entity.appm.app.AppGroupEntity;
import com.teros.central_server.entity.appm.app.AppTypeEntity;
import com.teros.central_server.entity.usm.group.UserGroupEntity;
import com.teros.central_server.model.appm.app.ModelParamApp;
import com.teros.central_server.model.response.CommonResult;
import com.teros.central_server.model.response.ListResult;
import com.teros.central_server.model.response.SingleResult;
import com.teros.central_server.model.usm.group.ModelParamUserGroup;
import com.teros.central_server.model.usm.user.ModelParamUser;
import com.teros.central_server.service.apim.response.ResponseService;
import com.teros.central_server.service.usm.group.UserGroupService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"usm : user-group"})
@RestController
@RequestMapping(value = "/v1")
public class UserGroupRestController {

    private final UserGroupService userGroupService;
    private final ResponseService responseService;

    public UserGroupRestController(UserGroupService userGroupService, ResponseService responseService) {
        this.userGroupService = userGroupService;
        this.responseService = responseService;
    }

    @PostMapping(value = "/user-group")
    public SingleResult<UserGroupEntity> insertApp(@RequestBody ModelParamUserGroup modelParam) {
        return responseService.getSingleResult(userGroupService.save(modelParam));
    }

    @GetMapping(value = "/user-group/{id}")
    public SingleResult<UserGroupEntity> selectUserGroup(@PathVariable long id) {
        return responseService.getSingleResult(userGroupService.select((id)));
    }

    @GetMapping(value = "/user-group")
    public ListResult<UserGroupEntity> selectUserGroupAll() {
        return responseService.getListResult(userGroupService.selectAll());
    }

    @PutMapping(value = "/user-group/{id}")
    public Long updateUserGroup(@PathVariable long id, @RequestBody ModelParamUserGroup modelParam) {
        return userGroupService.update(id, modelParam);
    }

    @DeleteMapping(value = "/user-group/{id}")
    public CommonResult deleteUserGroup(@PathVariable long id) {
        boolean ret = userGroupService.delete(id);
        return responseService.getResult(ret);
    }
}