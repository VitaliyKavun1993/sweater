package sweater.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sweater.domain.Message;
import sweater.repos.MessageRepo;

import java.util.List;
import java.util.Map;

@Controller
public class GreetingController {

    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "Vetal") String name, Map<String, Object> model){
        model.put("name", name);
        return "greeting";
    }


    @PostMapping
    public String addMessage(@RequestParam (name = "text", required = false, defaultValue = "default text")String text,
                                           @RequestParam (name = "tag", required = false, defaultValue = "dafault tag") String tag,
                                           Map<String, Object> model){
        Message message = new Message(text, tag);
        messageRepo.save(message);
        Iterable<Message> listOfMessages = messageRepo.findAll();
        model.put("messages", listOfMessages);
        return "main";
    }

    @GetMapping("/")
    public String main(Map<String, Object> model){
        model.put("helloText", "hohohoho");
        return "main";
    }

    @GetMapping("/showAll")
    public String showAllMessages(Map<String, Object> model){
        Iterable<Message> listOfMessages = messageRepo.findAll();
        model.put("messages", listOfMessages);
        return "main";
    }

    @PostMapping("/filterByTag")
    public String filterByTag(@RequestParam(name="filter") String filter, Map<String, Object> model){
        Iterable<Message> listOfMessages;
        if(filter != null && !filter.isEmpty()){
            listOfMessages = messageRepo.findByTag(filter);
        }else{
            listOfMessages = messageRepo.findAll();
        }
        model.put("messages", listOfMessages);
        return "main";
    }



}
