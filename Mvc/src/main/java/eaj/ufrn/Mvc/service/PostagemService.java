package eaj.ufrn.Mvc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import eaj.ufrn.Mvc.model.Postagem;
import eaj.ufrn.Mvc.repository.PostagemRepository;


@Service
public class PostagemService {
    private PostagemRepository repository;

    public PostagemService(PostagemRepository repository){
        this.repository = repository;
    }

    public void save(Postagem p){
        repository.save(p);
    }
    
    public void saveAndFlush(Postagem p){
        repository.saveAndFlush(p);
        
    }

    public List<Postagem> findAll(){
        return repository.findAll();
    }

    public Optional<Postagem> findById(Integer id){
        return repository.findById(id);
    }    

    public void deleteById(Integer id){
        repository.deleteById(id);
    } 

}
