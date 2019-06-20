package hello.Controller;

import hello.Application;
import hello.Entities.Dog;
import hello.Exception.DogNotFoundException;
import hello.Repositories.DogRepository;
import hello.Service.DogsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("dogs")
public class DogController {
    final static Logger log = LoggerFactory.getLogger(DogController.class);
    @Autowired
    DogsService dogsService;

    @Autowired
    DogRepository dogRepository;

    @RequestMapping(value="/get-by-id/{id}",method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:3000")
    @ResponseBody
    public ResponseEntity<List<Dog>>findById(@PathVariable("id") Long id)  {
        List<Dog> dog= null;
        try {
            dog = dogsService.findById(id);
        } catch (DogNotFoundException e) {
            e.printStackTrace();
        }
        if (dog!=null){
            return ResponseEntity.ok(dog);
        }
        log.error("Dog not found with id:"+id);
        return ResponseEntity.badRequest().build();
    }

    @RequestMapping(value="/get-by-age/{age}",method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:3000")
    @ResponseBody
    public ResponseEntity<List<Dog>>findByAge(@PathVariable("age") Integer age)  {
        List<Dog> dog= null;
        try {
            dog = dogsService.findByAge(age);
        } catch (DogNotFoundException e) {
            e.printStackTrace();
        }
        //List<Dog> dog=dogRepository.findDogByAge(age);
        if (dog!=null){
            return ResponseEntity.ok(dog);
        }
        log.error("Dog not found with age:"+age);
        return ResponseEntity.badRequest().build();
    }

    //@GetMapping
    @RequestMapping(value="/get-all-dogs",method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<Dog>> getDogs(){
        return (ResponseEntity.ok(dogsService.getDogs()));
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody Dog dog){
        return ResponseEntity.ok(dogsService.save(dog));
    }



}