package com.teros.central_server.service.database.apiservice.api.config;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class APIConfigRoute {
    private String id;
    private List predicates;
    private List<String> filters;
    private String uri;

    @Builder
    public APIConfigRoute() {
    }
}