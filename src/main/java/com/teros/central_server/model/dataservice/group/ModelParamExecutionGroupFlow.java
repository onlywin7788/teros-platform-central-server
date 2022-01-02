package com.teros.central_server.model.dataservice.group;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ModelParamExecutionGroupFlow {

    @ApiModelProperty(value = "execGroupId", required = true)
    private Long execGroupId;

    @ApiModelProperty(value = "intfId", required = true)
    private Long intfId;
}
