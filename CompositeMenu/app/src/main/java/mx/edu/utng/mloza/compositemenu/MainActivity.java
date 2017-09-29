package mx.edu.utng.mloza.compositemenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner cmbMenus;
    Spinner cmbMenuSeleccionado;
    Button btnAgregarPlatillo;
    Button btnMostrarPlatillo;
    String[] desayunos={"Huevos a la Mexicana", "Chilaquiles", "Jugo naranja","Coctel de frutas","Hotcakes","Crepas"};
    String[] comidas={"Chiles rellenos","Pollo empanizado","Enchiladas verdes","Enchiladas rojas","Mole de olla"};
    String[] cena={"Tacos de pastor","Quesadillas","Ensalada","Pozole","Chocolote"};
    ArrayAdapter<String> adapter;
    MenuComponent desayunosMenu = new Menu("Menu desayunos","Desayunos");
    MenuComponent comidasMenu = new Menu("Menu comidas","Comidas");
    MenuComponent cenasMenu= new Menu("Menu cenas","Cenas");
    MenuComponent allMenus= new Menu("Todos los Menus","Menu Combinado");
    TextView txtOrden;//<---------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cmbMenus= (Spinner)findViewById(R.id.cmb_menus);
        cmbMenuSeleccionado = (Spinner)findViewById(R.id.cmb_menu_disponible);
        btnAgregarPlatillo = (Button)findViewById(R.id.btn_agregar);
        btnMostrarPlatillo = (Button)findViewById(R.id.btn_mostrar);
        txtOrden = (TextView) findViewById(R.id.txt_orden);

        adapter = new ArrayAdapter<String>(this,R.layout.spinner_item,desayunos);
        cmbMenuSeleccionado.setAdapter(adapter);

        cmbMenuSeleccionado.setOnItemSelectedListener(this);
        cmbMenus.setOnItemSelectedListener(this);


        btnAgregarPlatillo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int m = (int)cmbMenus.getSelectedItemId();
                int p = (int)cmbMenuSeleccionado.getSelectedItemId();
                MenuItem menuItem = null;
                switch(m) {//tipo de menu
                    case 0://desayunos
                        switch (p) {//tipo platillo
                            case 0://huevos a la mexicana
                                menuItem = new MenuItem("Huevos a la mexicana",
                                        "Huevos estrellados con salsa verde", false, 25.0);
                                break;
                            case 1://Chilaquiles
                                menuItem = new MenuItem("Chilaquiles", "Chilaquiles en salsa roja",
                                        true, 20.0);
                                break;
                        }//fin del switch desayunos
                        desayunosMenu.add(menuItem);
                        Toast.makeText(getApplicationContext(),"Se agrego platillo",Toast.LENGTH_SHORT).show();
                        break;
                    case 1://Comidas
                        switch (p) {
                            case 0://Chiles rellenos
                                menuItem = new MenuItem("Chiles rellenos",
                                        "Chiles rellenos de queso panela", true, 25.0);
                                break;
                            case 1://Pollo empanizado
                                menuItem = new MenuItem("Pollo empanizado",
                                        "Milanesa de pollo con papas", false, 40.0);
                                break;
                        }//fin del switch comidas
                        comidasMenu.add(menuItem);
                        Toast.makeText(getApplicationContext(),"Se agrego platillo",Toast.LENGTH_SHORT).show();
                        break;
                    case 2://Cena
                        switch (p) {
                            case 0://Tacos al pastor
                                menuItem = new MenuItem("Tacos al Pastor", "Orden de 4 tacos", false, 24.0);
                                break;
                            case 1://Quesadillas
                                menuItem = new MenuItem("Quesadillas",
                                        "Orden de 2 quesadillas de flor de calabaza", true, 20.0);
                                break;
                        }//fin del switch cena
                        cenasMenu.add(menuItem);
                        Toast.makeText(getApplicationContext(),"Se agrego platillo",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        btnMostrarPlatillo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                allMenus.add(desayunosMenu);
                allMenus.add(comidasMenu);
                allMenus.add(cenasMenu);
               // Toast.makeText(getApplicationContext(),allMenus.print(),
                //        Toast.LENGTH_LONG).show();
                txtOrden.setText(allMenus.print());//<----
            }
        });
    }



    @Override
    public void onItemSelected(AdapterView<?>adapterView, View view, int position, long id) {
        int m=0;//menu
        if(adapterView.getId()==R.id.cmb_menus){//Primer menu
            m=(int)cmbMenus.getSelectedItemId();
            switch ((int)cmbMenus.getSelectedItemId()){
                case 0:
                    adapter = new ArrayAdapter<String>(this,R.layout.spinner_item,desayunos);
                    cmbMenuSeleccionado.setAdapter(adapter);
                    break;
                case 1:
                    adapter = new ArrayAdapter<String>(this,R.layout.spinner_item,comidas);
                    cmbMenuSeleccionado.setAdapter(adapter);
                    break;
                case 2:
                    adapter = new ArrayAdapter<String>(this,R.layout.spinner_item,cena);
                    cmbMenuSeleccionado.setAdapter(adapter);
                    break;
            }

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
