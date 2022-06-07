package com.goutham.springMvc;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class Customer {
    private String firstName;

    @NotNull(message = "Is required")
    @Size(min = 1,message = "is Required")
    private String lastName;


    public void setFirstName(String firstName){
        this.firstName=firstName;
    }
    public String getFirstName(){
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
