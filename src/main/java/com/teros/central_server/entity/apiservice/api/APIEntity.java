package com.teros.central_server.entity.apiservice.api;

import com.teros.central_server.entity.apiservice.common.CommonDateEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "rep_apim_api")
@Getter
@Setter
@NoArgsConstructor
public class APIEntity extends CommonDateEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long apiId;

    @Column(length = 64)
    private String apiName;

    @Column(length = 32)
    private String version;

    @Column
    private String targetUrl;

    @Column
    private String configContents;

    @Column(length = 1048576)
    private String description;

    @Builder
    public APIEntity(String apiName, String version, String targetUrl, String configContents, String description) {

        this.apiName = apiName;
        this.version = version;
        this.targetUrl = targetUrl;
        this.configContents = configContents;
        this.description = description;
    }

    public void update(String apiName, String version, String targetUrl, String configContents, String description) {

        this.apiName = apiName;
        this.version = version;
        this.targetUrl = targetUrl;
        this.configContents = configContents;
        this.description = description;
    }

}