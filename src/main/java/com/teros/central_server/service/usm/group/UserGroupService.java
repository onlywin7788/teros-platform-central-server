package com.teros.central_server.service.usm.group;

import com.teros.central_server.controller.advice.exception.CommonException;
import com.teros.central_server.entity.usm.group.UserGroupEntity;
import com.teros.central_server.model.usm.group.ModelParamUserGroup;
import com.teros.central_server.repository.usm.group.UserGroupRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class UserGroupService {

    private final UserGroupRepository userGroupRepository;

    public UserGroupService(UserGroupRepository userGroupRepository) {
        this.userGroupRepository = userGroupRepository;
    }

    public UserGroupEntity select(Long id) {
        return userGroupRepository.findById(id).orElseThrow(() ->
                new CommonException("EX"));
    }

    public List<UserGroupEntity> selectAll() {
        return userGroupRepository.findAll();
    }

    @Transactional
    public UserGroupEntity save(ModelParamUserGroup modelParam) {
        UserGroupEntity entity = UserGroupEntity.builder()
                .userGroupName(modelParam.getUserGroupName())
                .description(modelParam.getDescription())
                .build();

        Long lastID = userGroupRepository.save(entity).getUserGroupId();
        return select(lastID);
    }

    @Transactional
    public Long update(long id, ModelParamUserGroup modelParam) {

        UserGroupEntity entity = select(id);
        entity.update(modelParam.getUserGroupName(), modelParam.getDescription());
        return id;
    }

    @Transactional
    public boolean delete(long id) {
        UserGroupEntity entity = select(id);
        if (entity == null)
            return false;
        userGroupRepository.delete(entity);
        return true;
    }

    public long getCount() {
        return userGroupRepository.count();
    }
}