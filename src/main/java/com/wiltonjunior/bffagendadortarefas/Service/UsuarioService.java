package com.wiltonjunior.bffagendadortarefas.Service;

import com.wiltonjunior.bffagendadortarefas.Business.Dto.in.EnderecoDtoRequest;
import com.wiltonjunior.bffagendadortarefas.Business.Dto.in.LoginDtoRequest;
import com.wiltonjunior.bffagendadortarefas.Business.Dto.in.TelefoneDtoRequest;
import com.wiltonjunior.bffagendadortarefas.Business.Dto.in.UsuarioDtoRequest;
import com.wiltonjunior.bffagendadortarefas.Business.Dto.out.EnderecoDtoResponse;
import com.wiltonjunior.bffagendadortarefas.Business.Dto.out.TelefoneDtoResponse;
import com.wiltonjunior.bffagendadortarefas.Business.Dto.out.UsuarioDtoResponse;
import com.wiltonjunior.bffagendadortarefas.Infrastructure.client.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioClient client;


    public UsuarioDtoResponse salvaUsuario(UsuarioDtoRequest usuarioDTO) {

        return client.salvaUsuario(usuarioDTO);
    }

    public String loginUsuario(LoginDtoRequest dto) {
        return client.login(dto);
    }


    public UsuarioDtoResponse buscarUsuarioEmail(String email, String token) {

       return client.buscaUsuarioEmail(email, token);
    }


    public void deletaUsuarioPorEmail(String email, String token) {

        client.deletaUsuarioPorEmail(email, token);
    }

    public UsuarioDtoResponse atualizaDadosUsuario(String token, UsuarioDtoRequest dto) {

        return client.atualizaDadosUsuario(dto, token);

    }

    public EnderecoDtoResponse atualizaDadosUsuario(Long idEndereco, EnderecoDtoRequest enderecoDTO, String token) {

        return client.atualizaEndereco(enderecoDTO, idEndereco, token);
    }

    public TelefoneDtoResponse atualizaTelefone(Long idTelefone, TelefoneDtoRequest dto, String token) {

        return client.atualizaTelefone(dto, idTelefone, token);
    }

    public EnderecoDtoResponse cadastroEndereco(String token, EnderecoDtoRequest dto) {


        return client.CadastraEndereco(dto, token);
    }



    public TelefoneDtoResponse cadastroTelefone(String token, TelefoneDtoRequest dto) {

      return client.CadastraTelefone(dto, token);
    }
}
