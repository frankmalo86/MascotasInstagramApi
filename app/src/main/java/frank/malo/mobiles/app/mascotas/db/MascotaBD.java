package frank.malo.mobiles.app.mascotas.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import frank.malo.mobiles.app.mascotas.pojo.Mascota;

/**
 * Created by Frank on 28/09/2016.
 */

public class MascotaBD {

    private Context context;
    private BaseDatos baseDatos;


    public MascotaBD(Context context) {
        this.context = context;
        this.baseDatos = new BaseDatos(this.context);
    }


    public ArrayList<Mascota> obtenerTodasMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTA;
        SQLiteDatabase db = this.baseDatos.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);
        mascotas = deRegistrosAMascotas(registros);
        db.close();
        return mascotas;
    }


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
        /*ContentValues valores = new ContentValues();
        valores.put(ConstantesBaseDatos.TABLE_MASCOTA_PUNTAJE, ConstantesBaseDatos.TABLE_MASCOTA_PUNTAJE + "+1");
        int registros_afectados = db.update(ConstantesBaseDatos.TABLE_MASCOTA, valores,  ConstantesBaseDatos.TABLE_MASCOTA_ID + " = ?", new String[] {Integer.toString(mascota.getId())});*/

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
    }
}
