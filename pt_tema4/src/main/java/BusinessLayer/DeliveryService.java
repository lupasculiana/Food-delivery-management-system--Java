package BusinessLayer;
import GUI.AdminController;
import GUI.MenuController;
import GUI.ViewAdmin;

import java.awt.*;
import java.io. * ;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Random;


public class DeliveryService extends Observable implements IDeliveryServiceProcessing {
    private List<BaseProduct> productList = new ArrayList<BaseProduct>();
    private HashMap<Order, List<MenuItem>> orders = new HashMap<Order, List<MenuItem>>();
    private HashMap<Order, List<MenuItem>> ordersNew = new HashMap<Order, List<MenuItem>>();
    private List<String> productsOrders = new ArrayList<>();

    @Override
    public void readFile() throws IOException {
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("products.csv"));
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                List<String> product = Stream.of(line.split(",")).map(e -> new String(e)).collect(Collectors.toList());
                BaseProduct baseProduct = new BaseProduct(product.get(0), Double.parseDouble(product.get(1)), Integer.parseInt(product.get(2)), Integer.parseInt(product.get(3)), Integer.parseInt(product.get(4)), Integer.parseInt(product.get(5)), Double.parseDouble(product.get(6)));
                productList.add(baseProduct);
            }
            for(BaseProduct product : productList){
                productList=productList.stream().distinct().toList();
                File file = new File("products.txt");
                file.createNewFile();
                FileWriter write = new FileWriter("products.txt",true);
                BufferedWriter buffWr = new BufferedWriter(write);
                buffWr.write(product.getTitle());
                buffWr.write(product.getRating().toString());
                buffWr.write(" ");
                buffWr.write(product.getCalories().toString());
                buffWr.write(" ");
                buffWr.write(product.getProteins().toString());
                buffWr.write(" ");
                buffWr.write(product.getFats().toString());
                buffWr.write(" ");
                buffWr.write(product.getSodium().toString());
                buffWr.write(" ");
                buffWr.write(product.getPrice().toString());
                buffWr.newLine();
                buffWr.flush();
                buffWr.close();
                write.close();
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }

    }

    public void addProduct(MenuItem menuItem) throws IOException {
        File file1 = new File("products.txt");
        file1.createNewFile();
        FileWriter write = new FileWriter("products.txt",true);
        BufferedWriter buffWr = new BufferedWriter(write);
        buffWr.append(menuItem.toString());
        buffWr.newLine();
        buffWr.flush();
        buffWr.close();
        write.close();
        productList.add((BaseProduct) menuItem);
    }

    public void deleteProduct(BaseProduct baseProduct) throws IOException {
        File file = new File("products.txt");
        List<String> out = Files.lines(file.toPath())
                .filter(line -> !line.contains(baseProduct.toString()))
                .collect(Collectors.toList());
        Files.write(file.toPath(), out, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
        productList.remove(baseProduct);

    }

    public void modifyProduct(BaseProduct baseProduct,String column,String newValue) throws IOException {
        BaseProduct newProduct = baseProduct;
        switch(column){
            case "title": newProduct.setTitle(newValue);
            case "rating": newProduct.setRating(Double.parseDouble(newValue));
            case "price" : newProduct.setPrice(Double.parseDouble(newValue));
            case "sodium" : newProduct.setSodium(Integer.parseInt(newValue));
            case "protein" : newProduct.setProteins(Integer.parseInt(newValue));
            case "calories" : newProduct.setCalories(Integer.parseInt(newValue));
            case "fat" : newProduct.setFats(Integer.parseInt(newValue));}
        deleteProduct(baseProduct);
        addProduct(newProduct);
    }

        public List<String> searchProduct(String keyword) {
            List<String> result = new ArrayList<>();
            try (Stream<String> stream = Files.lines(Paths.get("products.txt"))) {
               result = stream.filter(lines -> lines.contains(keyword)).collect(Collectors.toList());
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(result.size()!=0)
            {
                return result;
            }
            else
            {
                result.add("The product does not exist ! ");
                return result;
            }
        }

    public List<BaseProduct> getProductList() {
        return productList;
    }

    public void setProductList(List<BaseProduct> productList) {
        this.productList = productList;
    }

    public void addOrder(Order order, List<MenuItem> products,int orderID,int clientID) throws IOException {
        orders.put(order,products);
        double finalPrice = 0;
        String bon = new String();
        String produse = new String();
        bon="Order "+orderID+" of client " + clientID +
                " was made on "+ order.getOrderDate()+ " and contains the products :";
        for(MenuItem m : products){
            bon+=m.getTitle()+",";
            produse+=m.getTitle()+";";
            finalPrice += m.computePrice();
        }
        order.setPrice((int) finalPrice);
        bon+=";\n The total price is : " + finalPrice;
        Random rand = new Random();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("bon_digital_"+rand.nextInt(1000)+".txt"))));
        writer.write(bon);
        writer.flush();

        setChanged();
        notifyObservers("NEW ORDER : " + bon);

        File file = new File("orders.txt");
        file.createNewFile();
        FileWriter write = new FileWriter("orders.txt",true);
        BufferedWriter buffWr = new BufferedWriter(write);
        buffWr.write(String.valueOf(orderID));
        buffWr.write(",");
        buffWr.write(String.valueOf(clientID));
        buffWr.write(",");
        buffWr.write(order.getOrderDate());
        buffWr.write(",");
        buffWr.write(produse);
        buffWr.write(String.valueOf(finalPrice));
        buffWr.newLine();
        buffWr.flush();
        buffWr.close();
        write.close();
    }

    public void readOrderFile(){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("orders.txt"));
            String line = reader.readLine();
            while (line != null) {
                String[] info = line.split(",");
                int orderID = Integer.parseInt(info[0]);
                int clientID = Integer.parseInt(info[1]);
                String date = info[2];
                String products = info[3];
                String [] titles = products.split(" ;");
                List<MenuItem> productsList = new ArrayList<>();
                for(String s : titles){
                    Random rand = new Random();
                    MenuItem menuItem = new BaseProduct(s, rand.nextDouble(), rand.nextInt(1000),rand.nextInt(1000),
                            rand.nextInt(1000),rand.nextInt(1000),rand.nextDouble());
                    productsList.add(menuItem);
                }
                Order order = new Order(orderID,clientID,date);
                ordersNew.put(order,productsList);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void generateFirstReport(String[] start, String[] end) throws IOException {
        readOrderFile();
        orders = ordersNew;
        int startingHour = Integer.parseInt(start[0]+start[1]+start[2]);
        int endingHour = Integer.parseInt(end[0]+end[1]+end[2]);
        /*List<Order> goodOrders = new ArrayList<>();
        for (Order key : orders.keySet()) {
            if(Integer.parseInt(key.getHour())>Integer.parseInt(startingHour) ||
                    Integer.parseInt(key.getHour())<Integer.parseInt(endingHour)){
                goodOrders.add(key);
            }
        }
        Random rand = new Random();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("report_type1_"+rand.nextInt(1000)+".txt"))));
        writer.write("Orders from "+start[0]+":"+start[1]+":"+start[2]+" to "+end[0]+":"+end[1]+
                ":"+end[2]+" are: ");
        for(Order o : goodOrders){
            writer.write(o.toString());
            writer.flush();
        }*/
        Stream<Map.Entry<Order, List<MenuItem>>> stream = orders.entrySet().stream().filter(e-> Integer.parseInt(e.getKey().getHour())>= startingHour);
        Stream<Map.Entry<Order, List<MenuItem>>> stream1 = stream;
        Stream<Map.Entry<Order, List<MenuItem>>> stream2 = stream1.filter(e->Integer.parseInt(e.getKey().getHour())<=endingHour);
        Stream<Order> orderStream = stream2.map(e-> new Order(e.getKey()));
        ArrayList<Order> returned = new ArrayList<>(orderStream.toList());
        Random rand = new Random();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("report_type1_"+rand.nextInt(1000)+".txt"))));
        writer.write("Orders from "+start[0]+":"+start[1]+":"+start[2]+" to "+end[0]+":"+end[1]+
                ":"+end[2]+" are: ");
        for(Order o : returned) {
            writer.write(o.toString());
            writer.flush();
        }
    }

    public List<String> getProductsOrders() {
        return productsOrders;
    }

    public void generateSecondReport(int number) throws IOException {
        readOrderFile();
        orders = ordersNew;
        List<Titles> titlesList = new ArrayList<>();
        for(String title : productsOrders) {
            int check = 0;
            Titles titles1 = new Titles(title,check);
            for (String title2 : productsOrders) {
                if (title2.equals(title)) {
                    check++;
                }
            }
            titles1.setCheck(check);
            titlesList.add(titles1);
        }
        Stream<Titles> stream = titlesList.stream().filter(e-> e.getCheck() >= number);
        Stream<String > stringStream = stream.map(e->new String(e.getTitle()));
        ArrayList<String> returned = new ArrayList<>(stringStream.toList());
        Random rand = new Random();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("report_type2_"+rand.nextInt(1000)+".txt"))));
        writer.write("Products ordered more than " + number + " times are : ");
        for(String o : returned) {
            writer.write(o);
            writer.flush();
        }
        writer.flush();

    }

    public void generateThirdReport(String clientMin, String priceMin) throws IOException {
        readOrderFile();
        orders = ordersNew;
        List<Client> clients = new ArrayList<>();
        for (Order key : orders.keySet()) {
            int check = 0;
            Client client = new Client(key,check);
            for(Order keys : orders.keySet()){
                if(keys.getClientID()== key.getClientID()){
                    check++;
                }
            }
            client.setCheck(check);
            clients.add(client);
        }
        Stream<Client> stream = clients.stream().filter(e-> e.getCheck() >=Integer.parseInt(clientMin) && e.getOrder().getPrice() > Integer.parseInt(priceMin));
        Stream<String > stringStream = stream.map(e->new String(String.valueOf(e.getOrder().getClientID())));
        ArrayList<String> returned = new ArrayList<>(stringStream.toList());
        Random rand = new Random();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("report_type3_"+rand.nextInt(1000)+".txt"))));
        writer.write("Clients that have ordered more than " + clientMin + " times  with a minimum " +
                "price of " +priceMin+" are : ");
        for(String o : returned) {
            writer.write(o);
            writer.flush();
        }
        writer.flush();
    }

    public void generateFourthReport(int day,int month) throws IOException {
        readOrderFile();
        orders = ordersNew;
        /*String orderID = new String();
        for(Order key : orders.keySet()){
            if(key.getMonthOff() <= month && key.getDay() <=day){
                orderID+=key.getOrderID()+" ";
            }
        }*/
        Stream<Map.Entry<Order, List<MenuItem>>> stream = orders.entrySet().stream().filter(e-> e.getKey().getMonthOff()<=month &&
                e.getKey().getDay()<=day);
        Stream<Order> orderStream = stream.map(e-> new Order(e.getKey()));
        ArrayList<Order> returned = new ArrayList<>(orderStream.toList());
        Random rand = new Random();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("report_type4_"+rand.nextInt(1000)+".txt"))));
        writer.write("Orders that have been placed up until "+day+"."+month+"."+"2022 are: ");
        for(Order o : returned) {
            writer.write(o.toString());
            writer.flush();
        }
        writer.flush();
    }
}
