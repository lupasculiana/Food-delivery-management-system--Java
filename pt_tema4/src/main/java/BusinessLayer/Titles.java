package BusinessLayer;

public class Titles {
   private String title;
   private int check;

    public Titles(String title, int check) {
        this.title = title;
        this.check = check;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCheck() {
        return check;
    }

    public void setCheck(int check) {
        this.check = check;
    }
}
