package br.com.Ifood.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequest {

    private String id;
    private String CPF;
    private String userName;
    private String fullName;
    private String displayName;
    private String email;
    private String phoneNumber;
}