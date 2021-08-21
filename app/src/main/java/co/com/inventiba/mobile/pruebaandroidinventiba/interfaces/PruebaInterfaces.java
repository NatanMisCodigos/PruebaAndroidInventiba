package co.com.inventiba.mobile.pruebaandroidinventiba.interfaces;

import co.com.inventiba.mobile.pruebaandroidinventiba.model.RecyclerAdapter;

public interface PruebaInterfaces {

    interface View{
        void showListJson(RecyclerAdapter adapter);
    }

    interface Interactor{
        void getListJson();
    }

    interface Presenter{
        void getListJson();
        void showListJson(RecyclerAdapter adapter);
    }

}
