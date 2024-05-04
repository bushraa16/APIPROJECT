package pojos;

public class petResponsePojo {

    private Integer petid;
    private homework12pojo homework12pojo;


    public Integer getPetid() {
        return petid;
    }

    public void setPetid(Integer petid) {
        this.petid = petid;
    }

    public pojos.homework12pojo getHomework12pojo() {
        return homework12pojo;
    }

    public void setHomework12pojo(pojos.homework12pojo homework12pojo) {
        this.homework12pojo = homework12pojo;
    }

    @Override
    public String toString() {
        return "petResponsePojo{" +
                "petid=" + petid +
                ", homework12pojo=" + homework12pojo +
                '}';
    }
}