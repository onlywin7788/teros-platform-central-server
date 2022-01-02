package com.teros.central_server.service.internal.apiservice.app;

import com.teros.central_server.common.network.RemoteNetworkCall;
import com.teros.central_server.entity.apiservice.api.APIEntity;
import com.teros.central_server.service.database.apiservice.api.APIService;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.net.Socket;

@Service
public class AppInternalService {

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
}
