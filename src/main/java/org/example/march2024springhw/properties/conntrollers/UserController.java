package org.example.march2024springhw.properties.conntrollers;

import org.example.march2024springhw.entity.User;
import org.example.march2024springhw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owners")
public class UserController {

    @Autowired
    private UserService ownerService;

    @GetMapping
    public List<User> getAllOwners() {
        return ownerService.findAll();
    }

    @PostMapping
    public User createOwner(@RequestBody User owner) {
        return ownerService.save(owner);
    }

    @GetMapping("/{id}")
    public User getOwnerById(@PathVariable Long id) {
        return ownerService.findById(id);
    }

    @PutMapping("/{id}")
    public User updateOwner(@PathVariable Long id, @RequestBody User owner) {
        return ownerService.update(id, owner);
    }

    @DeleteMapping("/{id}")
    public void deleteOwner(@PathVariable Long id) {
        ownerService.deleteById(id);
    }
}
