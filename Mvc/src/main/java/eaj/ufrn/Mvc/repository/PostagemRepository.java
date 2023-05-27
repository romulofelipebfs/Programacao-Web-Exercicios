package eaj.ufrn.Mvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import eaj.ufrn.Mvc.model.Postagem;

public interface PostagemRepository extends JpaRepository<Postagem, Integer>{
    List<Postagem> findPostagemByAutor(String autor);

    /* 
    @Modifying
    @Query("update postagem set autor = #{#postagem.autor} ,destinatario = #{#postagem.destinatario}, mensagem = #{#postagem.mensagem}, titulo = #{#postagem.titulo} where id = #{#postagem.id}")
    void updatePostagem(Postagem postagem);
    */
}
