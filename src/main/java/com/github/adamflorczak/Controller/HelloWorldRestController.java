package com.github.adamflorczak.Controller;

import com.github.adamflorczak.model.NameDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
public class HelloWorldRestController {

    @RequestMapping(method = RequestMethod.GET, value = "hello-name")
    public String helloWorld(@RequestParam(name ="name", required = false, defaultValue = "Anonymous")String name){
        return "Hello " + name; // RequestParam czyli np. ?name=imie w adresie URI w przeglądarce
    }


    @RequestMapping("/hello-name/{name}")
    public String helloWorldVariable (@PathVariable String name){
        return "Hello " + name + " - variable";
    }

    @PostMapping("/hello-name-body") // bez RequestBody będzie z parametrami w URI ?variable=value
    public String helloNameBody(@RequestBody NameDto name, Integer age) {
        return "Hello " + name.getName() + " you are " + age + " years old -body";

    }

    // ZMIANA ODPOWIEDZI HTTP na wskazaną wartość

 @RequestMapping(value = "/status/entity", method = RequestMethod.GET)
public String sendViaResponseEntity(){
        return "Hello World " + new ResponseEntity(HttpStatus.CREATED).toString();
 }

 @GetMapping("/status/annotation")
    @ResponseStatus(HttpStatus.CREATED)
    public String helloStatusAnnotation(){
        return "Hello World!";
 }

 @GetMapping("status/response")
    public String helloStatusResponse(HttpServletResponse response){
        response.setStatus(201);
        return "Hello World" + response.toString();
 }

}
