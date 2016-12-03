import java.io.Serializable;

public class Asset implements Serializable {

    private String title;
    private double value;

    public Asset(String title, double value) {
        this.title = title;
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Asset{" + "title='" + title + '\'' + ", value=" + value + '}';
    }
}
