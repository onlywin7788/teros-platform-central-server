package com.teros.central_server.service.internal.apiservice.app;

import com.teros.central_server.common.network.RemoteNetworkCall;
import io.swagger.models.HttpMethod;
import org.springframework.stereotype.Service;

import java.net.Socket;

@Service
public class AppInternalService {

    private final RemoteNetworkCall remoteNetworkCall;

    public AppInternalService(RemoteNetworkCall remoteNetworkCall) {
        this.remoteNetworkCall = remoteNetworkCall;
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

    public boolean deployConfig(String ip, Long port)
    {
        remoteNetworkCall.requestRestEntity(baseURL + "/actuator/gateway/refresh" , HttpMethod.POST, "");
    }
}
