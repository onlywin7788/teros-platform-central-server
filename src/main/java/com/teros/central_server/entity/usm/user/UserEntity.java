package com.teros.central_server.entity.usm.user;

import com.teros.central_server.entity.apiservice.common.CommonDateEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "rep_usm_user")
@Getter
@Setter
@NoArgsConstructor
public class UserEntity extends CommonDateEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(length = 64)
    private String userName;

    @Column(length = 64)
    private String password;

    @Column(length = 64)
    private String email;

    @Column(length = 1048576)
    private String description;

    @Builder
    public UserEntity(String userName, String password, String email, String description) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.description = description;
    }

    public void update(String userName, String password, String email, String description) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.description = description;
    }

}