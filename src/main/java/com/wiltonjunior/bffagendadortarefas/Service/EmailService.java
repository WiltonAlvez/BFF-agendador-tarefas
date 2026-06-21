package com.wiltonjunior.bffagendadortarefas.Service;

import com.wiltonjunior.bffagendadortarefas.Business.Dto.out.TarefasDtoResponse;
import com.wiltonjunior.bffagendadortarefas.Infrastructure.client.EmailClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailClient emailClient;


    public  void enviaEmail(TarefasDtoResponse usuarioDTO) {

        emailClient.enviarEmail(usuarioDTO);
    }

}
