package com.teros.central_server.service.internal.apiservice.app;

import com.teros.central_server.common.network.RemoteNetworkCall;
import com.teros.central_server.entity.apiservice.api.APIEntity;
import com.teros.central_server.entity.dataservice.intf.InterfaceEntity;
import com.teros.central_server.service.database.dataservice.intf.InterfaceService;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

@Service
public class DataServiceInternalService {

    private final RemoteNetworkCall remoteNetworkCall;
    private final InterfaceService interfaceService;

    public DataServiceInternalService(RemoteNetworkCall remoteNetworkCall, InterfaceService interfaceService) {
        this.remoteNetworkCall = remoteNetworkCall;
        this.interfaceService = interfaceService;
    }


    public boolean deployConfig(String ip, Long port, Long interfaceId)
    {
        InterfaceEntity interfaceEntity = interfaceService.select(interfaceId);

        String configName = interfaceEntity.getIntfName();
        String configContents = interfaceEntity.getConfigContents();

        String apiControlURL = String.format("http://%s:%s/api-control-manager/v1/config/deploy?configName=%s", ip, port, configName);
        remoteNetworkCall.requestRestEntity(apiControlURL, HttpMethod.POST, configContents);

        return true;
    }
}
