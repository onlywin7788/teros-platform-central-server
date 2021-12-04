package com.teros.central_server.service.database.usm.user;


import com.teros.central_server.controller.advice.exception.CommonException;
import com.teros.central_server.entity.usm.user.UserEntity;
import com.teros.central_server.model.usm.user.ModelParamUser;
import com.teros.central_server.repository.usm.user.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;


@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity select(Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new CommonException("EX"));
    }

    public List<UserEntity> selectAll() {
        return userRepository.findAll();
    }

    @Transactional
    public UserEntity save(ModelParamUser modelParam) throws Exception {

        String password = getSHA512FromPassword(modelParam.getPassword());

        UserEntity entity = UserEntity.builder()
                .userName(modelParam.getUserName())
                .password(password)
                .email(modelParam.getEmail())
                .description(modelParam.getDescription())
                .build();

        Long lastID = userRepository.save(entity).getUserId();
        return select(lastID);
    }

    @Transactional
    public Long update(long id, ModelParamUser modelParam) throws Exception {

        String password = getSHA512FromPassword(modelParam.getPassword());

        UserEntity entity = select(id);
        entity.update(modelParam.getUserName(), password, modelParam.getEmail()
                , modelParam.getDescription());
        return id;
    }

    @Transactional
    public boolean delete(long id) {
        UserEntity entity = select(id);
        if (entity == null)
            return false;
        userRepository.delete(entity);
        return true;
    }

    public long getCount() {
        return userRepository.count();
    }

    public String getSHA512FromPassword(String rawString) throws Exception {
        // sha512
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(rawString.getBytes());
        String password = String.format("%0128x", new BigInteger(1, md.digest()));

        return password;
    }

}