package com.teros.central_server.model.usm.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ModelParamUser {

    @ApiModelProperty(value = "userName", required = true)
    private String userName;

    @ApiModelProperty(value = "password", required = true)
    private String password;

    @ApiModelProperty(value = "email", required = true)
    private String email;

    @ApiModelProperty(value = "description", required = false)
    private String description;
}
