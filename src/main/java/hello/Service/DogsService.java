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
    private DogRepository dogRepository;

    public void delete(Long id){
        dogRepository.deleteById(id);
    }

    public List<Dog>getDogs(){
        List<Dog>dogs;
        return (List<Dog>) dogRepository.findAll();
    }

    public List<Dog> findById(Long id) throws DogNotFoundException {
        List<Dog> dog=dogRepository.findDogByIdDog(id);
        if (dog!=null){
            return dog;
        }
        return null;
    }

    public List<Dog> findByAge(Integer age)throws DogNotFoundException{
        List<Dog> dog=dogRepository.findDogByAge(age);
        if (dog!=null){
            return dog;
        }
        return null;
    }

    public Object save(Dog dogToO) {
        return dogRepository.save(dogToO);
    }
}
