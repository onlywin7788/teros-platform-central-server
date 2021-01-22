package com.teros.central_server.model.dsm.flow;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ModelParamFlowClassProp {

    @ApiModelProperty(value = "propName", required = false)
    private String flowName;

    @ApiModelProperty(value = "displayName", required = false)
    private String layout;

    @ApiModelProperty(value = "description", required = false)
    private String description;
}
