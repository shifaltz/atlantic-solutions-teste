package br.pedro.almeida.testepratico.controller;

import br.pedro.almeida.testepratico.model.Responsible;
import br.pedro.almeida.testepratico.model.User;
import br.pedro.almeida.testepratico.repository.ResponsibleRepository;
import br.pedro.almeida.testepratico.repository.UserRepository;
import br.pedro.almeida.testepratico.utils.PasswordHash;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.NoSuchAlgorithmException;

@Controller
@RequestMapping("/authentication")
public class AuthenticationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ResponsibleRepository responsibleRepository;

    @GetMapping
    public String loadLoginPage(){
        return "login/index";
    }

    //LOGIN DO USUARIO
    @PostMapping
    public String login(Model model, String email, String password, HttpSession session) throws NoSuchAlgorithmException {

        String passwordHash = PasswordHash.hash(password);

        //VERIFICANDO SE EXISTE O EMAIL E SENHA NA TABELA DE USUARIO
        User user =  userRepository.findUserLogin(email, passwordHash);
        if(user != null){
            if(user.getStatus() == true){
                session.setAttribute("user", user);
                return "redirect:/users/profile";
            }
        }

        //VERIFICANDO SE EXISTE O EMAIL E SENHA NA TABELA DE RESPONSAVEL
        Responsible responsible = responsibleRepository.findResponsibleLogin(email, passwordHash);
        if(responsible != null){
            session.setAttribute("responsible", responsible);
            return "redirect:/users/list";
        }

        return "redirect:/authentication";

    }

    //LOGOUT DO SISTEMA
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        session.removeAttribute("responsible");
        return "redirect:/authentication";
    }

}
