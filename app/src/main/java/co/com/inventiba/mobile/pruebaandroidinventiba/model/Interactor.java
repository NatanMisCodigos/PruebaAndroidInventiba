package co.com.inventiba.mobile.pruebaandroidinventiba.model;

import android.content.Context;

import java.util.List;

import co.com.inventiba.mobile.pruebaandroidinventiba.interfaces.PruebaInterfaces;
import co.com.inventiba.mobile.pruebaandroidinventiba.rest.ApiAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Interactor implements PruebaInterfaces.Interactor, Callback<List<ListModel>> {

    private PruebaInterfaces.Presenter presenter;
    private List<ListModel> listApi;
    private Context context;
    private RecyclerAdapter adapter;

    public Interactor(PruebaInterfaces.Presenter presenter, Context context) {
        this.presenter = presenter;
        this.context = context;
    }


    @Override
    public void onResponse(Call<List<ListModel>> call, Response<List<ListModel>> response) {
        System.out.println("MENSAJE: " + response.toString());
        if (response.isSuccessful()) {
            listApi = response.body();
            adapter = new RecyclerAdapter(listApi, context);
            presenter.showListJson(adapter);
        } else {
            System.out.println("RESPUESTA NO SUCCESSFUL: " + response.message());
        }
    }

    @Override
    public void onFailure(Call<List<ListModel>> call, Throwable t) {
        System.out.println("RESPUESTA FAILURE: " + t.getMessage());
    }

    @Override
    public void getListJson() {
        Call<List<ListModel>> call = ApiAdapter.getDataList().getListModel();
        System.out.println("REQUEST: " + call.request().toString());
        call.enqueue(this);
    }
}
