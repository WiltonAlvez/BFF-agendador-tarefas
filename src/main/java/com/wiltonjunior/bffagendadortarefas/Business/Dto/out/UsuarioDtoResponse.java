package com.wiltonjunior.bffagendadortarefas.Business.Dto.out;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioDtoResponse {

    private Long id;
    private String nome;
    private String email;
    private String senha;
    private List<EnderecoDtoResponse> enderecos;
    private List<TelefoneDtoResponse> telefones;
}
