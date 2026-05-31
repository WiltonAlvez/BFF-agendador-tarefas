package com.wiltonjunior.bffagendadortarefas.Business.Dto.out;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wiltonjunior.bffagendadortarefas.Business.enums.StatusNotificEnun;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class TarefasDtoResponse {

    private String id;
    private String nomeTarefa;
    private String descricao;
    @JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "dd,MM-yyyy HH:mm:ss")
    private LocalDateTime dataCriacao;
    @JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "dd,MM-yyyy HH:mm:ss")
    private LocalDateTime dataEvento;
    private String emailUsuario;
    @JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "dd,MM-yyyy HH:mm:ss")
    private LocalDateTime dataAlteracao;
    private StatusNotificEnun statusNotificEnun;



}
