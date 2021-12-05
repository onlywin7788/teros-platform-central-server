package com.teros.central_server.model.apiservice.project;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ModelParamAPIProject {

    @ApiModelProperty(value = "projectName", required = true)
    private String projectName;

    @ApiModelProperty(value = "description", required = false)
    private String description;
}
