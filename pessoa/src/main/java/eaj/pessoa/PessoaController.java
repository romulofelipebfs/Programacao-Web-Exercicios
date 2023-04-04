package eaj.pessoa;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class PessoaController {

    @RequestMapping( method = RequestMethod.GET, value = "/cadastrar")
    public void MostrarPessoa(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.getWriter().println("Teste");

    }

    @RequestMapping( method = RequestMethod.POST, value = "/excluir")
    public void excluirPessoa(HttpServletRequest request, HttpServletResponse response) throws IOException{
        var p = new Pessoa();
        // var nome = request.getParameter("nome");
        //var idade = Integer.parseInt(request.getParameter("idade"));
        var id = Integer.parseInt(request.getParameter("id"));

       // p.setNome(nome);
        //p.setIdade(idade);
        p.setId(id);
        
        PessoaDAO pDAO = new PessoaDAO();

        pDAO.excluirPessoa(p);
        response.setContentType("text/HTML");
        var writer = response.getWriter();
        writer.println("Excluido com sucesso");
    }

    @RequestMapping( method = RequestMethod.POST, value = "/alterar")
    public void alterarPessoa(HttpServletRequest request, HttpServletResponse response) throws IOException{
        var p = new Pessoa();
        var nome = request.getParameter("nome");
        var idade = Integer.parseInt(request.getParameter("idade"));
        var id = Integer.parseInt(request.getParameter("id"));


        p.setNome(nome);
        p.setIdade(idade);
        p.setId(id);

        PessoaDAO pDAO = new PessoaDAO();

        pDAO.excluirPessoa(p);
        response.setContentType("text/HTML");
        var writer = response.getWriter();
        writer.println("Deu certo");

    }

    @RequestMapping( method = RequestMethod.POST, value = "/cadastrar")
    public void cadastraPessoa(HttpServletRequest request, HttpServletResponse response) throws IOException{
        var p = new Pessoa();
        var nome = request.getParameter("nome");
        var idade = Integer.parseInt(request.getParameter("idade"));

        p.setNome(nome);
        p.setIdade(idade);

        PessoaDAO pDAO = new PessoaDAO();

        pDAO.cadastrarPessoa(p);
        response.setContentType("text/HTML");

        var writer = response.getWriter();

        var listarPessoas = pDAO.listarPessoas();

        for(var t1:listarPessoas){
            writer.println("<hr /> <p>" +t1.getNome() + "</p>");
            writer.println("<p>" +t1.getIdade() + "</p>");
            writer.println("<p>" + "<a href=" + "excluir.html" + ">" + "Excluir" + "</a>" + "</p>");
        }

        //writer.println("Verifique se atualizou o banco");

    }

}
