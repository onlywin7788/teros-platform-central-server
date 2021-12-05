package com.teros.central_server.model.dataservice.group;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ModelParamExecutionGroup {

    @ApiModelProperty(value = "execGroupName", required = true)
    private String execGroupName;

    @ApiModelProperty(value = "description", required = false)
    private String description;
}
