package com.wiltonjunior.bffagendadortarefas.Business.Dto.out;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TelefoneDtoResponse {

    private Long id;
    private String ddd;
    private String numero;
}
