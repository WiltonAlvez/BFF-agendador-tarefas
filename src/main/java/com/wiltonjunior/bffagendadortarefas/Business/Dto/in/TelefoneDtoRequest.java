package com.wiltonjunior.bffagendadortarefas.Business.Dto.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TelefoneDtoRequest {

    private String ddd;
    private String numero;
}
