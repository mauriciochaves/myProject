package school.cesar.Aula1;

public class Customer {

     private String firstname;
     private String lastname ;
     private String datebirth;
     private String maritalstatus;
     private String city ;
     private String state;

     public Customer(String firstname, String lastname, String datebirth, String maritalstatus, String city, String state){
         this.firstname = firstname;
         this.lastname = lastname;
         this.datebirth = datebirth;
         this.maritalstatus = maritalstatus;
         this.city = city;
         this.state = state;
     }
    String getFirstname() {
        return firstname;
    }
    String getLastname() {
        return lastname;
    }
    String getDatebirth() {
        return datebirth;
    }
    String getCity() {
        return city;
    }
    String getState() {
        return state;
    }
}
