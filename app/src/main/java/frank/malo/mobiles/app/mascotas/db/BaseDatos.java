package frank.malo.mobiles.app.mascotas.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import frank.malo.mobiles.app.mascotas.R;

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

        String queryCrearTablaMascota = "CREATE TABLE " +  ConstantesBaseDatos.TABLE_USUARIO + "( " +
                ConstantesBaseDatos.TABLE_USUARIO_ID + " TEXT PRIMARY KEY NOT NULL  UNIQUE, " +
                ConstantesBaseDatos.TABLE_USUARIO_USUARIO + " TEXT NOT NULL "+
                ")";

        db.execSQL(queryCrearTablaMascota);

        if (estaTablaMascotaVacia(db)){
            insertarDatosIniciales(db);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_USUARIO);
        onCreate(db);
    }

    public boolean estaTablaMascotaVacia(SQLiteDatabase db){
        String query = "SELECT count(*) FROM " + ConstantesBaseDatos.TABLE_USUARIO;
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
        contentValues.put(ConstantesBaseDatos.TABLE_USUARIO_ID, "3992079915");
        contentValues.put(ConstantesBaseDatos.TABLE_USUARIO_USUARIO, "mascotafm");
        db.insert(ConstantesBaseDatos.TABLE_USUARIO, null, contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_USUARIO_ID, "204246429");
        contentValues.put(ConstantesBaseDatos.TABLE_USUARIO_USUARIO, "frank_malo");
        db.insert(ConstantesBaseDatos.TABLE_USUARIO, null, contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_USUARIO_ID, "364048158");
        contentValues.put(ConstantesBaseDatos.TABLE_USUARIO_USUARIO, "prischilan");
        db.insert(ConstantesBaseDatos.TABLE_USUARIO, null, contentValues);

        //db.close();
    }

}
