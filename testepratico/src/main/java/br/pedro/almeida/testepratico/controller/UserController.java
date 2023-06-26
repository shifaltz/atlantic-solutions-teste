package br.pedro.almeida.testepratico.controller;

import br.pedro.almeida.testepratico.model.Responsible;
import br.pedro.almeida.testepratico.model.User;
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
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    //Metodo para abrir a pagina do formulário de cadastro do usuario
    @GetMapping("register")
    public String loadFormPage(Long id, Model model, HttpSession session){

        Responsible responsible = (Responsible) session.getAttribute("responsible");
        if(responsible == null){
            return "redirect:/authentication";
        }

        if(id != null){
            User user = userRepository.getReferenceById(id);
            model.addAttribute("user", user);
            model.addAttribute("flag", true);
            return "users/register";
        }

        model.addAttribute("flag", false);
        return "users/register";
    }


    //Metodo para carregar a pagina do perfil do usuario
    @GetMapping("profile")
    public String loadProfilePage(Model model, HttpSession session){

        User user = (User) session.getAttribute("user");
        if(user == null){
            return "redirect:/authentication";
        }

        model.addAttribute("userProfile", user);
        return "users/profile";
    }


    //Metodo para cadastrar um usuario
    @PostMapping("register")
    public String registerUser(User data, HttpSession session) throws NoSuchAlgorithmException {

        //Verificando se a chamada possui um ID, caso tenha realiza uma ATUALIZACAO no cadastro
        if(data.getIdUser() != null){
            User user = userRepository.findById(data.getIdUser()).get();
            data.setIdResponsible(user.getIdResponsible());
            data.setPassword(user.getPassword());

            //ATUALIZANDO usuario
            userRepository.save(data);
            return "redirect:/users/list";
        }

        //Gerar uma senha HASH (mais segurança)
        data.setPassword(PasswordHash.hash(data.getPassword()));

        Responsible responsible = (Responsible) session.getAttribute("responsible");
        data.setIdResponsible(responsible);

        //GRAVANDO usuario
        userRepository.save(data);

        return "redirect:/users/list";
    }

    //Metodo para desativar um usuario (mudar status)
    @GetMapping("deactivate")
    public String deactivateUser(Long id){

        User user = userRepository.findById(id).get();
        user.setStatus(!user.getStatus());

        userRepository.save(user);

        return "redirect:/users/list";
    }

    //Metodo para abrir a pagina de perfil do usuario
    @GetMapping("list")
    public String loadListPage(Model model, HttpSession session){

        Responsible responsible = (Responsible) session.getAttribute("responsible");
        if(responsible == null){
            return "redirect:/authentication";
        }

        model.addAttribute("listUsers", userRepository.findAllByResponsible(responsible.getIdResponsible()));
        return "users/list";
    }


}
