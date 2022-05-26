package BusinessLayer;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CompositeProduct extends MenuItem{
    private ArrayList<BaseProduct> productList;

    public CompositeProduct(ArrayList<BaseProduct> productList, String name) {
        this.productList = productList;
        int calories = 0,protein=0,sodium=0,fats=0,rating=0;
        for(BaseProduct p : productList){
            calories+= p.getCalories();
            protein+=p.getProteins();
            sodium+=p.getSodium();
            fats+=p.getFats();
            rating+=p.getRating()/productList.size();
        }
        setCalories(calories);
        setProteins(protein);
        setSodium(sodium);
        setFats(fats);
        setRating((double) rating);
        setTitle(name);
    }

    public ArrayList<BaseProduct> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<BaseProduct> productList) {
        this.productList = productList;
    }

    @Override
    public double computePrice() {
        double finalPrice = 0;
        for(BaseProduct product : productList){
            finalPrice+= product.getPrice();
        }
        setPrice((double) finalPrice);
        return finalPrice;
    }

    @Override
    public String toString(){
        return getTitle()+" "+getRating()+" "+getCalories()+" "+getProteins()+" "+getFats()+" "+getSodium()+" "+getPrice();
    }
}
