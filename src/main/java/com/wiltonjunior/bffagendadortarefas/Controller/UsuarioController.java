package com.wiltonjunior.bffagendadortarefas.Controller;

import com.wiltonjunior.bffagendadortarefas.Business.Dto.in.EnderecoDtoRequest;
import com.wiltonjunior.bffagendadortarefas.Business.Dto.in.LoginDtoRequest;
import com.wiltonjunior.bffagendadortarefas.Business.Dto.in.TelefoneDtoRequest;
import com.wiltonjunior.bffagendadortarefas.Business.Dto.in.UsuarioDtoRequest;
import com.wiltonjunior.bffagendadortarefas.Business.Dto.out.EnderecoDtoResponse;
import com.wiltonjunior.bffagendadortarefas.Business.Dto.out.TelefoneDtoResponse;
import com.wiltonjunior.bffagendadortarefas.Business.Dto.out.UsuarioDtoResponse;
import com.wiltonjunior.bffagendadortarefas.Business.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
@Tag(name = "Usuario", description = "cadastro e login de usuarios")
public class UsuarioController {


    private final UsuarioService usuarioService;

    @PostMapping
    @Operation(summary = "Salvar usuarios", description = "cria um novo usuario")
    @ApiResponse(responseCode = "200", description = "Usuario salvo com sucesso")
    @ApiResponse(responseCode = "400", description = "Usuario já cadastrado")
    @ApiResponse(responseCode = "500", description = "Erro no servidor")
    public ResponseEntity<UsuarioDtoResponse> salvaUsuario(@RequestBody UsuarioDtoRequest usuarioDTO) {
        return ResponseEntity.ok(usuarioService.salvaUsuario(usuarioDTO));

    }

    @PostMapping("/login")
    @Operation(summary = "Login dos usuarios", description = "login do usuario")
    @ApiResponse(responseCode = "200", description = "Usuario logado com sucesso")
    @ApiResponse(responseCode = "401", description = "Credenciais invalidas")
    @ApiResponse(responseCode = "500", description = "Erro no servidor")
    public String login(@RequestBody LoginDtoRequest usuarioDTO) {
        return usuarioService.loginUsuario(usuarioDTO);

    }

    @GetMapping
    @Operation(summary = "buscar dados dos usuarios por email", description = "buscar dados do usuario")
    @ApiResponse(responseCode = "200", description = "Usuario salvo com sucesso")
    @ApiResponse(responseCode = "400", description = "Usuario já cadastrado")
    @ApiResponse(responseCode = "500", description = "Erro no servidor")
    public ResponseEntity<UsuarioDtoResponse> buscaUsuarioEmail(@RequestParam("email") String email,
                                                                @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(usuarioService.buscarUsuarioEmail(email, token));

    }

    @DeleteMapping("/{email}")
    @Operation(summary = "Deletar usuarios por id ", description = "deleta usuario")
    @ApiResponse(responseCode = "200", description = "Usuario deletado com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuario não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro no servidor")
    public ResponseEntity<Void> deletaUsuarioPorEmail(@PathVariable String email,
                                                      @RequestHeader(name = "Authorization", required = false) String token) {
        usuarioService.deletaUsuarioPorEmail(email, token);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/usuario/atualizar")
    @Operation(summary = "atualizar dados usuarios", description = "atualiza dados do usuario")
    @ApiResponse(responseCode = "200", description = "Usuario atualizado com sucesso ")
    @ApiResponse(responseCode = "404", description = "Usuario não cadastrado")
    @ApiResponse(responseCode = "500", description = "Erro no servidor")
    public ResponseEntity<UsuarioDtoResponse> atualizaDadosUsuario(@RequestBody UsuarioDtoRequest DTO,
                                                                   @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(usuarioService.atualizaDadosUsuario(token, DTO));
    }

    @PutMapping("/endereco")
    @Operation(summary = "atualizar endereços de  usuarios", description = "atualiza endereços usuario")
    @ApiResponse(responseCode = "200", description = "Endereço atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "U não cadastrado")
    @ApiResponse(responseCode = "500", description = "Erro no servidor")
    public ResponseEntity<EnderecoDtoResponse> atualizaEndereco(@RequestBody EnderecoDtoRequest dto,
                                                                @RequestParam("id") Long id,
                                                                @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(usuarioService.atualizaDadosUsuario(id, dto, token));
    }

    @PutMapping("/telefone")
    @Operation(summary = "atualizar telefone dos usuarios",
            description = "atualiza telefones dos usuario")
    @ApiResponse(responseCode = "200", description = "telefone atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuario não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro no servidor")
    public ResponseEntity<TelefoneDtoResponse> atualizaTelefone(@RequestBody TelefoneDtoRequest dto,
                                                                @RequestParam("id") Long id,
                                                                @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(usuarioService.atualizaTelefone(id, dto, token));
    }

    @PostMapping("/endereco")
    @Operation(summary = "Salvar Endereços de usuarios", description = "salva endereço de usuario")
    @ApiResponse(responseCode = "200", description = "Endereço salvo com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuario Não cadastrado")
    @ApiResponse(responseCode = "500", description = "Erro no servidor")
    public ResponseEntity<EnderecoDtoResponse> CadastraEndereco(@RequestBody EnderecoDtoRequest dto,
                                                                @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(usuarioService.cadastroEndereco(token, dto));
    }

    @PostMapping("/telefone")
    @Operation(summary = "Salvar Telefones dos usuarios", description = "salva telefone do usuario")
    @ApiResponse(responseCode = "200", description = "Telefone salvo com sucesso")
    @ApiResponse(responseCode = "400", description = "Usuario não cadastrado")
    @ApiResponse(responseCode = "500", description = "Erro no servidor")
    public ResponseEntity<TelefoneDtoResponse> CadastraTelefone(@RequestBody TelefoneDtoRequest dto,
                                                                @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(usuarioService.cadastroTelefone(token, dto));

    }
}

