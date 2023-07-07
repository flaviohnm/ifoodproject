package br.com.Ifood.service.impl;

import br.com.Ifood.exception.UserNotFoundException;
import br.com.Ifood.model.ResponseModel;
import br.com.Ifood.model.User;
import br.com.Ifood.model.UsuarioRequest;
import br.com.Ifood.repository.UserRepository;
import br.com.Ifood.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    private final int SUCCESS = 200;

    //bloco de busca
    @Override
    public User findById(String id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new UserNotFoundException());
    }

    @Override
    public User findByCPF(String CPF) {
        Optional<User> user = userRepository.findByCPF(CPF);
        return user.orElseThrow(() -> new UserNotFoundException());
    }

    //bloco de listagem
    @Override
    public List<User> listarUsuarios() {
        List<User> listarUsuarios = userRepository.findAll();
        return listarUsuarios;
    }
    @Override
    public List<User> listarUsuarioByEmail(String email) {
        List<User> usuarios = listarUsuarios();
        return usuarios.stream()
                .filter( usuario -> usuario.getEmail()
                        .equals(email))
                .collect(Collectors.toList());
    }

    //bloco de cadastro e atualizacao
    @Override
    public ResponseModel cadastrarUsuario(UsuarioRequest usuarioRequest) {
        User usuario = preencherUsuario(usuarioRequest);
        userRepository.save(usuario);
        var msg = "Usuario criado com sucesso!!";
        return new ResponseModel(SUCCESS, msg);
    }

    @Override
    public ResponseModel atualizarUsuarioById(UsuarioRequest usuarioRequest, String id) {
        User user = findById(id);
        userRepository.save(compararUsuarios(usuarioRequest,user));
        var msg = "Usuario atualizado com sucesso!!";
        return new ResponseModel(SUCCESS, msg);
    }

    // bloco de deletacao
    @Override
    public ResponseModel deletarUsuarioByCPF(String CPF) {
        User usuario = findByCPF(CPF);
        deletarUsuarioById(usuario.getId());
        var msg = "Usuário excluído com sucesso";
        return new ResponseModel(SUCCESS,msg);
    }

    @Override
    public ResponseModel deletarUsuarioById(String id) {
        findById(id);
        userRepository.deleteById(id);
        var msg = "Usuário excluído com sucesso";
        return new ResponseModel(SUCCESS,msg);
    }

    // bloco de validacao
    private User preencherUsuario(UsuarioRequest usuarioRequest) {
        UUID uuid = UUID.randomUUID();
        User usuarioParaCriar = User.builder()
                .id(uuid.toString())
                .CPF(usuarioRequest.getCPF())
                .userName(usuarioRequest.getUserName())
                .displayName(usuarioRequest.getDisplayName())
                .fullName(usuarioRequest.getFullName())
                .email(usuarioRequest.getEmail())
                .phoneNumber(usuarioRequest.getPhoneNumber())
                .build();
        return usuarioParaCriar;
    }

    private User compararUsuarios(UsuarioRequest usuarioRequest, User usuario){

        if(usuarioRequest.getUserName() != null){
            usuario.setUserName(usuarioRequest.getUserName());
        }
        if (usuarioRequest.getEmail() != null){
            usuario.setEmail(usuarioRequest.getEmail());
        }
        if (usuarioRequest.getFullName() != null){
            usuario.setFullName(usuarioRequest.getFullName());
        }
        if (usuarioRequest.getDisplayName() != null){
            usuario.setDisplayName(usuarioRequest.getDisplayName());
        }
        if (usuarioRequest.getPhoneNumber() != null){
            usuario.setPhoneNumber(usuarioRequest.getPhoneNumber());
        }
        if (usuarioRequest.getCPF() != null){
            usuario.setCPF(usuarioRequest.getCPF());
        }

        return usuario;
    }
}
