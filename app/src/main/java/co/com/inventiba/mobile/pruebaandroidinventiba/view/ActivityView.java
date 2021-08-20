package co.com.inventiba.mobile.pruebaandroidinventiba.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.airbnb.lottie.LottieAnimationView;

import co.com.inventiba.mobile.pruebaandroidinventiba.R;
import co.com.inventiba.mobile.pruebaandroidinventiba.Utilidades;

public class ActivityView extends AppCompatActivity implements View.OnClickListener {

    // Trato de implementar SingleActivity *

    // Otras variables
    private Utilidades utilidades;

    // Elementos para la pantalla de logueo
    private ConstraintLayout pantallaLogueo;
    private LottieAnimationView imagenUsuarioLogueo;
    private EditText campoEmailLogueo, campoClaveLogueo;
    private Button butonSignIn;

    // Elementos para la pantalla principal o de menu
    private ConstraintLayout pantallaPrincipal;
    private LinearLayout accionListar, accionAgregar;
    private ImageView principalSignOut;

    // Elementos para la pantalla de listado
    private ConstraintLayout pantallaListado;
    private ImageView listadoAPrincipal, listadoSignOut;
    private RecyclerView recyclerList;

    // Elementos para la pantalla de agregar
    private ConstraintLayout pantallaAgregar;
    private ImageView agregarAPrincipal, agregarSignOut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        initItems();
    }

    /**********************************************
     * Con este metodo enlazo todos los elementos
     * visuales
     * *******************************************/

    private void initItems(){
        // Elementos de la ventana de logueo
        pantallaLogueo = findViewById(R.id.pantalla_logueo);
        imagenUsuarioLogueo = findViewById(R.id.imagen_usuario);
        campoEmailLogueo = findViewById(R.id.campo_email);
        campoClaveLogueo = findViewById(R.id.campo_clave);
        butonSignIn = findViewById(R.id.buton_signin);
        butonSignIn.setOnClickListener(this);
        // Elementos de la ventana principal o de menu
        pantallaPrincipal = findViewById(R.id.pantalla_principal);
        principalSignOut = findViewById(R.id.principal_signout);
        principalSignOut.setOnClickListener(this);
        accionListar = findViewById(R.id.accion_ver_lista);
        accionListar.setOnClickListener(this);
        accionAgregar = findViewById(R.id.accion_agregar);
        accionAgregar.setOnClickListener(this);
        // Elementos de la ventana del listado
        pantallaListado = findViewById(R.id.pantalla_listado);
        listadoAPrincipal = findViewById(R.id.listado_a_principal);
        listadoAPrincipal.setOnClickListener(this);
        listadoSignOut = findViewById(R.id.listado_signout);
        listadoSignOut.setOnClickListener(this);
        recyclerList = findViewById(R.id.recycler_list);
        // Elementos de la ventana agregar
        pantallaAgregar = findViewById(R.id.pantalla_agregar);
        agregarAPrincipal = findViewById(R.id.agregar_a_principal);
        agregarAPrincipal.setOnClickListener(this);
        agregarSignOut = findViewById(R.id.agregar_signout);
        agregarSignOut.setOnClickListener(this);
    }

    /**********************************************
     * Con este metodo valido:
     * - Que el campo email cumpla con el formato
     * - Que el campo email no este vacio
     * - Que el campo clave no este vacio
     * - Que la clave coincida con "1234"
     * *******************************************/

    private void validarCamposLogueo(){
        if(campoEmailLogueo.getText().toString().trim().isEmpty()){
            campoEmailLogueo.setError("El campo esta vacio");
            return;
        }
        // Validar que sea correo valido
        if(campoClaveLogueo.getText().toString().trim().isEmpty()){
            campoClaveLogueo.setError("El campo esta vacio");
            return;
        }
        if(!campoClaveLogueo.getText().toString().trim().equals("1234")){
            campoClaveLogueo.setError("La clave es incorrecta");
            return;
        }
        irVentanaPrincipal();
        campoEmailLogueo.setText("");
        campoClaveLogueo.setText("");
    }

    /**********************************************
     * Con este metodo oculto la pantalla de logueo
     * y muestro la ventana principal
     * *******************************************/

    private void irVentanaPrincipal(){
        pantallaLogueo.setVisibility(View.GONE);
        pantallaAgregar.setVisibility(View.GONE);
        pantallaListado.setVisibility(View.GONE);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pantallaPrincipal.setVisibility(View.VISIBLE);
    }

    /**********************************************
     * Con este metodo oculto las ventanas
     * excepto la de listar
     * *******************************************/

    private void irVentanaListar(){
        pantallaLogueo.setVisibility(View.GONE);
        pantallaPrincipal.setVisibility(View.GONE);
        pantallaAgregar.setVisibility(View.GONE);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pantallaListado.setVisibility(View.VISIBLE);
    }

    /**********************************************
     * Con este metodo oculto las ventanas excepto
     * la de agregar
     * *******************************************/

    private void irVentanaAgregar(){
        pantallaLogueo.setVisibility(View.GONE);
        pantallaPrincipal.setVisibility(View.GONE);
        pantallaListado.setVisibility(View.GONE);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pantallaAgregar.setVisibility(View.VISIBLE);
    }

    /**********************************************
     * Con este metodo simulo un deslogueo
     * *******************************************/

    private void signOut(){
        pantallaAgregar.setVisibility(View.GONE);
        pantallaPrincipal.setVisibility(View.GONE);
        pantallaListado.setVisibility(View.GONE);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pantallaLogueo.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.accion_ver_lista:
                irVentanaListar();
                break;
            case R.id.accion_agregar:
                irVentanaAgregar();
                break;
            case R.id.listado_a_principal:
                irVentanaPrincipal();
                break;
            case R.id.listado_signout:
                signOut();
                break;
            case R.id.agregar_a_principal:
                irVentanaPrincipal();
                break;
            case R.id.agregar_signout:
                signOut();
                break;
            case R.id.buton_signin:
                validarCamposLogueo();
                break;
            case R.id.principal_signout:
                signOut();
                break;
            default:
                break;
        }
    }
}