package frank.malo.mobiles.app.mascotas.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import frank.malo.mobiles.app.mascotas.R;
import frank.malo.mobiles.app.mascotas.db.BaseDatos;
import frank.malo.mobiles.app.mascotas.db.UsuarioBD;
import frank.malo.mobiles.app.mascotas.pojo.Usuario;

public class ConfiguracionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.toolbar_principal);
        miActionBar.setTitle("");
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ImageView img5Stars = (ImageView) findViewById(R.id.img5Stars);
        img5Stars.setVisibility(ImageView.GONE);
    }


    public void guardarConfiguracion(View v){


        EditText edtUsuario = (EditText) findViewById(R.id.etUsuario);

        UsuarioBD usuarioBD = new UsuarioBD(this);
        Usuario usuario = usuarioBD.obtenerUsuarioPorNombre(edtUsuario.getText().toString().toLowerCase());

        if (usuario != null){
            SharedPreferences miPreferenciaCompartida = getSharedPreferences("usuario", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = miPreferenciaCompartida.edit();
            editor.putString("nombre", usuario.getNombre());
            editor.putString("id", usuario.getId());
            editor.commit();
            Intent intentPrincipal = new Intent(this, MainActivity.class);
            startActivity(intentPrincipal);
        }else{
            Toast.makeText(this, "No se ha encontrado el usuario en la base de datos", Toast.LENGTH_LONG).show();
        }
    }
}
