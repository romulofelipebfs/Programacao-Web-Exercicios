package ufrn.br.aulamvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ufrn.br.aulamvc.model.Postagem;
import ufrn.br.aulamvc.templates.PostRepository;

@Controller
public class PostController {
    PostRepository repository;

    public PostController(PostRepository repository){
        this.repository = repository;
        this.repository.doInit();
    }

    @RequestMapping(value = {"/", "/posts"}, method = RequestMethod.GET)
    public String doGet(Model model){
        model.addAttribute("posts", repository.listAll());
        return "index";
    }

    @RequestMapping(value = "/formCadastro", method = RequestMethod.GET)
    public String doFormPage(Model model){

        Postagem p = new Postagem("NovaPostagem", "NovoAutor");
        model.addAttribute("postagem", p);

        return "formCadastro";
    }

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public String doSalvarPostagem(@ModelAttribute Postagem p){
        repository.save(p);
        return "redirect:/";
    }
    
}
