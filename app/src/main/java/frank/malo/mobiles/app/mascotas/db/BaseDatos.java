package frank.malo.mobiles.app.mascotas.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import frank.malo.mobiles.app.mascotas.R;
import frank.malo.mobiles.app.mascotas.pojo.Mascota;

/**
 * Created by Frank on 28/09/2016.
 */

public class BaseDatos extends SQLiteOpenHelper{

    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String queryCrearTablaMascota = "CREATE TABLE " +  ConstantesBaseDatos.TABLE_MASCOTA + "( " +
                ConstantesBaseDatos.TABLE_MASCOTA_ID + " INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE, " +
                ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE + " TEXT NOT NULL, "+
                ConstantesBaseDatos.TABLE_MASCOTA_FOTO + " INTEGER NOT NULL, "+
                ConstantesBaseDatos.TABLE_MASCOTA_PUNTAJE + " INTEGER NOT NULL  DEFAULT 0 "+
                ")";

        db.execSQL(queryCrearTablaMascota);

        if (estaTablaMascotaVacia(db)){
            insertarDatosIniciales(db);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_MASCOTA);
        onCreate(db);
    }

    public boolean estaTablaMascotaVacia(SQLiteDatabase db){
        String query = "SELECT count(*) FROM " + ConstantesBaseDatos.TABLE_MASCOTA;
        int cantidad = 0;
        Cursor registros = db.rawQuery(query, null);
        if (registros.moveToNext()){
            cantidad = registros.getInt(0);
        }
        //db.close();
        return (cantidad <= 0);
    }

    public void insertarDatosIniciales(SQLiteDatabase db){

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Lucky");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.perro1);
        db.insert(ConstantesBaseDatos.TABLE_MASCOTA, null, contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "bola de nieve");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.gato1);
        db.insert(ConstantesBaseDatos.TABLE_MASCOTA, null, contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Firulo");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.perro2);
        db.insert(ConstantesBaseDatos.TABLE_MASCOTA, null, contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Silvestre");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.gato2);
        db.insert(ConstantesBaseDatos.TABLE_MASCOTA, null, contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Toba");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.perro3);
        db.insert(ConstantesBaseDatos.TABLE_MASCOTA, null, contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Nikita");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.gato3);
        db.insert(ConstantesBaseDatos.TABLE_MASCOTA, null, contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Lycan");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.perro4);
        db.insert(ConstantesBaseDatos.TABLE_MASCOTA, null, contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Sombra");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.gato4);
        db.insert(ConstantesBaseDatos.TABLE_MASCOTA, null, contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Sultán");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.perro5);
        db.insert(ConstantesBaseDatos.TABLE_MASCOTA, null, contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Spencer");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.perro6);
        db.insert(ConstantesBaseDatos.TABLE_MASCOTA, null, contentValues);

        //db.close();
    }

}
