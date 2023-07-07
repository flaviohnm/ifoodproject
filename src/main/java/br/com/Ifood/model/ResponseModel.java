package br.com.Ifood.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseModel {

    private Integer statusCode;
    private String body;

}
