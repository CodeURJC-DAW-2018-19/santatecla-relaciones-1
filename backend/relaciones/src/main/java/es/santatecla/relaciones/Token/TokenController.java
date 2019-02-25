package es.santatecla.relaciones.Token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TokenController {

    @Autowired
    private TokenRepository tRepository;

    /*
    **Method to add the specific Token
     */
    @RequestMapping("/addToken")
    public String createToken(Model model, @RequestParam String title, @RequestParam String subtitle, /*@RequestParam List<String> elements,*/ @RequestParam String firstFieldForWhat, @RequestParam String secondFieldWhat, @RequestParam String thirdFieldHow){
        Token token = new Token(title,subtitle,/*elements,*/firstFieldForWhat,secondFieldWhat,thirdFieldHow /*, image*/);
        tRepository.save(token);
        return "/alumn-unit";
    }

    /*

    @RequestMapping("/alumn-unit")
    public String tokens(Model model){
        List<Token> tokens = tRepository.findAll();
        model.addAttribute("Token", tokens);
        return "/alumn-unit";
    }

    */

    /*
     **Method that replace the oldest Token for the modify one
     */
    public String modifyToken(Model model, @PathVariable Long id, @PathVariable Token token){
        Token t = new Token(token);
        tRepository.deleteById(id);
        tRepository.save(t);
        return "/alumn-unit";
    }

    /*
     **Method that delete the specific Token
     */
    @RequestMapping("/deleteToken/{id}")
    public String deleteToken(Model model, @PathVariable long id){
        Token token = tRepository.findById(id);
        tRepository.delete(token);
        return "/alumn-unit";
    }

}