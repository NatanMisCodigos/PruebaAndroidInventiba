package co.com.inventiba.mobile.pruebaandroidinventiba.presenter;

import android.content.Context;

import co.com.inventiba.mobile.pruebaandroidinventiba.interfaces.PruebaInterfaces;
import co.com.inventiba.mobile.pruebaandroidinventiba.model.Interactor;
import co.com.inventiba.mobile.pruebaandroidinventiba.model.RecyclerAdapter;

public class Presenter implements PruebaInterfaces.Presenter {

    PruebaInterfaces.View view;
    PruebaInterfaces.Interactor interactor;

    public Presenter(PruebaInterfaces.View view, Context context) {
        this.view = view;
        this.interactor = new Interactor(this, context);
    }


    @Override
    public void getListJson() {
        if(interactor != null)
            interactor.getListJson();
    }

    @Override
    public void showListJson(RecyclerAdapter adapter) {
        if(view != null)
            view.showListJson(adapter);
    }
}
