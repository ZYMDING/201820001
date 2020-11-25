import javax.lang.model.element.Name;

public class Person {
    String name;
    char sex;
    String id;
    String phone;
    String email;


    public Person(String name, char sex, String id){
        this.name=name;
        this.sex=sex;
        this.id=id;
    }

    public Person() {

    }

    public String getId() {
        return id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name=" + name +
                ", sex=" + sex +
                ", id='" + id + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
