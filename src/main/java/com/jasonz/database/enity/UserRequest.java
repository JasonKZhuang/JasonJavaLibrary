package com.jasonz.database.enity;

import lombok.*;

import java.io.InputStream;
import java.util.Date;

/**
 * @author : Jason Zhuang
 * @date : 25/4/2022
 * @description :
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserRequest {
    private int id;
    private int userId;
    private int productId;
    private InputStream content;
    private Date createOn;
    private Date updateOn;
}
