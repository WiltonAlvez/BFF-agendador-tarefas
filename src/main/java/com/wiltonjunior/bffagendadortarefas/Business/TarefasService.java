package com.wiltonjunior.bffagendadortarefas.Business;


import com.wiltonjunior.bffagendadortarefas.Business.Dto.in.TarefasDtoRequest;
import com.wiltonjunior.bffagendadortarefas.Business.Dto.out.TarefasDtoResponse;
import com.wiltonjunior.bffagendadortarefas.Business.enums.StatusNotificEnun;
import com.wiltonjunior.bffagendadortarefas.Infraistructure.client.TarefasClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor

public class TarefasService {
    private final TarefasClient tarefasClient;

    public TarefasDtoResponse gravarTarefas(String token, TarefasDtoRequest dto) {

        return tarefasClient.gravarTarefa(dto, token);
    }

    public List<TarefasDtoResponse> buscarTarefasPorPeriodo(LocalDateTime dataInicial,
                                                            LocalDateTime dataFinal,
                                                            String token) {
    return tarefasClient.buscarListaDeTarefasPorPeriodo(dataInicial, dataFinal, token);
    }

    public List<TarefasDtoResponse> buscaTarefasPorEmail(String token) {

        return tarefasClient.buscaTarefasPorEmail(token);
    }

    public void deletaTarefaPorID(String id, String token) {

        tarefasClient.deletaTarefaPorID(id, token);
    }

    public TarefasDtoResponse alteraStatus(StatusNotificEnun status, String id, String token) {
        return tarefasClient.alteraStatusNotificacao(status, id, token);
    }

    public TarefasDtoResponse updateDeTarefas(TarefasDtoRequest dto, String id, String token) {

        return tarefasClient.upadateTarefas(dto, id, token);
    }

}
