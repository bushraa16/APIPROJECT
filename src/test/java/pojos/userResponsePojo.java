package pojos;

public class userResponsePojo {

    private Integer userid;
    private userpojo userpojo;

    public userResponsePojo() {
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public pojos.userpojo getUserpojo() {
        return userpojo;
    }

    public void setUserpojo(pojos.userpojo userpojo) {
        this.userpojo = userpojo;
    }

    @Override
    public String toString() {
        return "userResponsePojo{" +
                "userid=" + userid +
                ", userpojo=" + userpojo +
                '}';
    }
}