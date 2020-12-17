package com.teros.central_server.controller.api.v1.usm.user;

import com.teros.central_server.entity.usm.user.UserEntity;
import com.teros.central_server.model.response.CommonResult;
import com.teros.central_server.model.response.ListResult;
import com.teros.central_server.model.response.SingleResult;
import com.teros.central_server.model.usm.user.ModelParamUser;
import com.teros.central_server.service.apim.response.ResponseService;
import com.teros.central_server.service.usm.user.UserService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"usm : user"})
@RestController
@RequestMapping(value = "/v1")
public class UserRestController {

    private final UserService userService;
    private final ResponseService responseService;

    public UserRestController(UserService userService, ResponseService responseService) {
        this.userService = userService;
        this.responseService = responseService;
    }

    @PostMapping(value = "/user")
    public SingleResult<UserEntity> insertApp(@RequestBody ModelParamUser modelParam) throws Exception{
        return responseService.getSingleResult(userService.save(modelParam));
    }

    @GetMapping(value = "/user/{id}")
    public SingleResult<UserEntity> selectUser(@PathVariable long id) {
        return responseService.getSingleResult(userService.select((id)));
    }

    @GetMapping(value = "/user")
    public ListResult<UserEntity> selectUserAll() {
        return responseService.getListResult(userService.selectAll());
    }

    @PutMapping(value = "/user/{id}")
    public Long updateUser(@PathVariable long id, @RequestBody ModelParamUser modelParam) throws Exception{
        return userService.update(id, modelParam);
    }

    @DeleteMapping(value = "/user/{id}")
    public CommonResult deleteUser(@PathVariable long id) {
        boolean ret = userService.delete(id);
        return responseService.getResult(ret);
    }

}