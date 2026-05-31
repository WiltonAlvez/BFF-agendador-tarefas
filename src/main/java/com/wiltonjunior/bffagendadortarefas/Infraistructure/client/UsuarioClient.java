package com.wiltonjunior.bffagendadortarefas.Infraistructure.client;


import com.wiltonjunior.bffagendadortarefas.Business.Dto.in.EnderecoDtoRequest;
import com.wiltonjunior.bffagendadortarefas.Business.Dto.in.LoginDtoRequest;
import com.wiltonjunior.bffagendadortarefas.Business.Dto.in.TelefoneDtoRequest;
import com.wiltonjunior.bffagendadortarefas.Business.Dto.in.UsuarioDtoRequest;
import com.wiltonjunior.bffagendadortarefas.Business.Dto.out.EnderecoDtoResponse;
import com.wiltonjunior.bffagendadortarefas.Business.Dto.out.TelefoneDtoResponse;
import com.wiltonjunior.bffagendadortarefas.Business.Dto.out.UsuarioDtoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UsuarioClient {

    @GetMapping("/usuario")
    UsuarioDtoResponse buscaUsuarioEmail(@RequestParam("email") String email,
                                         @RequestHeader("Authorization") String token);


    @PostMapping
    UsuarioDtoResponse salvaUsuario(@RequestBody UsuarioDtoRequest usuarioDTO);

    @PostMapping("/login")
    String login(@RequestBody LoginDtoRequest usuarioDTO);

    @DeleteMapping("/{email}")
    void deletaUsuarioPorEmail(@PathVariable String email,
                               @RequestHeader(value = "Authorization", required = false) String token);

    @PostMapping("/usuario/atualizar")
    UsuarioDtoResponse atualizaDadosUsuario(@RequestBody UsuarioDtoRequest DTO,
                                            @RequestHeader(value = "Authorization", required = false) String token);

    @PutMapping("/endereco")
    EnderecoDtoResponse atualizaEndereco(@RequestBody EnderecoDtoRequest dto,
                                         @RequestParam("id") Long id,
                                         @RequestHeader(value = "Authorization", required = false) String token);

    @PutMapping("/telefone")
    TelefoneDtoResponse atualizaTelefone(@RequestBody TelefoneDtoRequest dto,
                                         @RequestParam("id") Long id,
                                         @RequestHeader(value = "Authorization", required = false) String token);

    @PostMapping("/endereco")
    EnderecoDtoResponse CadastraEndereco(@RequestBody EnderecoDtoRequest dto,
                                         @RequestHeader(value = "Authorization", required = false) String token);

    @PostMapping("/telefone")
    TelefoneDtoResponse CadastraTelefone(@RequestBody TelefoneDtoRequest dto,
                                         @RequestHeader("Authorization") String token);

}
