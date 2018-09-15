package school.cesar;

class CustomerBuilder {

    private String firstname = "" ;
    private String lastname = "";
    private String datebirth = "";
    private String maritalstatus = "";
    private String city = "";
    private String state = "";

    CustomerBuilder() {}

CustomerBuilder setFirstName(String firstname){
        this.firstname = firstname;
        return this;
}
CustomerBuilder setLastName(String lastname){
        this.lastname = lastname;
        return this;
}
CustomerBuilder setDateBirth(String datebirth){
        this.datebirth = datebirth;
        return this;
}
CustomerBuilder setMaritalStatus(String maritalstatus){
        this.maritalstatus = maritalstatus;
        return this;
}
CustomerBuilder setCity(String city){
        this.city = city;
        return this;
}
CustomerBuilder setState(String state){
        this.state = state;
        return this;
}
Customer build(){
        return new Customer(firstname,lastname,datebirth,maritalstatus,city,state);
}
}
