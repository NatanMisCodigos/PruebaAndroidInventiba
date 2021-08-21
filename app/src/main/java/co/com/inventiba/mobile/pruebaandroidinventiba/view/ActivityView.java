package co.com.inventiba.mobile.pruebaandroidinventiba.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

import co.com.inventiba.mobile.pruebaandroidinventiba.R;
import co.com.inventiba.mobile.pruebaandroidinventiba.Utilidades;
import co.com.inventiba.mobile.pruebaandroidinventiba.interfaces.PruebaInterfaces;
import co.com.inventiba.mobile.pruebaandroidinventiba.model.RecyclerAdapter;
import co.com.inventiba.mobile.pruebaandroidinventiba.presenter.Presenter;

public class ActivityView extends AppCompatActivity implements View.OnClickListener, PruebaInterfaces.View {

    // Trato de implementar SingleActivity *

    // Otras variables
    private Utilidades utilidades;
    private Context context = this;
    private RecyclerAdapter recyclerAdapter;
    private PruebaInterfaces.Presenter presenter = new Presenter(this, context);

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
    private EditText campoIdAgregar, campoTituloAgregar;
    private ImageView accionAgregarElemento;


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
        campoIdAgregar = findViewById(R.id.agregar_campo_id);
        campoTituloAgregar = findViewById(R.id.agregar_campo_title);
        accionAgregarElemento = findViewById(R.id.accion_agregar_elemento);
        accionAgregarElemento.setOnClickListener(this);
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
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                pantallaPrincipal.setVisibility(View.VISIBLE);
            }
        }, 800);
    }

    /**********************************************
     * Con este metodo oculto las ventanas
     * excepto la de listar
     * *******************************************/

    private void irVentanaListar(){
        // Con esta validacion me aseguro de consumir el servicio solo una vez
        if(recyclerAdapter != null){
            showListJson(recyclerAdapter);
        }else{
            presenter.getListJson();
        }
        pantallaLogueo.setVisibility(View.GONE);
        pantallaPrincipal.setVisibility(View.GONE);
        pantallaAgregar.setVisibility(View.GONE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                pantallaListado.setVisibility(View.VISIBLE);
            }
        }, 800);
    }

    /**********************************************
     * Con este metodo oculto las ventanas excepto
     * la de agregar
     * *******************************************/

    private void irVentanaAgregar(){
        pantallaLogueo.setVisibility(View.GONE);
        pantallaPrincipal.setVisibility(View.GONE);
        pantallaListado.setVisibility(View.GONE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                pantallaAgregar.setVisibility(View.VISIBLE);
            }
        }, 800);
    }

    /**********************************************
     * Con este metodo simulo un deslogueo
     * *******************************************/

    private void validarCamposAgregar(){
        if(campoIdAgregar.getText().toString().trim().isEmpty()){
            campoIdAgregar.setError("El campo esta vacio");
            return;
        }
        if(campoTituloAgregar.getText().toString().trim().isEmpty()){
            campoTituloAgregar.setError("El campo esta vacio");
            return;
        }
        irVentanaPrincipal();
        campoIdAgregar.setText("");
        campoTituloAgregar.setText("");
        Toast.makeText(context, "El elemento ha sido agregado a la lista", Toast.LENGTH_SHORT).show();
    }

    /**********************************************
     * Con este metodo simulo un deslogueo
     * *******************************************/

    private void signOut(){
        pantallaAgregar.setVisibility(View.GONE);
        pantallaPrincipal.setVisibility(View.GONE);
        pantallaListado.setVisibility(View.GONE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                pantallaLogueo.setVisibility(View.VISIBLE);
                campoEmailLogueo.requestFocus();
            }
        }, 800);
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
            case R.id.accion_agregar_elemento:
                validarCamposAgregar();
                break;
            default:
                break;
        }
    }

    @Override
    public void showListJson(RecyclerAdapter adapter) {
        recyclerList.setLayoutManager(new LinearLayoutManager(context));
        // Con esta validacion me aseguro de saber si el adaptador ya fue llenado antes
        if(recyclerAdapter != null){
            recyclerList.setAdapter(recyclerAdapter);
        }else{
            recyclerAdapter = adapter;
            recyclerList.setAdapter(recyclerAdapter);
        }
    }
}