package com.teros.central_server.model.appm.app;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ModelParamAppManager {

    @ApiModelProperty(value = "managerName", required = true)
    private String managerName;

    @ApiModelProperty(value = "host", required = true)
    private String host;

    @ApiModelProperty(value = "port", required = true)
    private Long port;

    @ApiModelProperty(value = "description", required = false)
    private String description;

    @ApiModelProperty(value = "hostId", required = true)
    private Long hostId;
}
