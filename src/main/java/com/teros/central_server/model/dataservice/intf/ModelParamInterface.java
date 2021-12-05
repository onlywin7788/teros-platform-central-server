package com.teros.central_server.model.dataservice.intf;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ModelParamInterface {

    @ApiModelProperty(value = "intfName", required = true)
    private String intfName;

    @ApiModelProperty(value = "layout", required = true)
    private String layout;

    @ApiModelProperty(value = "configContents", required = false)
    private String configContents;


    @ApiModelProperty(value = "description", required = false)
    private String description;
}
