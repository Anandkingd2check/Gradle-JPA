package hello.Controller;

import hello.Application;
import hello.Entities.Dog;
import hello.Exception.DogNotFoundException;
import hello.Service.DogsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dogs")
public class DogController {
    final static Logger log = LoggerFactory.getLogger(DogController.class);
    @Autowired
    DogsService dogsService;


    @RequestMapping("/dogs")
    public String index() {
        return "Greetings from Dog Controller!";
    }

    @GetMapping
    public ResponseEntity<List<Dog>> getDogs(){
        return (ResponseEntity.ok(dogsService.getDogs()));
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody Dog dog){
        return ResponseEntity.ok(dogsService.save(dog));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dog>findById(@PathVariable Long id) throws DogNotFoundException {
        Optional<Dog> dog=dogsService.findById(id);
        if (dog.isPresent()){
            return ResponseEntity.ok(dog.get());
        }
        log.error("Dog not found with id:"+id);
        return ResponseEntity.badRequest().build();
    }

}