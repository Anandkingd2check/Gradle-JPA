package hello.Entities;


import lombok.Builder;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Dog {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long idDog;
    private String name;
    private int age;

    public Dog(){}

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Long getIdDog() {
        return idDog;
    }

    public void setIdDog(Long idDog) {
        this.idDog = idDog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Dog getDogDetails(Dog dog){
        Dog dog1=new Dog();
        dog1.setIdDog(dog.getIdDog());
        dog1.setAge(dog.getAge());
        dog1.setName(dog.getName());
        return dog;
    }
}
