package dtos;

import entities.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonDTO {
    private int id;
    private String fName;
    private String lName;
    private String phone;

    public PersonDTO(Person p) {
        this.fName = p.getFirstName();
        this.lName = p.getLastName();
        this.phone = p.getPhone();
        this.id = p.getId();
    }
    public PersonDTO(String fn,String ln, String phone) {
        this.fName = fn;
        this.lName = ln;
        this.phone = phone;
    }
    public PersonDTO() {}


    public static List<PersonDTO> getDtos(List<Person> personList){
        List<PersonDTO> pdtos = new ArrayList();
        personList.forEach(p->pdtos.add(new PersonDTO(p)));
        return pdtos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "PersonDTO{" +
                "id=" + id +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
