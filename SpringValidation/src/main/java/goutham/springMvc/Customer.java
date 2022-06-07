package goutham.springMvc;

import goutham.springMvc.validation.CourseCode;

import javax.validation.constraints.*;

public class Customer {
    private String firstName;

    @NotNull(message = "Is required")
    @Size(min = 1,message = "is Required")
    private String lastName;

    @Min(value = 0,message = "Value Must Be Greater than or Equal to Zero")
    @Max(value = 10,message = "Value Must Be less than or Equal to Ten")
    @NotNull(message = "Is Required")
    private Integer freePass;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}",message = "Must contain only 5 char / digits")
    private String postalCode;

    @CourseCode(value = "LUV",message="must start with LUV")
    private String courseCode;
    public String getCourseCode()
    {
        return courseCode;
    }
    public void setCourseCode(String theCourseCode)
    {
        this.courseCode=theCourseCode;
    }
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

    public Integer getFreePass() {
        return freePass;
    }

    public void setFreePass(Integer freePass) {
        this.freePass = freePass;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
