package com.teros.central_server.controller.api.v1.appm.app;

import com.teros.central_server.entity.appm.app.AppEntity;
import com.teros.central_server.model.response.ListResult;
import com.teros.central_server.service.apim.response.ResponseService;
import com.teros.central_server.service.appm.app.AppService;
import io.swagger.annotations.Api;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
class AppHealthInfo {
    String appId;
    String hostInfo;
    String health;
    int statusCode;
    String Status;
}

@Api(tags = {"APP_INFO"})
@Slf4j
@RestController
@RequestMapping(value = "/v1")
public class AppInfoRestController {

    private final AppService appService;
    private final ResponseService responseService;

    public AppInfoRestController(AppService appService, ResponseService responseService) {
        this.appService = appService;
        this.responseService = responseService;
    }

    @GetMapping(value = "/app-info")
    public ListResult<AppHealthInfo> getAppList() throws Exception {

        List<AppEntity> appEntityList = appService.getAppList();
        List<AppHealthInfo> appHealthInfoList = new ArrayList<AppHealthInfo>();
        AppHealthInfo appHealthInfo = null;

        for (int i = 0; i < appEntityList.size(); i++) {
            AppEntity appEntity = appEntityList.get(i);
            appHealthInfo = new AppHealthInfo();

            appHealthInfo.setAppId(appEntity.getAppId() + "");
            appHealthInfo.setHostInfo(appEntity.getHostInfo());

            try {
                // get actuator/heath
                ResponseEntity<String> responseEntity = remoteExecute(appHealthInfo.getHostInfo() + "/actuator/health"
                        , HttpMethod.GET, null, "");

                appHealthInfo.setHealth("");
            }
            catch (HttpClientErrorException e){
                appHealthInfo.setStatusCode(e.getStatusCode().value());
                appHealthInfo.setStatus(e.getStatusCode().name());
            }
            catch(Exception e2)
            {
                appHealthInfo.setStatusCode(-1);
                appHealthInfo.setStatus(e2.getMessage());
            }

            appHealthInfoList.add(appHealthInfo);
        }

        return responseService.getListResult(appHealthInfoList);
    }


    public ResponseEntity<String> remoteExecute(String url, HttpMethod method, HttpHeaders acquireHeaders, String payload) throws Exception {

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = acquireHeaders;
        if (headers == null) {
            headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
        }

        HttpEntity<String> entity = new HttpEntity<String>(payload, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, method, entity, String.class);

        return responseEntity;
    }

}
