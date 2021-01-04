package com.teros.central_server.model.dsm.flow;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ModelParamFlow {

    @ApiModelProperty(value = "flowName", required = true)
    private String flowName;

    @ApiModelProperty(value = "layout", required = true)
    private String layout;

    @ApiModelProperty(value = "description", required = false)
    private String description;
}
