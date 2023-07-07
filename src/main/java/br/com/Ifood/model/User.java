package br.com.Ifood.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
@Setter
@Entity
@Table(name = "usuarios")
public class User {

    @Id
    private String id;
    @Column(name = "username")
    private String userName;
    @Column(name = "fullname")
    private String fullName;
    @Column(name = "displayname")
    private String displayName;
    @Column(name = "email")
    private String email;
    @Column(name = "phonenumber")
    private String phoneNumber;
    @CPF
    @Column(name = "cpf")
    private String CPF;

}
