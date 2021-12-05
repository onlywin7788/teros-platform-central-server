package com.teros.central_server.model.dataservice.intf;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ModelParamInterfaceComponent {
    @ApiModelProperty(value = "componentName", required = true)
    private String componentName;

    @ApiModelProperty(value = "componentName", required = false)
    private String componentLoad;
}
