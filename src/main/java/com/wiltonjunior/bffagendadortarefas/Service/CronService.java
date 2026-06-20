package com.wiltonjunior.bffagendadortarefas.Service;

import com.wiltonjunior.bffagendadortarefas.Business.Dto.in.LoginDtoRequest;
import com.wiltonjunior.bffagendadortarefas.Business.Dto.out.TarefasDtoResponse;
import com.wiltonjunior.bffagendadortarefas.Business.enums.StatusNotificEnun;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor

public class CronService {

    private final TarefasService tarefasService;
    private final EmailService emailService;
    private final UsuarioService usuarioService;

    @Value("${usuario.email}")
    private String email;

    @Value("${usuario.senha}")
    private String senha;

@Scheduled(cron = "${cron.horario}")
    public void BuscaTarefasDaProximaHora(){
        String token = login(converterParaRequestDto());

        LocalDateTime horaFutura =LocalDateTime.now().plusHours(1);
        LocalDateTime horaFuturMaisCinco = LocalDateTime.now().plusHours(1).plusMinutes(5);

        List <TarefasDtoResponse> listaDeTarefas = tarefasService.buscarTarefasPorPeriodo(horaFutura, horaFuturMaisCinco,token);

        listaDeTarefas.forEach(tarefa -> {emailService.enviaEmail(tarefa);
        tarefasService.alteraStatus(StatusNotificEnun.NOTIFICADO, tarefa.getId(), token);});
    }


    public String login(LoginDtoRequest dto){
      return usuarioService.loginUsuario(dto);

    }

    public LoginDtoRequest converterParaRequestDto() {
        return LoginDtoRequest.builder()
                .email(email)
                .senha(senha)
                .build();

    }
}
