package co.com.inventiba.mobile.pruebaandroidinventiba.model;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import co.com.inventiba.mobile.pruebaandroidinventiba.R;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.UserViewHolder> {

    List<ListModel> listModel;
    Context context;

    public RecyclerAdapter(List<ListModel> listModel, Context context) {
        this.listModel = listModel;
        this.context = context;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.list_item, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.bindData(listModel.get(position), context);
    }

    @Override
    public int getItemCount() {
        return listModel.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        ImageView completed;

        public UserViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.item_list_title);
            completed = itemView.findViewById(R.id.item_list_completed);
        }

        void bindData(ListModel listModel, Context context) {
            title.setText(listModel.getTitle());
            if(listModel.isCompleted()){
                String uri = "@drawable/ic_circle_green";
                int imageResource = context.getResources().getIdentifier(uri, null, context.getPackageName());
                Drawable imagen = ContextCompat.getDrawable(context.getApplicationContext(), imageResource);
                completed.setImageDrawable(imagen);
            }
            else {
                String uri = "@drawable/ic_circle_red";
                int imageResource = context.getResources().getIdentifier(uri, null, context.getPackageName());
                Drawable imagen = ContextCompat.getDrawable(context.getApplicationContext(), imageResource);
                completed.setImageDrawable(imagen);
            }
        }
    }
}
