package ufrn.br.aulamvc.templates;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import ufrn.br.aulamvc.model.Postagem;

@Repository
public class PostRepository {
    List<Postagem> posts = new ArrayList<>();

    public void doInit(){
        Postagem p1 = new Postagem(0,"Boa tarde", "taniro");
        Postagem p2 = new Postagem(1,"Bom dia", "alunos");
        Postagem p3 = new Postagem(2,"Boa prova", "taniro");

        posts.add(p1);
        posts.add(p2);
        posts.add(p3);
    }

    public List<Postagem> listAll(){
        return posts;
    }

    public void save(Postagem p ){
        posts.add(p);
    }
}
