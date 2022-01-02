package com.teros.central_server.service.database.apiservice.api.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class APIConfigRouteMaker {

    public String createRouteList(String name, String version, String sourcePath, String targetPath, String method, String uri) {

        APIConfigRoute apiConfigRoute = new APIConfigRoute();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String baseURI = String.format("/%s/%s", name, version);

        // id
        apiConfigRoute.setId(String.format("%s@%s", name, version));

        // set predicates
        HashMap predicatesPathMap = new HashMap();
        HashMap predicatesPathArgsMap = new HashMap();

        HashMap predicatesMethodMap = new HashMap();
        HashMap predicatesMethodArgsMap = new HashMap();
        List predicatesList = new ArrayList();

        // path
        predicatesPathMap.put("name", "Path");
        predicatesPathArgsMap.put("_genkey_0", baseURI + sourcePath);
        predicatesPathMap.put("args", predicatesPathArgsMap);

        // method
        predicatesMethodMap.put("name", "Method");
        predicatesMethodArgsMap.put("type", method);
        predicatesMethodMap.put("args", predicatesMethodArgsMap);

        predicatesList.add(predicatesPathMap);
        predicatesList.add(predicatesMethodMap);
        apiConfigRoute.setPredicates(predicatesList);

        // set filter
        List<String> filterList = new ArrayList<String>();
        filterList.add(String.format("RewritePath=%s%s,%s", baseURI, sourcePath, targetPath));
        apiConfigRoute.setFilters(filterList);

        // set uri
        apiConfigRoute.setUri(uri);

        String jsonString = gson.toJson(apiConfigRoute);

        return jsonString;
    }
}
