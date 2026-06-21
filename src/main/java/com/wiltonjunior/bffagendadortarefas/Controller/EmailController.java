package com.wiltonjunior.bffagendadortarefas.Controller;


import com.wiltonjunior.bffagendadortarefas.Business.Dto.out.TarefasDtoResponse;
import com.wiltonjunior.bffagendadortarefas.Service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/email")
public class EmailController {

    private final EmailService emailService;

    @PostMapping
    public ResponseEntity<Void> enviarEmail(@RequestBody TarefasDtoResponse dto) {
        emailService.enviaEmail(dto);
        return ResponseEntity.ok().build();
    }
}
