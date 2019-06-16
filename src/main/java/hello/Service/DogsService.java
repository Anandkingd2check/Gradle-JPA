package hello.Service;

import hello.Entities.Dog;
import hello.Exception.DogNotFoundException;
import hello.Repositories.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DogsService {
    @Autowired
    DogRepository dogRepository;

    public void delete(long id){
        dogRepository.deleteById(id);
    }

    public List<Dog>getDogs(){
        List<Dog>dogs;
        return (List<Dog>) dogRepository.findAll();
    }

    public Optional<Dog> findById(long id) throws DogNotFoundException {
        Optional<Dog>dog;
        return dog=Optional.ofNullable(findById(id).orElseThrow(new DogNotFoundException("Id not found:" + id)));
    }

    public Object save(Dog dogToO) {
        return dogRepository.save(dogToO);
    }
}
