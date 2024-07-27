package com.Thesis.waterfill.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Thesis.waterfill.Model.History;
import com.Thesis.waterfill.NotFoundException.HistoryNotFoundException;
import com.Thesis.waterfill.Repository.HistoryRepository;



@RestController
@RequestMapping("/api/v1/history")
public class HistoryController {
    HistoryRepository repo;
    public HistoryController(HistoryRepository repo) {
        this.repo = repo;
    }

    //127.0.0.1:8080/history
    @GetMapping("/all")
    public List <History>getHistories(){
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public History getHistory(@PathVariable Long id){
        return repo.findById(id)
        .orElseThrow(()-> new HistoryNotFoundException(id));
    }

    @GetMapping("/new")
    public String addHistory(@RequestBody History newHistory) {
        repo.save(newHistory);
        return "A New History is Added!";
    }

     // GET endpoint to fetch History records by userId
    @GetMapping("/user/{userId}")               
    public ResponseEntity<List<History>> getHistoryByUserId(@PathVariable("userId") Long userId) {
        List<History> histories = repo.findByUserId(userId);
        if (histories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(histories, HttpStatus.OK);
    }

    

   
}
