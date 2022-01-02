package com.teros.central_server.service.internal.apiservice.app;

import com.teros.central_server.common.network.RemoteNetworkCall;
import com.teros.central_server.entity.apiservice.api.APIEntity;
import com.teros.central_server.service.database.apiservice.api.APIService;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.net.Socket;

@Service
public class AppInternalService {

    private final RemoteNetworkCall remoteNetworkCall;
    private final APIService apiService;

    public AppInternalService(RemoteNetworkCall remoteNetworkCall, APIService apiService) {
        this.remoteNetworkCall = remoteNetworkCall;
        this.apiService = apiService;
    }

    public boolean isHostAlive(String ip, Long port)
    {
        boolean result = false;
        int intPort = port.intValue();

        try {
            (new Socket(ip, intPort)).close();
            result = true;
        }
        catch(Exception e) {
        }
        return result;
    }

    public boolean deployConfig(String ip, Long port, Long apiId)
    {
        APIEntity apiEntity = apiService.getAPI(apiId);

        String configName = apiEntity.getApiName();
        String configContents = apiEntity.getConfigContents();

        String apiControlURL = String.format("http://%s:%s/api-control-manager/v1/config/deploy?configName=%s", ip, port, configName);
        remoteNetworkCall.requestRestEntity(apiControlURL, HttpMethod.POST, configContents);

        return true;
    }
}
