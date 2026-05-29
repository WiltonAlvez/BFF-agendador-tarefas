package com.wiltonjunior.bffagendadortarefas.Infraistructure.client;


import com.wiltonjunior.bffagendadortarefas.Business.Dto.EnderecoDTO;
import com.wiltonjunior.bffagendadortarefas.Business.Dto.TelefoneDTO;
import com.wiltonjunior.bffagendadortarefas.Business.Dto.UsuarioDTO;
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
    UsuarioDTO buscaUsuarioEmail(@RequestParam("email") String email,
                                 @RequestHeader("Authorization") String token);


    @PostMapping
    UsuarioDTO salvaUsuario(@RequestBody UsuarioDTO usuarioDTO);

    @PostMapping("/login")
    String login(@RequestBody UsuarioDTO usuarioDTO);

    @DeleteMapping("/{email}")
    void deletaUsuarioPorEmail(@PathVariable String email,
                               @RequestHeader("Authorization") String token);

    @PostMapping("/usuario/atualizar")
    UsuarioDTO atualizaDadosUsuario(@RequestBody UsuarioDTO DTO,
                                                           @RequestHeader("Authorization") String token);

    @PutMapping("/endereco")
    EnderecoDTO atualizaEndereco(@RequestBody EnderecoDTO dto,
                                                        @RequestParam("id") Long id,
                                                        @RequestHeader("Authorization") String token);

    @PutMapping("/telefone")
    TelefoneDTO atualizaTelefone(@RequestBody TelefoneDTO dto,
                                                        @RequestParam("id") Long id,
                                                        @RequestHeader("Authorization") String token);

    @PostMapping("/endereco")
    EnderecoDTO CadastraEndereco(@RequestBody EnderecoDTO dto,
                                                        @RequestHeader("Authorization") String token);

    @PostMapping("/telefone")
    TelefoneDTO CadastraTelefone(@RequestBody TelefoneDTO dto,
                                                        @RequestHeader("Authorization") String token);

}
