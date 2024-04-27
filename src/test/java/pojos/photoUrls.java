package pojos;

public class photoUrls {
    private String urls1;
    private String url2;

    public photoUrls(String urls1, String url2) {
        this.urls1 = urls1;
        this.url2 = url2;
    }

    public String getUrls1() {
        return urls1;
    }

    @Override
    public String toString() {
        return "photoUrls{" +
                "urls1='" + urls1 + '\'' +
                ", url2='" + url2 + '\'' +
                '}';
    }

    public void setUrls1(String urls1) {
        this.urls1 = urls1;
    }

    public String getUrl2() {
        return url2;
    }

    public void setUrl2(String url2) {
        this.url2 = url2;
    }
}
