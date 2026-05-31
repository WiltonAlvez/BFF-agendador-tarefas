package com.wiltonjunior.bffagendadortarefas.Controller;


import com.wiltonjunior.bffagendadortarefas.Business.Dto.in.TarefasDtoRequest;
import com.wiltonjunior.bffagendadortarefas.Business.Dto.out.TarefasDtoResponse;
import com.wiltonjunior.bffagendadortarefas.Business.TarefasService;
import com.wiltonjunior.bffagendadortarefas.Business.enums.StatusNotificEnun;
import com.wiltonjunior.bffagendadortarefas.Infraistructure.Security.SecurityConfig;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/tarefas")
@RestController
@RequiredArgsConstructor
@Tag(name = "Tarefas", description = "cadastra tarefas de usuarios")
@SecurityRequirement(name = SecurityConfig.SECURITY_SCHEME)
public class TarefasController {

    private final TarefasService tarefasService;

    @PostMapping
    @Operation(summary = "Salvar tarefas", description = "salvar tarefas do usuario")
    @ApiResponse(responseCode = "200", description = "Tarefa salva com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro no servidor")
    public ResponseEntity<TarefasDtoResponse> gravarTarefa(@RequestBody TarefasDtoRequest dto,
                                                           @RequestHeader(value = "Authorization",required = false) String token) {


        return ResponseEntity.ok(tarefasService.gravarTarefas(token, dto));
    }

    @GetMapping("/eventos")
    @Operation(summary = "Buscar Tarefas por periodo", description = "busca tarefas cadastradas por periodo")
    @ApiResponse(responseCode = "200", description = "Tarefa encontrada com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro no servidor")
    public ResponseEntity<List<TarefasDtoResponse>> buscarListaDeTarefasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal,
            @RequestHeader(name = "Authorization", required = false) String token) {


        return ResponseEntity.ok(tarefasService.buscarTarefasPorPeriodo(dataInicial, dataFinal, token));
    }
    @GetMapping
    @Operation(summary = "Buscar Tarefas por email", description = "busca tarefas cadastradas por email")
    @ApiResponse(responseCode = "200", description = "Tarefa encontrada com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro no servidor")

    public ResponseEntity <List<TarefasDtoResponse>> buscaTarefasPorEmail(@RequestHeader("Authorization")  String token) {
        List<TarefasDtoResponse> tarefas = tarefasService.buscaTarefasPorEmail(token);
    return ResponseEntity.ok(tarefas);
    }

    @DeleteMapping
    @Operation(summary = "deletar Tarefas por id", description = "deleta tarefas por id")
    @ApiResponse(responseCode = "200", description = "Tarefa deletada com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro no servidor")
    public ResponseEntity<Void> deletaTarefaPorID (@RequestParam("id")String id,
                                                   @RequestHeader(name = "Authorization", required = false) String token) {
        tarefasService.deletaTarefaPorID(id, token);
        return ResponseEntity.ok().build();

    }
    @PatchMapping
    @Operation(summary = "Alterar status de Tarefas ", description = "altera status de tarefas cadastradas")
    @ApiResponse(responseCode = "200", description = "status da tarefa alterado com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro no servidor")
    public ResponseEntity<TarefasDtoResponse> alteraStatusNotificacao(@RequestParam("status") StatusNotificEnun status,
                                                                      @RequestParam ("id") String id,
                                                                      @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(tarefasService.alteraStatus(status, id,token ));
    }
    @PutMapping
    @Operation(summary = "Alterar dados de Tarefas ", description = "altera dados de tarefas cadastradas")
    @ApiResponse(responseCode = "200", description = "tarefa alterada com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro no servidor")
    public ResponseEntity<TarefasDtoResponse> upadateTarefas(@RequestBody TarefasDtoRequest dto, @RequestParam("id") String id,
                                                             @RequestHeader(name = "Authorization", required = false) String token){
    return ResponseEntity.ok(tarefasService.updateDeTarefas(dto, id, token));

    }



}
