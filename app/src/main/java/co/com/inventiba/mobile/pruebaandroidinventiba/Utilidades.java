package co.com.inventiba.mobile.pruebaandroidinventiba;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.view.View;
import android.view.WindowManager;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.emredavarci.noty.Noty;

public class Utilidades {

    public static void hideNotificationBar(Activity activity){
        if (Build.VERSION.SDK_INT > 16) {
            activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
    }

    public static boolean isConnected(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        return false;
    }

    public static void showMessage(Context context, Activity activity, String message){
        ConstraintLayout rl = (ConstraintLayout) activity.findViewById(R.id.layout_principal);
        Noty.init(context, message, rl,
                Noty.WarningStyle.ACTION)
                .setActionText("Entendido")
                .setWarningBoxBgColor("#9999ff")
                .setWarningTappedColor("#b3b3ff")
                .setWarningBoxPosition(Noty.WarningPos.TOP)
                .setWarningBoxRadius(0,0,25,25)
                .setWarningBoxMargins(25,-5,25,0)
                .setAnimation(Noty.RevealAnim.SLIDE_DOWN, Noty.DismissAnim.BACK_TO_TOP, 400,400)
                .show();
    }

}
