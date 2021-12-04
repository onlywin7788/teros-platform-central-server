package com.teros.central_server.service.internal.apiservice.app;

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
