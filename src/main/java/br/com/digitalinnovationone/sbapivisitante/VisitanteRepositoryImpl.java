package br.com.digitalinnovationone.sbapivisitante;

import br.com.digitalinnovationone.Visitante;
import br.com.digitalinnovationone.VisitanteRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitanteRepositoryImpl implements VisitanteRepositoryPort {

    private VisitanteRepository repository;

    @Autowired
    public void setRepository(VisitanteRepository repository) {
        this.repository = repository;
    }

    @Override
    public void salvar(Visitante visitante) {
        var model = new VisitanteModel(visitante.getCpf(), visitante.getNome());
        repository.save(model);
    }

    @Override
    public Visitante procurarPorCpf(String cpf) {
        var model = repository.findById(cpf);
        return new Visitante(model.get().getCpf(), model.get().getNome());
    }

}
