package school.cesar.Aula1.util;

import school.cesar.Aula1.Customer;

public class CustomerBuilder {

    private String firstname = "" ;
    private String lastname = "";
    private String datebirth = "";
    private String maritalstatus = "";
    private String city = "";
    private String state = "";

    public CustomerBuilder() {}

public CustomerBuilder setFirstName(String firstname){
        this.firstname = firstname;
        return this;
}
public CustomerBuilder setLastName(String lastname){
        this.lastname = lastname;
        return this;
}
public CustomerBuilder setDateBirth(String datebirth){
        this.datebirth = datebirth;
        return this;
}
public CustomerBuilder setMaritalStatus(String maritalstatus){
        this.maritalstatus = maritalstatus;
        return this;
}
public CustomerBuilder setCity(String city){
        this.city = city;
        return this;
}
public CustomerBuilder setState(String state){
        this.state = state;
        return this;
}
public Customer build(){
        return new Customer(firstname,lastname,datebirth,maritalstatus,city,state);
}
}
