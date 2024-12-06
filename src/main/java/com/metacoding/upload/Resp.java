package com.metacoding.upload;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Resp<T> {
    private Boolean success;
    private String msg;
    private T data;
}