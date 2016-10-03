package frank.malo.mobiles.app.mascotas.adaptadores;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import frank.malo.mobiles.app.mascotas.activities.MainActivity;
import frank.malo.mobiles.app.mascotas.R;
import frank.malo.mobiles.app.mascotas.pojo.Mascota;

/**
 * Created by Frank on 14/09/2016.
 */
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;
    private int idCardView;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    //el holder
    @Override
    public MascotaAdaptador.MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas, parent, false);
        return new MascotaViewHolder(v);
    }

    //el bind
    @Override
    public void onBindViewHolder(final MascotaAdaptador.MascotaViewHolder mascotaViewHolder, int position) {

        final Mascota mascota = mascotas.get(position);
        Picasso.with(activity)
                .load(mascota.getUrlFoto())
                .placeholder(R.drawable.ic_dog)
                .into(mascotaViewHolder.imgFotoCV);
        mascotaViewHolder.tvRatingCV.setText(String.valueOf(mascota.getPuntaje()));
    }

    //el count
    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFotoCV;
        private ImageView imgHuesoBlanco;
        private TextView tvRatingCV;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFotoCV = (ImageView) itemView.findViewById(R.id.imgFotoCV);
            imgHuesoBlanco = (ImageView) itemView.findViewById(R.id.imgHuesoBlanco);
            tvRatingCV = (TextView) itemView.findViewById(R.id.tvRatingCV);
        }
    }

}
