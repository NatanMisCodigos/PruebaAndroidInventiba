package co.com.inventiba.mobile.pruebaandroidinventiba.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import co.com.inventiba.mobile.pruebaandroidinventiba.R;
import co.com.inventiba.mobile.pruebaandroidinventiba.Utilidades;

public class ActivityView extends AppCompatActivity {

    // Trato de implementar SingleActivity *

    // Otras variables
    private Utilidades utilidades;

    // Elementos para la pantalla de logueo.
    private ConstraintLayout pantallaLogueo;
    private LottieAnimationView imagenUsuarioLogueo;
    private EditText campoEmailLogueo, campoClaveLogueo;


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
        pantallaLogueo = findViewById(R.id.pantalla_logueo);
        imagenUsuarioLogueo = findViewById(R.id.imagen_usuario);
        campoEmailLogueo = findViewById(R.id.campo_email);
        campoClaveLogueo = findViewById(R.id.campo_clave);
    }

    /**********************************************
     * Con este metodo valido:
     * - Que el campo email cumpla con el formato
     * - Que el campo email no este vacio
     * - Que el campo clave no este vacio
     * - Que la clave coincida con "1234"
     * *******************************************/

    private void validarCamposLogueo(View view){
        if(utilidades.esCampoVacio(campoEmailLogueo)){
            campoEmailLogueo.setError("El campo esta vacio");
            return;
        }
        // Validar que sea correo valido
        if(utilidades.esCampoVacio(campoClaveLogueo)){
            campoClaveLogueo.setError("El campo esta vacio");
            return;
        }
        if(!campoClaveLogueo.getText().toString().trim().equals("1234")){
            campoClaveLogueo.setError("La clave es incorrecta");
            return;
        }

        usuarioLogueado();

    }

    /**********************************************
     * Con este metodo oculto la pantalla de logueo
     * y muestro la ventana principal
     * *******************************************/

    private void usuarioLogueado(){
        pantallaLogueo.setVisibility(View.GONE);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}