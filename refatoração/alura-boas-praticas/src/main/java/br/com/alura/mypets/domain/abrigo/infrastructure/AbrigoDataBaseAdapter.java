package br.com.alura.mypets.domain.abrigo.infrastructure;

import java.util.List;

import br.com.alura.mypets.domain.abrigo.core.model.Abrigo;
import br.com.alura.mypets.domain.abrigo.core.model.exception.AbrigoJaCadastradoException;
import br.com.alura.mypets.domain.abrigo.core.ports.outgoing.AbrigoDataBase;
import br.com.alura.mypets.domain.pet.core.model.Pet;

public class AbrigoDataBaseAdapter implements AbrigoDataBase{

    private AbrigoRepository abrigoRepository;
   
    public AbrigoDataBaseAdapter(AbrigoRepository abrigoRepository) {
        this.abrigoRepository = abrigoRepository;
    }

    @Override
    public void salvar(Abrigo abrigo) {
        if(abrigoRepository.existsByNomeAndTelefoneAndEmail(abrigo.getNome(), abrigo.getTelefone(), abrigo.getEmail())){
            throw new AbrigoJaCadastradoException();
        }
        abrigoRepository.save(abrigo);
    }

    @Override
    public List<Abrigo> getAllAbrigos() {
        return abrigoRepository.findAll();
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
