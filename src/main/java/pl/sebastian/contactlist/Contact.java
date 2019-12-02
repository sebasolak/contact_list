package pl.sebastian.contactlist;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contact {

    private Long id;
    private String name;
    private String email;
    private String country;

//    public Contact(String name, String email, String country) {
//        this.name = name;
//        this.email = email;
//        this.country = country;
//    }


//    public Contact(String name, String email, String country) {
//        this.name = name;
//        this.email = email;
//        this.country = country;
//    }

    public Contact() {

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

