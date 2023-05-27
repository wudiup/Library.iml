public class Book {
    private String bookName;
    private String writer;
    private String number;
    private int count;
    private double money;

    public Book() {
    }

    public Book(String bookName, String writer, String number, int count, double money) {
        this.bookName = bookName;
        this.writer = writer;
        this.number = number;
        this.count = count;
        this.money = money;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
