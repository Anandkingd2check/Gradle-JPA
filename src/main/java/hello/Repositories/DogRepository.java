package hello.Repositories;

import hello.Entities.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DogRepository extends CrudRepository<Dog,Long> {

    List<Dog> findDogByIdDog(Long id);
    List<Dog> findDogByAge(Integer age);

}
