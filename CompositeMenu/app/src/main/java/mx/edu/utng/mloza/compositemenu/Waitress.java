package mx.edu.utng.mloza.compositemenu;

/**
 * Created by Manuel on 20/09/2017.
 */

public class Waitress {//camarera
    MenuComponent allMenus;

    public Waitress(MenuComponent allMenus){
        this.allMenus = allMenus;
    }

    public String printMenu(){
        return allMenus.print();
    }
}
