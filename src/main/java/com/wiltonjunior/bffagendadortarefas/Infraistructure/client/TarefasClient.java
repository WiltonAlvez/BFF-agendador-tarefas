package com.wiltonjunior.bffagendadortarefas.Infraistructure.client;


import com.wiltonjunior.bffagendadortarefas.Business.Dto.TarefasDTO;
import com.wiltonjunior.bffagendadortarefas.Business.enums.StatusNotificEnun;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@FeignClient(name = "agendador-tarefas", url = "${agendador-tarefas.url}")
public interface TarefasClient {

    @PostMapping
    TarefasDTO gravarTarefa(@RequestBody TarefasDTO dto,
                            @RequestHeader("Authorization") String token);


    @GetMapping("/eventos")
    List<TarefasDTO> buscarListaDeTarefasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal,
            @RequestHeader("Authorization") String token);


    @GetMapping
    List<TarefasDTO> buscaTarefasPorEmail(@RequestHeader("Authorization") String token);


    @DeleteMapping
    void deletaTarefaPorID(@RequestParam("id") String id,
                           @RequestHeader("Authorization") String token);

    @PatchMapping
    TarefasDTO alteraStatusNotificacao(@RequestParam("status") StatusNotificEnun status,
                                       @RequestParam("id") String id,
                                       @RequestHeader("Authorization") String token);

    @PutMapping
    TarefasDTO upadateTarefas(@RequestBody TarefasDTO dto, @RequestParam("id") String id,
                              @RequestHeader("Authorization") String token);

}
