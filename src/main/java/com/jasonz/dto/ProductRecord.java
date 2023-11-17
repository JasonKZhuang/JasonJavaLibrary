package com.jasonz.dto;

import java.util.Date;

/**
 * @author Jason Zhuang
 * @created 2023.11.16 13:21
 * @project JasonJavaLibrary
 * @description: If you want to transfer immutable data between different layers of your application,
 *  then using a record in Java can be a good choice. For example  Data transfer objects (DTOs):
 */
public record ProductRecord(Long id, String name, Float price, Date producedDate, String description){}