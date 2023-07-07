package br.com.Ifood.service;

import br.com.Ifood.model.ResponseModel;
import br.com.Ifood.model.User;
import br.com.Ifood.model.UsuarioRequest;

import java.util.List;

public interface UserService {

    //bloco de busca
    User findById (String id);
    User findByCPF (String CPF);

    //bloco de listagem
    List<User> listarUsuarios();
    List<User> listarUsuarioByEmail (String email);

    //bloco de cadastro e atualizacao
    ResponseModel cadastrarUsuario (UsuarioRequest usuarioRequest);
    ResponseModel atualizarUsuarioById (UsuarioRequest usuarioRequest, String id);

    //bloco de delecao
    ResponseModel deletarUsuarioById (String id);
    ResponseModel deletarUsuarioByCPF (String CPF);

}
