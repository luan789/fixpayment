package vn.com.nttdata.intern.payah;

public class Country {
    private Integer Image;
    private String Code;


    public Country(Integer image, String code) {
        Image = image;
        Code = code;
    }

    public Integer getImage() {
        return Image;
    }

    public void setImage(Integer image) {
        Image = image;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }
}
