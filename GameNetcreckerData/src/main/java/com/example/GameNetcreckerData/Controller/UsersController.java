package com.example.GameNetcreckerData.Controller;


import com.example.GameNetcreckerData.Dto.View.View;
import com.example.GameNetcreckerData.Model.Users;
import com.example.GameNetcreckerData.Repo.UsersRepo;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("UsersController")
@Log4j2
public class UsersController {
    @Autowired
    private UsersRepo usersRepo;

    @PostMapping("/addUsers")
    public String addUsers(@RequestParam String name, @RequestParam String email, @RequestParam String password,
                           @RequestParam String role) {
        Users user = new Users(name, email, password, role);

        usersRepo.save(user);

        return "Ok";
    }

    @GetMapping("/getPassword")
    public Boolean getPassword(@RequestParam String email, @RequestParam String password) {

        return usersRepo.findByEmail(email).get(0).getPassword().equals(password);
    }

    @GetMapping("/getRole")
    public String getRole(@RequestParam String email) {

        return usersRepo.findByEmail(email).get(0).getRole();
    }

    @JsonView(View.USERS.class)
    @GetMapping("/getUsers")
    public Users getUsers(@RequestParam String email) {

        return usersRepo.findByEmail(email).get(0);
    }
    @JsonView(View.USERS.class)
    @GetMapping("/getDay")
    public Integer getDay(@RequestParam String email) {

        return usersRepo.findByEmail(email).get(0).getDay();
    }
    @JsonView(View.USERS.class)
    @PostMapping("/nullDay")
    public Integer nullDay(@RequestParam String email) {
        usersRepo.findByEmail(email).get(0).setDay(8);
        usersRepo.save(usersRepo.findByEmail(email).get(0));
        return usersRepo.findByEmail(email).get(0).getDay();
    }
}
