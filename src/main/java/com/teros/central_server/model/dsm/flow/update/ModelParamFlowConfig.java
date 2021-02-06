package com.teros.central_server.model.dsm.flow.update;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ModelParamFlowConfig {
    @ApiModelProperty(value = "configContents", required = true)
    private String configContents;
}
