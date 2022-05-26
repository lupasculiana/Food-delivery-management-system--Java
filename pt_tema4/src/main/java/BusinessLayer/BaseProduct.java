package BusinessLayer;

public class BaseProduct extends MenuItem {
    public BaseProduct(String title, double rating, int calories, int proteins, int fats, int sodium, double price) {
        setTitle(title);
        setCalories(calories);
        setFats(fats);
        setPrice(price);
        setProteins(proteins);
        setRating(rating);
        setSodium(sodium);
    }

    @Override
    public double computePrice() {
        double finalPrice = getPrice();
        return finalPrice;
    }

    public String toString(){
        return getTitle()+" "+getRating()+" "+getCalories()+" "+getProteins()+" "+getFats()+" "+getSodium()+" "+getPrice();
    }
}
