package com.teros.central_server.model.appm.app;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ModelParamApp {

    @ApiModelProperty(value = "appName", required = true)
    private String appName;

    @ApiModelProperty(value = "appTypeId", required = true)
    private long appTypeId;
    
    @ApiModelProperty(value = "hostInfo", required = true)
    private String hostInfo;

    @ApiModelProperty(value = "description", required = false)
    private String description;
}
