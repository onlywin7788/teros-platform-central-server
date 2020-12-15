package com.teros.central_server.model.appm.app;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ModelParamAppGroup {

    @ApiModelProperty(value = "groupName", required = true)
    private String apiName;

    @ApiModelProperty(value = "description", required = false)
    private String description;
}
