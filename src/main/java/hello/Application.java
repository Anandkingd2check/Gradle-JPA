package hello;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import hello.Entities.Customer;
import hello.Entities.Dog;
import hello.Repositories.CustomerRepository;
import hello.Repositories.DogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    final static Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(CustomerRepository customerRepository, DogRepository dogRepository) {
        return args -> {
            customerRepository.save(new Customer("Anand", "SK"));
            customerRepository.save(new Customer("Johnny", "Papa"));
            customerRepository.save(new Customer("Pinky", "Rocky"));
            customerRepository.save(new Customer("Sinkgid", "First"));
            customerRepository.save(new Customer("Anand", "Spring"));
            log.info("");
            
            for(Customer customer:customerRepository.findAll()){
                log.info(customer.toString());
            }
            log.info("findByLastName - > SK ");
            List<Customer> customerSK=(customerRepository.findByLastName("SK"));
            System.out.println(customerSK);

            log.info("findById");
            customerRepository.findById(1L).ifPresent(x->log.info(x.toString()));

            log.info("findByfirstName -> Anand");
            Optional<List<Customer>> newCustomer=Optional.ofNullable(customerRepository.findAllByFirstName("Anand"));

            log.info("Dog Controller Test");
            dogRepository.save(new Dog("Guuu",13));
            dogRepository.save(new Dog("Yeda",15));
            dogRepository.save(new Dog("Pandu",16));
            dogRepository.save(new Dog("Fizu",17));
            dogRepository.save(new Dog("Pashu",18));

            log.info("findAll -> Dogs");
            Iterable<Dog> dogsAll=dogRepository.findAll();
            System.out.println(dogsAll);
            List<Dog>convertedList=toList(dogsAll);
            System.out.println(convertedList);
            loopThroughList(convertedList);

            log.info("findByid -> Dogs");
            Optional<Dog> a=dogRepository.findById(6L);
            if (a.isPresent()) {
                System.out.println(a);
            }


        };

    }
    public static <T> List<Dog> toList(final Iterable<Dog> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
    }

    public void loopThroughList(List<Dog> convertedlist){
        convertedlist.stream().forEach(d-> System.out.println(d.getName()));
    }


}