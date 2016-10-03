package frank.malo.mobiles.app.mascotas.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import frank.malo.mobiles.app.mascotas.pojo.Mascota;
import frank.malo.mobiles.app.mascotas.pojo.Usuario;

/**
 * Created by Frank on 28/09/2016.
 */

public class UsuarioBD {

    private Context context;
    private BaseDatos baseDatos;

    public UsuarioBD(Context context) {
        this.context = context;
        this.baseDatos = new BaseDatos(this.context);
    }

    public ArrayList<Usuario> obtenerTodosUsuarios(){
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_USUARIO;
        SQLiteDatabase db = this.baseDatos.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);
        usuarios = deRegistrosAUsuarios(registros);
        db.close();
        return usuarios;
    }

    private ArrayList<Usuario> deRegistrosAUsuarios(Cursor registros){
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        while(registros.moveToNext()){
            Usuario usuarioActual = new Usuario();
            usuarioActual.setId(registros.getString(0));
            usuarioActual.setNombre(registros.getString(1));
            usuarios.add(usuarioActual);
        }
        return usuarios;
    }

    public Usuario obtenerUsuarioPorNombre(String usuarioNombre){
        Usuario usuario = null;
        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_USUARIO + " WHERE " + ConstantesBaseDatos.TABLE_USUARIO_USUARIO + " = '" + usuarioNombre+ "'";
        SQLiteDatabase db = this.baseDatos.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);
        if (registros.moveToNext()){
            usuario = new Usuario();
            usuario.setId(registros.getString(0));
            usuario.setNombre(registros.getString(1));
        }
        db.close();
        return usuario;
    }





/*
String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTA + " WHERE " + ConstantesBaseDatos.TABLE_MASCOTA_ID + " = " + mascota.getId();
        Cursor dato_mascota = db.rawQuery(query, null);
        if (dato_mascota.moveToNext()){
            mascota.setPuntaje(dato_mascota.getInt(3));
        }

        db.close();


    public ArrayList<Mascota> obtener5MejoresMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
        String query = "SELECT * FROM "+ ConstantesBaseDatos.TABLE_MASCOTA +" ORDER BY "+ ConstantesBaseDatos.TABLE_MASCOTA_PUNTAJE +" DESC LIMIT 5";
        SQLiteDatabase db = this.baseDatos.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);
        mascotas = deRegistrosAMascotas(registros);
        db.close();
        return mascotas;
    }

    private ArrayList<Mascota> deRegistrosAMascotas(Cursor registros){
        ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
        while(registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));
            mascotaActual.setPuntaje(registros.getInt(3));
            mascotas.add(mascotaActual);
        }
        return mascotas;
    }

    public void puntuarMascota(Mascota mascota){
        SQLiteDatabase db = this.baseDatos.getWritableDatabase();
        String queryActualizarPuntajeTablaMascota = "UPDATE " + ConstantesBaseDatos.TABLE_MASCOTA +
                " SET " + ConstantesBaseDatos.TABLE_MASCOTA_PUNTAJE + " = " + ConstantesBaseDatos.TABLE_MASCOTA_PUNTAJE + "+1 " +
                "WHERE " + ConstantesBaseDatos.TABLE_MASCOTA_ID + "=" + Integer.toString(mascota.getId());

        db.execSQL(queryActualizarPuntajeTablaMascota);

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTA + " WHERE " + ConstantesBaseDatos.TABLE_MASCOTA_ID + " = " + mascota.getId();
        Cursor dato_mascota = db.rawQuery(query, null);
        if (dato_mascota.moveToNext()){
            mascota.setPuntaje(dato_mascota.getInt(3));
        }

        db.close();
    }*/
}
