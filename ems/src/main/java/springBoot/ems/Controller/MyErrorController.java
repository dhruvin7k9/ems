package springBoot.ems.Controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError() {
        return "error"; // Point to an error.jsp page
    }

    public String getErrorPath() {
        return "/error";
    }
}