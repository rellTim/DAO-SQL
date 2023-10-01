package my.project.dataaccessobject.controller;

import my.project.dataaccessobject.repository.DAORepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DAOController {
    DAORepository repository;

    @GetMapping("/products")
    public List<String> getProduct(@RequestParam("name") String name) {
        return repository.getProductName(name);
    }
}
