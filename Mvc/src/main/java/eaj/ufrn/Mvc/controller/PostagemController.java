package eaj.ufrn.Mvc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import eaj.ufrn.Mvc.model.Postagem;
import eaj.ufrn.Mvc.service.PostagemService;

@Controller
public class PostagemController {
    PostagemService service;

    public PostagemController(PostagemService service) {
        this.service = service;
    }

    @RequestMapping(value = {"/", "/index", "/index.html"}, method = RequestMethod.GET)
    public String getIndex(Model model){
        List<Postagem> postagemList = service.findAll();
        model.addAttribute("postagemList", postagemList);
        return "index.html";
    }

    @GetMapping("/cadastrarPage")
    public String getCadastrarPage(Model model){
        Postagem p = new Postagem();
        model.addAttribute("postagem", p);
        return "cadastrarPage";
    }

    @PostMapping("/doSalvar")
    public String doSalvar(@ModelAttribute Postagem p){
        service.save(p);
        return "redirect:/index";
    }

    @PostMapping("/doEditar")
    public String doEditar(@ModelAttribute Postagem p){
        service.save(p);
        return "redirect:/index";
    }

    @GetMapping("/editarPage/{id}")
    public String getEditarPage(@PathVariable(name = "id") Integer id, Model model){

        Optional<Postagem> p = service.findById(id);
        if (p.isPresent()){
            model.addAttribute("postagem", p.get());
            //service.deleteById(id);
        }else{
            return "redirect:/index";
        }

        return "editarPage";
    }

    @GetMapping("/deletePage/{id}")
    public String getDeletarPage(@PathVariable(name = "id") Integer id, Model model){
        service.deleteById(id);
        //model.addAttribute("postagem", p);
        return "redirect:/index";
    }

}
