package br.com.digitalinnovationone.sbapivisitante;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private Erro montarInstanciaErro(RuntimeException e) {
        return Erro.builder()
                .dataHora(LocalDateTime.now())
                .mensagem(e.getMessage())
                .build();
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Erro tratarRuntimeException(RuntimeException e) {
        return montarInstanciaErro(e);
    }

}

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
class Erro {

    private LocalDateTime dataHora;
    private String mensagem;

}