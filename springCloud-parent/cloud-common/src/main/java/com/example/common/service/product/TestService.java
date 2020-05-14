package com.example.common.service.product;


import com.example.common.entity.UserYYY;
import org.springframework.cloud.openfeign.FeignClient;


/**
 * Created by Administrator on 2019/11/23.
 */
public interface TestService {

    String getTestById(Integer id);

    UserYYY getUserById(Integer id);

    void save();

    void delete();

    void update();
}
