package com.teros.central_server.model.dataservice.intf.update;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ModelParamInterfaceConfig {
    @ApiModelProperty(value = "configContents", required = true)
    private String configContents;
}
