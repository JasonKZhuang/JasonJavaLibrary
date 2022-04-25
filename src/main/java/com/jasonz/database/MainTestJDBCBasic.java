package com.jasonz.database;

import com.jasonz.database.enity.UserRequest;
import com.jasonz.database.repository.UserRequestRepository;

import java.util.Date;


/**
 * @author : Jason Zhuang
 * @date : 25/4/2022
 * @description :
 */
public class MainTestJDBCBasic {
    public static void main(String[] args) {
        UserRequestRepository userRequestRepository = new UserRequestRepository();
        userRequestRepository.getRecords();

        UserRequest userRequest = UserRequest.builder()
                .userId(1)
                .productId(1)
                .content("some contents")
                .createOn(new Date())
                .updateOn(new Date())
                .build();
        userRequestRepository.saveRecords(userRequest);
    }
}
