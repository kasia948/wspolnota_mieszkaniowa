package com.wspolnota.wspolnota;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {
    private WspolnotaRepository wspolnotaRepository;
    private MieszkanieRepository mieszkanieRepository;
    private MieszkaniecRepository mieszkaniecRepository;


    public HomeController(WspolnotaRepository wspolnotaRepository, MieszkanieRepository mieszkanieRepository, MieszkaniecRepository mieszkaniecRepository) {
        this.wspolnotaRepository = wspolnotaRepository;
        this.mieszkanieRepository=mieszkanieRepository;
        this.mieszkaniecRepository=mieszkaniecRepository;
    }

    @GetMapping("/")
    public String list(Model model) {
        List<Wspolnota> wspolnoty = wspolnotaRepository.findAll();
        List<Mieszkanie> mieszkania=mieszkanieRepository.findAll();
        List<Mieszkaniec> mieszkancy= mieszkaniecRepository.findAll();
        model.addAttribute("wspolnoty", wspolnoty);
        model.addAttribute("mieszkanie", mieszkania);
        model.addAttribute("mieszkaniec", mieszkancy);
        return "index";
    }

    @GetMapping("/dodajWspolnote")
    public String home(Model model) {
        model.addAttribute("wspolnota", new Wspolnota());
        return "addWspolnota";
    }

    @PostMapping("/addwspolnota")
    public String addwspolnota(Wspolnota wspolnota) {
        wspolnotaRepository.save(wspolnota);
        return "redirect:/";
    }

    @GetMapping("/wspDetails")
    public String list2 (@RequestParam Long id, Model model){

        Optional<Wspolnota> wspolnotaOptional = wspolnotaRepository.findById(id);
        Optional <Mieszkanie> mieszkanieOptional =mieszkanieRepository.findById(id);

        if(wspolnotaOptional.isPresent()) {
            Wspolnota wsp = wspolnotaOptional.get();
            model.addAttribute("wspolnota", wsp);
            List <Mieszkanie> wsp2=wsp.getMieszkania();
            model.addAttribute("mieszkania", wsp2);
        }
        return "wspolnotaDetails";
    }


    @GetMapping("/dodajMieszkanie")
    public String home1(Model model) {
        model.addAttribute("mieszkanie", new Mieszkanie());
        return "addMieszkanie";
    }

    @PostMapping("/addmieszkanie")
    public String addMieskzanie(Mieszkanie mieszkanie) {
        mieszkanieRepository.save(mieszkanie);
        return "mieszkanieDetails";
    }


    @GetMapping("/mieszDetails")
    public String list3 (@RequestParam Long id, Model model){

        Optional<Mieszkanie> mieszkanieOptional = mieszkanieRepository.findById(id);
        Optional <Mieszkaniec> mieszkaniecOptional =mieszkaniecRepository.findById(id);

        if(mieszkanieOptional.isPresent()) {
            Mieszkanie miesz = mieszkanieOptional.get();
            model.addAttribute("mieszkanie", miesz);
            List <Mieszkaniec> wsp2=miesz.getMieszkancy();
            model.addAttribute("mieszkancy", wsp2);
        }
        return "mieszkanieDetails";
    }

    @GetMapping("/dodajMieszkanca")
    public String home2(Model model) {
        model.addAttribute("mieszkaniec", new Mieszkaniec());
        return "addMieszkaniec";
    }

    @PostMapping("/addmieszkaniec")
    public String addMieskzaniec(Mieszkaniec mieszkaniec) {
        mieszkaniecRepository.save(mieszkaniec);
        return "osobaDetails";
    }

    @GetMapping("/mieszkaniecDetails")
    public String list4 (@RequestParam Long id, Model model){
        Optional <Mieszkaniec> mieszkaniecOptional =mieszkaniecRepository.findById(id);
        if(mieszkaniecOptional.isPresent()) {
            Mieszkaniec mieszkaniec = mieszkaniecOptional.get();
            model.addAttribute("mieszkaniec", mieszkaniec);
        }
        return "osobaDetails";
    }
}
