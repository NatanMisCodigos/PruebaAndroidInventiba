package co.com.inventiba.mobile.pruebaandroidinventiba.interfaces;

import java.util.List;
import co.com.inventiba.mobile.pruebaandroidinventiba.model.ListModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonApi {

    @GET("todos/")
    Call<List<ListModel>> getListModel();

}
