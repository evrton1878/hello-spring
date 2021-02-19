package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@Controller
@ResponseBody
@RequestMapping(value="hello")
public class HelloController {
//@GetMapping("hello")
//@ResponseBody
   // public String hello(){
   //     return " Hello, Spring! ";
  //  }
    // now lives at /hello/goodbye
    @GetMapping("goodbye")
   // @ResponseBody
    public String goodbye(){
        return " See u,  Spring! ";
    }
    //Handles request of the form /hello?name=LaunchCode
    // now lives at /hello/hello
   @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
   // @ResponseBody
    public String helloToTheQueryParam(@RequestParam String name, @RequestParam String language){
        String greeting = HelloController.createMessage(name,language);
        return "<h3>" + greeting + "</h3>" ;
    }
    //handles request of the form /hello/launchcode
    @GetMapping("{name}")
    //@ResponseBody
    public String helloWithPathParam(@PathVariable String name){
        return " hello ," + name + "! " ;
    }

    @GetMapping("form")
   // @ResponseBody
    public String helloForm(){

        /*
        <label for="pet-select">Choose a pet:</label>

<select name="pets" id="pet-select">
    <option value="">--Please choose an option--</option>
    <option value="dog">Dog</option>
    <option value="cat">Cat</option>
    <option value="hamster">Hamster</option>
    <option value="parrot">Parrot</option>
    <option value="spider">Spider</option>
    <option value="goldfish">Goldfish</option>
</select>

         */
        return "<html>" +
                "<body>" +
                "<form  action = '/hello' method = 'post'>" + // submit request to /hello
                "<input type = 'text' name ='name'>" +
                "<select name = language>" +
                "<option name='language'>English</option>" +
                "<option name='language'>German</option>" +
                "<option name='language'>Bulgarian</option>" +
                "<option name='language'>Italian</option>" +
                "<option name='language'>Russian</option>" +
                "<input type = 'submit' value ='push me'>" +
                "</select>" +
                "</form>" +
                "</body>" +
                "</html>";

    }

    public static String createMessage(String name, String language){
       switch (language){

           case "German":
               return "Zum Voll " + name;
           case "Bulgarian":
               return "Zdravei " + name;
           case "Italian":
               return "Cio " + name;
           case "Russian":
               return "Zdrastvuite " + name;
           case "English":
           default:
               return "Hello " + name;
       }
    }


}
