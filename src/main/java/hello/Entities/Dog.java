package hello.Entities;


import lombok.Builder;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Dog {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private int age;

    public Dog(){}

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
        dog1.setId(dog.getId());
        dog1.setAge(dog.getAge());
        dog1.setName(dog.getName());
        return dog;
    }


}
