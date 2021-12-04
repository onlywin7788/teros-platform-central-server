package com.teros.central_server.internal.appm.app;

import com.teros.central_server.service.internal.appm.app.AppInternalService;
import org.junit.jupiter.api.Test;

public class AppInternalServiceTest {

    AppInternalService appInternalService = new AppInternalService();

    @Test
    public void isHostAliveTest()
    {
        String ip = "127.0.0.1";
        long port = 48081;

        boolean ret = appInternalService.isHostAlive(ip, port);
        System.out.println(ret);
    }

}
