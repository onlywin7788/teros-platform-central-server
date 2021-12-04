package com.teros.central_server.entity.usm.group;

import com.teros.central_server.entity.apiservice.common.CommonDateEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "rep_usm_user_group")
@Getter
@Setter
@NoArgsConstructor
public class UserGroupEntity extends CommonDateEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userGroupId;

    @Column(length = 64)
    private String userGroupName;

    @Column(length = 1048576)
    private String description;

    @Builder
    public UserGroupEntity(String userGroupName, String description) {
        this.userGroupName = userGroupName;
        this.description = description;
    }

    public void update(String userGroupName, String description) {
        this.userGroupName = userGroupName;
        this.description = description;
    }

}