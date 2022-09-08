package br.com.fiap.epictaskapi.controller;

import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.epictaskapi.model.User;
import br.com.fiap.epictaskapi.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
    
    @Autowired
    UserService service; 
    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping
    public Page<User> index( @PageableDefault(size = 10, sort = "name") Pageable pageable){
        return service.listAll(pageable);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> show(@PathVariable Long id){
        return ResponseEntity.of( service.getById(id) );   
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody @Valid User user){
        Assert.hasLength(user.getPassword(), "Campo senha inválido");
        user.password(passwordEncoder.encode(user.getPassword()));
        service.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id){
        Optional<User> optional = service.getById(id);

        if (optional.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        service.deleteById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @PutMapping("{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody @Valid User newUser){
        Optional<User> optional = service.getById(id);

        if (optional.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        var user = optional.get();
        BeanUtils.copyProperties(newUser, user, "password");
        System.out.println(newUser.getName());
        System.out.println(user.getName());
        user.setId(id);

        
        service.save(user);
        System.out.println(user.getPassword());

        return ResponseEntity.ok(user);
    }
}
