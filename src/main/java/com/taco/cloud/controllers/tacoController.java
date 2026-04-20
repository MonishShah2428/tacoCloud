package com.taco.cloud.controllers;

import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.taco.cloud.models.taco;
import com.taco.cloud.repository.tacosRepository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping(path="/api/tacos", produces = "application/json")
@CrossOrigin(origins = "*")
public class tacoController {
    private tacosRepository tacoRepo;

    public tacoController(tacosRepository tacoRepo) {
        this.tacoRepo = tacoRepo;
    }
    @GetMapping(params = "recent")
    public Iterable<taco> recentTacos() {
        PageRequest page = PageRequest.of(0, 12, Sort.by("createdAt").descending());
        return tacoRepo.findAll(page).getContent();
    }
    @GetMapping("/{id}")
    public ResponseEntity<taco> tacoById(@PathVariable("id") String id) {
        return tacoRepo.findById(id)
            .map(t -> new ResponseEntity<>(t, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public taco postTaco(@RequestBody taco taco) {
        return tacoRepo.save(taco);
    }
}
