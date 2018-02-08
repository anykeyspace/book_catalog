package anykeyspace.bookcatalog.view;

public class BookListView {

    private String name;
    private int year;

    // for jackson
    public BookListView() {
    }

    @Override
    public String toString() {
        return "BookListView{" +
                "name='" + name + '\'' +
                ", year=" + year +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
