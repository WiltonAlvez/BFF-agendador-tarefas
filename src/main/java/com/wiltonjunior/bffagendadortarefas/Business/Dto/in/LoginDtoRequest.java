package com.wiltonjunior.bffagendadortarefas.Business.Dto.in;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginDtoRequest {
    private String email;
    private String senha;

}
