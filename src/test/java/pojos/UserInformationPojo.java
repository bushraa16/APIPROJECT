package pojos;


public class UserInformationPojo {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
//    private String id;
//    private Integer __v;

    public UserInformationPojo() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public Integer get__v() {
//        return __v;
//    }
//
//    public void set__v(Integer __v) {
//        this.__v = __v;
//    }

    public UserInformationPojo(String firstName, String lastName, String email, String password, String id, Integer __v) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
       this.password = password;
//        this.id = id;
//        this.__v = __v;
    }

    @Override
    public String toString() {
        return "UserInformationPojo{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
//                ", id='" + id + '\'' +
//                ", __v=" + __v +
                '}';
    }
}
