package BusinessLayer;

public class Client {
    private Order order;
    private int check;

    public Client(Order order, int check) {
        this.order = order;
        this.check = check;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getCheck() {
        return check;
    }

    public void setCheck(int check) {
        this.check = check;
    }
}
