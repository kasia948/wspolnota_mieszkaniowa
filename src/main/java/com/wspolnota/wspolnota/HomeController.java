package com.wspolnota.wspolnota;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HomeController {
    private WspolnotaRepository wspolnotaRepository;

    public HomeController(WspolnotaRepository wspolnotaRepository) {
        this.wspolnotaRepository = wspolnotaRepository;
    }

    @GetMapping("/")
    public String list(Model model) {
        List<Wspolnota> wspolnoty = wspolnotaRepository.findAll();
        model.addAttribute("wspolnoty", wspolnoty);
        return "index";
    }

    @GetMapping("/dodaj")
    public String home(Model model) {
        model.addAttribute("wspolnota", new Wspolnota());
        return "addWspolnota";
    }

    @PostMapping("/addwspolnota")
    public String addwspolnota(Wspolnota wspolnota) {
        wspolnotaRepository.save(wspolnota);
        return "redirect:/";
    }
}



