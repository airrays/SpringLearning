package com.example.actuatorservice.actuatorservice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.concurrent.atomic.AtomicLong;
/***
 * Resource Controller
 */
@Controller
public class HelloWorldController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/hello-world")
    @ResponseBody
    public Greeting sayHello(@RequestParam(name="name",required=false,defaultValue="Stranger") String name){
        return new Greeting(counter.incrementAndGet(), String.format(template,name));
    }
}

/***
 * The key difference between a human-facing controller and a REST endpoint controller
 * is in how the response is created. Rather than rely on a view (such as JSP) to render model data in HTML,
 * an endpoint controller returns the data to be written directly to the body of the response.
 *
 * The @ResponseBody annotation tells Spring MVC not to render a model into a view but, rather,
 * to write the returned object into the response body.
 * It does so by using one of Spring’s message converters. Because Jackson 2 is in the classpath,
 * MappingJackson2HttpMessageConverter will handle the conversion of a Greeting object to JSON
 * if the request’s Accept header specifies that JSON should be returned.
 */