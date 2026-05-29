package com.wiltonjunior.bffagendadortarefas.Business;

import com.wiltonjunior.bffagendadortarefas.Business.Dto.EnderecoDTO;
import com.wiltonjunior.bffagendadortarefas.Business.Dto.TelefoneDTO;
import com.wiltonjunior.bffagendadortarefas.Business.Dto.UsuarioDTO;
import com.wiltonjunior.bffagendadortarefas.Infraistructure.client.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioClient client;


    public UsuarioDTO salvaUsuario(UsuarioDTO usuarioDTO) {

        return client.salvaUsuario(usuarioDTO);
    }

    public String loginUsuario(UsuarioDTO usuarioDTO) {
        return client.login(usuarioDTO);
    }

    public UsuarioDTO buscarUsuarioEmail(String email, String token) {

       return client.buscaUsuarioEmail(email, token);
    }


    public void deletaUsuarioPorEmail(String email, String token) {

        client.deletaUsuarioPorEmail(email, token);
    }

    public UsuarioDTO atualizaDadosUsuario(String token, UsuarioDTO dto) {

        return client.atualizaDadosUsuario(dto, token);

    }

    public EnderecoDTO atualizaDadosUsuario(Long idEndereco, EnderecoDTO enderecoDTO, String token) {

        return client.atualizaEndereco(enderecoDTO, idEndereco, token);
    }

    public TelefoneDTO atualizaTelefone(Long idTelefone, TelefoneDTO dto, String token) {

        return client.atualizaTelefone(dto, idTelefone, token);
    }

    public EnderecoDTO cadastroEndereco(String token, EnderecoDTO dto) {


        return client.CadastraEndereco(dto, token);
    }



    public TelefoneDTO cadastroTelefone(String token, TelefoneDTO dto) {

      return client.CadastraTelefone(dto, token);
    }
}
