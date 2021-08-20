package co.com.inventiba.mobile.pruebaandroidinventiba;

import android.widget.EditText;

public class Utilidades {

    public boolean esCampoVacio(EditText campo){
        if(campo.getText().toString().trim().length() == 0)
            return true;
        else
            return false;
    }

}
