package spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {
    //http://localhost:8080/first/hello?name=alex&surname=kalinin
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {

        //System.out.println("Hello, " + name + " " + surname);

        model.addAttribute("message", "Hello, " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByPage() {
        return "first/goodbye";
    }

    //http://localhost:8080/first/calculator?a=87&b=54&action=*
    @GetMapping("/calculator")
    public String calc(@RequestParam(value = "a", required = false) int a,
                       @RequestParam(value = "b", required = false) int b,
                       @RequestParam(value = "action", required = false) String c,
                       Model model) {
        double result;

        switch (c) {
            case "*":
                result = a * b;
                break;
            case "sum":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "/":
                result = a / (double) b;
                break;
            default:
                result = 404;
                break;
        }
        model.addAttribute("act", result);

        return "first/calculator";
    }
}


/*
@GetMapping("/hello")
    public String helloPage(HttpServletRequest request) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        System.out.println("Hello, " + name + " " + surname);

        return "first/hello";
    }
 */