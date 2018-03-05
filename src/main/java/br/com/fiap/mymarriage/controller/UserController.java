package br.com.fiap.mymarriage.controller;

import br.com.fiap.mymarriage.model.User;
import br.com.fiap.mymarriage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping("/search/{user}")
    public User buscarUser(@PathVariable(value = "user") String user){

        return userService.buscarUser(user);
    }

    @PostMapping()
    public void salvarUser(@RequestBody User user){
        userService.saveUser(user);
    }

    @PostMapping("/login/")
    public boolean login(@RequestBody User user){

        return userService.login(user.getNome(), user.getPassword());
    }

}
