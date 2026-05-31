package com.wiltonjunior.bffagendadortarefas.Business.Dto.in;

import com.wiltonjunior.bffagendadortarefas.Business.Dto.out.EnderecoDtoResponse;
import com.wiltonjunior.bffagendadortarefas.Business.Dto.out.TelefoneDtoResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioDtoRequest {

    private String nome;
    private String email;
    private String senha;
    private List<EnderecoDtoResponse> enderecos;
    private List<TelefoneDtoResponse> telefones;
}
