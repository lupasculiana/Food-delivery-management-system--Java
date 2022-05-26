package BusinessLayer;
import java.awt.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class Order {
    private Integer orderID;
    private Integer clientID;
    private String orderDate;
    private String hour;
    private int monthOff;
    private int day;
    private int price;

    public Order(int orderID,int clientID,String orderDate){
        this.orderID=orderID;
        this.clientID=clientID;
        this.orderDate=orderDate;
        String numbers = orderDate.replaceAll("[^0-9]", "");
        numbers=numbers.substring(2);
        hour=numbers.substring(0, numbers.length() - 8);
        generateDayAndMonth(orderDate);
    }

    public Order(String orderDate) {
        this.orderDate = orderDate;
        String numbers = orderDate.replaceAll("[^0-9]", "");
        numbers=numbers.substring(2);
        hour=numbers.substring(0, numbers.length() - 8);
        generateDayAndMonth(orderDate);

    }
    public Order(Order order) {
        this.orderDate = order.getOrderDate();
        this.clientID = order.clientID;
        this.orderID = order.orderID;
        String numbers = orderDate.replaceAll("[^0-9]", "");
        numbers=numbers.substring(2);
        hour=numbers.substring(0, numbers.length() - 8);
        generateDayAndMonth(orderDate);

    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        while(orderID>1){
            hash+=orderID%10;
            orderID=orderID/10;
        }
        while(clientID>1){
            hash+=clientID%10;
            clientID=clientID/10;
        }
        hash+=orderDate.hashCode();
        hash = hash * 31;
        return hash;
    }

    public int getOrderID() {
        return orderID;
    }

    public int getClientID() {
        return clientID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", clientID=" + clientID +
                ", order date='" + orderDate + '\'' +
                '}';
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMonthOff() {
        return monthOff;
    }

    public int getDay() {
        return day;
    }

    public void generateDayAndMonth(String orderDate){
        String date=orderDate.substring(4);
        String dayF = orderDate.substring(8);
        day = Integer.parseInt(dayF.substring(0, dayF.length() - 19));
        String month = date.substring(0, date.length() - 22);
        switch (month) {
            case "January":
                monthOff = 1;
                break;
            case "February":
                monthOff = 2;
                break;
            case "March":
                monthOff = 3;
                break;
            case "April":
                monthOff = 4;
                break;
            case "May":
                monthOff = 5;
                break;
            case "June":
                monthOff = 6;
                break;
            case "July":
                monthOff = 7;
                break;
            case "August":
                monthOff = 8;
                break;
            case "September":
                monthOff = 9;
                break;
            case "October":
                monthOff = 10;
                break;
            case "November":
                monthOff = 11;
                break;
            case "December":
                monthOff = 12;
                break;
        }
    }
}
