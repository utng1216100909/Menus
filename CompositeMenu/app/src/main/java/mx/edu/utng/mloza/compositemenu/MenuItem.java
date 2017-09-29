package mx.edu.utng.mloza.compositemenu;

/**
 * Created by Manuel on 20/09/2017.
 */

public class MenuItem extends MenuComponent{
    private String name;
    private String descripcion;
    private boolean vegetarian;
    private double price;

    public MenuItem(String name,String descripcion, boolean vegetarian, double price){
        this.name=name;
        this.descripcion=descripcion;
        this.vegetarian=vegetarian;
        this.price=price;
    }

    public double getPrice() {
        return price;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public String print(){
        String v;
        if(isVegetarian()){
            v="Vegetariana";
        }else{
            v="No vegetarino";
        }
        return getName()+"\n"+getDescripcion()+"\n"+v+"\n"+getPrice()+"\n\n";
    }
}
