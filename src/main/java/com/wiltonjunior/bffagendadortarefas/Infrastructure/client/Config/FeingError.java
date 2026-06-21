package com.wiltonjunior.bffagendadortarefas.Infrastructure.client.Config;

import com.wiltonjunior.bffagendadortarefas.Infrastructure.exepcion.BusinessException;
import com.wiltonjunior.bffagendadortarefas.Infrastructure.exepcion.ConflictException;
import com.wiltonjunior.bffagendadortarefas.Infrastructure.exepcion.ResourceNotFoundException;
import com.wiltonjunior.bffagendadortarefas.Infrastructure.exepcion.UnauthorizedException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.stereotype.Component;

@Component
public class FeingError implements ErrorDecoder {


    @Override
    public Exception decode(String s, Response response) {

        return switch (response.status()) {
            case 409 -> new ConflictException("Erro atributo já existente");
            case 403 -> new ResourceNotFoundException("Erro atributo não encontrado");
            case 401 -> new UnauthorizedException("Erro usuário não autorizado");
            default -> new BusinessException("Erro de servidor");
        };

    }
}
