package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.Arrays;
@JsonIgnoreProperties(ignoreUnknown = true)
public class homework12pojo {
    private Integer id;
    private categoryDatepojo categoryDatepojo;
    private String name;
    private ArrayList photoUrls;
    private tagspojo tagsDatapojo;
    private String status;


    public homework12pojo(Integer id,pojos.categoryDatepojo categoryDatepojo, String name, ArrayList photoUrls,pojos.tagspojo tagsDatapojo, String status) {
        this.id=id;
        this.categoryDatepojo = categoryDatepojo;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tagsDatapojo = tagsDatapojo;
        this.status = status;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public pojos.categoryDatepojo getCategoryDatepojo() {
        return categoryDatepojo;
    }
    public void setCategoryDatepojo(pojos.categoryDatepojo categoryDatepojo) {
        this.categoryDatepojo = categoryDatepojo;
    }
    public homework12pojo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(ArrayList photoUrls) {
        this.photoUrls = photoUrls;
    }

    public pojos.tagspojo getTagsDatapojo() {
        return tagsDatapojo;
    }

    public void setTagsDatapojo(pojos.tagspojo tagsDatapojo) {
        this.tagsDatapojo = tagsDatapojo;
    }

    public String getstatus() {
        return status;
    }

    public void setstatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "homework12pojo{" +
                ",id="+id+
                ", categoryDatepojo=" + categoryDatepojo +
                ", name='" + name + '\'' +
                ", photoUrls=" + photoUrls +
                ", tagsDatapojo=" + tagsDatapojo +
                ", status='" + status + '\'' +
                '}';
    }

}



