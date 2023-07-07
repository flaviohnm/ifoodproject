package br.com.Ifood.resource;

import br.com.Ifood.model.ResponseModel;
import br.com.Ifood.model.User;
import br.com.Ifood.model.UsuarioRequest;
import br.com.Ifood.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ifood/v1")
@RequiredArgsConstructor
public class UserResource {

    private final UserService userService;

    //bloco post
    @PostMapping("/usuarios")
    public ResponseEntity<ResponseModel> cadastrarUsuario(@RequestBody UsuarioRequest usuarioRequest){
        return new ResponseEntity<>(userService.cadastrarUsuario(usuarioRequest), HttpStatus.CREATED);
    }

    //bloco get
    @GetMapping("/usuarios/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") String id){
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/usuarios/byCPF/{cpf}")
    public ResponseEntity<User> findByCPF(@PathVariable("cpf") String cpf){
        return new ResponseEntity<>(userService.findByCPF(cpf), HttpStatus.OK);
    }

    @GetMapping("/usuarios/byEmail/")
    public ResponseEntity<List<User>> listarUsuarioByEmail(@RequestParam(value="email") String email){
        return new ResponseEntity<>(userService.listarUsuarioByEmail(email), HttpStatus.OK);
    }

    @GetMapping("/usuarios")
    public ResponseEntity<List<User>> listarUsuarios(){
        return new ResponseEntity<>(userService.listarUsuarios(), HttpStatus.OK);
    }

    //bloco delete
    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<ResponseModel> detelarUsuarioById(@PathVariable("id") String id){
        return new ResponseEntity<>(userService.deletarUsuarioById(id), HttpStatus.OK);
    }
    @DeleteMapping("/usuarios/byCPF/{cpf}")
    public ResponseEntity<ResponseModel> deletarUsuarioByCPF(@PathVariable("cpf") String cpf){
        return new ResponseEntity<>(userService.deletarUsuarioByCPF(cpf), HttpStatus.OK);
    }

    //bloco atualizacao
    @PatchMapping("/usuarios/{id}")
    public ResponseEntity<ResponseModel> atualizarById(@RequestBody UsuarioRequest usuarioRequest, @PathVariable("id") String id) {
        return new ResponseEntity<>(userService.atualizarUsuarioById(usuarioRequest, id), HttpStatus.OK);
    }
}
