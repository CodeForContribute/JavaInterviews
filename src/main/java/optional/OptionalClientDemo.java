package optional;
import java.util.List;
import java.util.Arrays;
import java.util.Optional;

public class OptionalClientDemo {
    public static Optional<Customer> getCustomerByEmailId(String email) throws Exception{
        List<Customer>customers = EkartDataBase.getAllCustomers();
        Customer customerWithEmailId = customers.stream()
                .filter(customer -> customer.getEmail().equals(email))
                .findAny().get();
        return Optional.of(customerWithEmailId);
    }
    public static void main(String[] args) {
        Customer customer=new Customer(101, "john", "test@gmail.com", Arrays.asList("397937955", "21654725"));
        // empty
        // of
        // ofNullable
        Optional<Object>emptyOptional = Optional.empty();
        System.out.println(emptyOptional);

        Optional<String>emailOptional = Optional.of(customer.getEmail());
        System.out.println(emailOptional);

        Optional<String>emailOptional2 = Optional.ofNullable(customer.getEmail());
        emailOptional2.ifPresent(System.out::println);
        System.out.println(emailOptional2.orElse("default@gmail.com"));
        System.out.println(emailOptional2.orElseThrow(()-> new IllegalArgumentException("email not present")));
        System.out.println(emailOptional2.map(String::toUpperCase).orElseGet(()->"default email....."));

        try {
            String emailId = "pqr";
            Optional<Customer>customerOptional = getCustomerByEmailId(emailId);
            if (customerOptional.isPresent()){
                System.out.println(customerOptional.get().getName());
            }else{
                System.out.println("Customer with email id : " + emailId);
            }
        }catch (Exception e){
            // some exception handling here
        }
    }
}
