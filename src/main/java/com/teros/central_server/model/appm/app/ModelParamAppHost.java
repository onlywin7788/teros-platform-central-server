package com.teros.central_server.model.appm.app;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ModelParamAppHost {

    @ApiModelProperty(value = "hostName", required = true)
    private String hostName;

    @ApiModelProperty(value = "description", required = false)
    private String description;

    @ApiModelProperty(value = "appTypeId", required = true)
    private Long appTypeId;
}
