package frank.malo.mobiles.app.mascotas.adaptadores;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import frank.malo.mobiles.app.mascotas.R;
import frank.malo.mobiles.app.mascotas.pojo.Mascota;
import frank.malo.mobiles.app.mascotas.pojo.Perfil;

/**
 * Created by Frank on 20/09/2016.
 */
public class PerfilAdaptador extends RecyclerView.Adapter<PerfilAdaptador.PerfilViewHolder> {
    Perfil perfil;
    Activity activity;
    private int idCardView;

    public PerfilAdaptador(Perfil perfil, Activity activity) {
        this.perfil = perfil;
        this.activity = activity;
    }

    @Override
    public PerfilViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mi_mascota, parent, false);
        return new PerfilViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PerfilViewHolder perfilViewHolder, int position) {
        final Mascota mascota = perfil.getMascotas().get(position);
        Picasso.with(activity)
                .load(mascota.getUrlFoto())
                .placeholder(R.drawable.ic_dog)
                .into(perfilViewHolder.imgFotoCV);
        perfilViewHolder.tvRatingCV.setText(String.valueOf(mascota.getPuntaje()));
    }

    @Override
    public int getItemCount() {
        return perfil.getMascotas().size();
    }

    public static class PerfilViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFotoCV;
        private TextView tvRatingCV;

        public PerfilViewHolder(View itemView) {
            super(itemView);
            imgFotoCV = (ImageView) itemView.findViewById(R.id.imgFotoCV);
            tvRatingCV = (TextView) itemView.findViewById(R.id.tvRatingCV);
        }
    }

}
