package br.com.alura.mypets.domain.abrigo.infrastructure;

import java.util.List;

import br.com.alura.mypets.api.model.Pet;
import br.com.alura.mypets.domain.abrigo.core.model.Abrigo;
import br.com.alura.mypets.domain.abrigo.core.model.exception.AbrigoJaCadastradoException;
import br.com.alura.mypets.domain.abrigo.core.ports.outgoing.AbrigoDataBase;

public class AbrigoDataBaseAdapter implements AbrigoDataBase{

    private AbrigoRepository repository;
   
    public AbrigoDataBaseAdapter(AbrigoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void salvar(Abrigo abrigo) {
        if(repository.existsByNomeAndTelefoneAndEmail(abrigo)){
            throw new AbrigoJaCadastradoException();
        }
        repository.save(abrigo);
    }

    @Override
    public List<Abrigo> getAllAbrigos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllAbrigos'");
    }

    @Override
    public List<Pet> getPetsAbrigo(String idOuNome) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPetsAbrigo'");
    }

    @Override
    public void salvar(Pet pet, String idOuNome) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'salvar'");
    }
    
}
