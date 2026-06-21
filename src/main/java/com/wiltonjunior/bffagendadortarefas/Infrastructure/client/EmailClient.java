package com.wiltonjunior.bffagendadortarefas.Infrastructure.client;


import com.wiltonjunior.bffagendadortarefas.Business.Dto.out.TarefasDtoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notificacao", url = "${notificacao.url}")
public interface EmailClient {

@PostMapping
    void enviarEmail(@RequestBody TarefasDtoResponse dto);


    }
