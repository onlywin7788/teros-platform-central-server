package com.teros.central_server.model.dsm.flow;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ModelParamFlowClass {
    @ApiModelProperty(value = "className", required = false)
    private String className;
}
