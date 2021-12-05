package com.teros.central_server.model.dataservice.intf;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ModelParamInterfaceComponentProp {

    @ApiModelProperty(value = "propName", required = false)
    private String propName;

    @ApiModelProperty(value = "displayName", required = false)
    private String displayName;

    @ApiModelProperty(value = "description", required = false)
    private String description;

    @ApiModelProperty(value = "componentId", required = false)
    private String componentId;
}
