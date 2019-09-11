package sweater.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sweater.domain.User;
import sweater.domain.Word;
import sweater.repos.WordRepo;

import java.util.Map;

@Controller
public class GreetingController {

    @Autowired
    private WordRepo wordRepo;


    @GetMapping("/")
    public String homePage(){
        return "home";
    }


    @GetMapping("/main")
    public String mainPage(Map<String, Object> model){
        Iterable<Word> listOfWords = wordRepo.findAll();
        model.put("words", listOfWords);
        return "main";
    }

    @PostMapping("/main")
    public String addWord(
            @AuthenticationPrincipal User user,
            @RequestParam (name = "word")String word,
            @RequestParam (name = "translation") String translation,
            Map<String, Object> model){
        Word wordToTranslate = new Word(word, translation, user);
        wordRepo.save(wordToTranslate);
        Iterable<Word> listOfWords = wordRepo.findAll();
        model.put("words", listOfWords);
        return "main";
    }

    @PostMapping("/")
    public String showAllMessages(Map<String, Object> model){
        Iterable<Word> listOfWords = wordRepo.findAll();
        model.put("words", listOfWords);
        return "main";
    }

    @PostMapping("/filterByWord")
    public String filterByWord(@RequestParam(name="filter") String filter, Map<String, Object> model){
        Iterable<Word> listOfWords;
        if(filter != null && !filter.isEmpty()){
            listOfWords = wordRepo.findByWord(filter);
        }else{
            listOfWords = wordRepo.findAll();
        }
        model.put("words", listOfWords);
        return "main";
    }


    @PostMapping("/filterByTranslation")
    public String filterByTranslation(@RequestParam(name="filter") String filter, Map<String, Object> model){
        Iterable<Word> listOfWords;
        if(filter != null && !filter.isEmpty()){
            listOfWords = wordRepo.findByTranslation(filter);
        }else{
            listOfWords = wordRepo.findAll();
        }
        model.put("words", listOfWords);
        return "main";
    }



}
