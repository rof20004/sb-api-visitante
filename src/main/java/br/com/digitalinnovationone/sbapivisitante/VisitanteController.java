package br.com.digitalinnovationone.sbapivisitante;

import br.com.digitalinnovationone.Visitante;
import br.com.digitalinnovationone.VisitanteDto;
import br.com.digitalinnovationone.VisitanteServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/visitantes")
public class VisitanteController {

    private VisitanteServicePort service;

    @Autowired
    public void setService(VisitanteServicePort service) {
        this.service = service;
    }

    @PostMapping
    public void cadastrar(@RequestBody VisitanteDto dto) {
        service.cadastrar(dto);
    }

    @GetMapping("/{cpf}")
    public Visitante procurarPorCpf(@PathVariable("cpf") String cpf) {
        return service.procurarPorCpf(cpf);
    }

}
