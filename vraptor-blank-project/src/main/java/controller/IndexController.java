package controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;

import javax.inject.Inject;

@Controller
public class IndexController {

    @Inject
    private Result result;

    @Get("/")
    public void index() {
        result.include("message", "Hello, VRaptor 4!");
    }
}