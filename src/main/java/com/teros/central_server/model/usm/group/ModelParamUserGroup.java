package com.teros.central_server.model.usm.group;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ModelParamUserGroup {

    @ApiModelProperty(value = "userGroupName", required = true)
    private String userGroupName;

    @ApiModelProperty(value = "description", required = false)
    private String description;
}
