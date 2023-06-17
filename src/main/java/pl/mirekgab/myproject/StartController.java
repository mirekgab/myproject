package pl.mirekgab.myproject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StartController {

    @GetMapping("/")
    public String hello() {
        return "myproject by mirekgab";
    }
}
