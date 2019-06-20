package a.a209.proyectofinal;

        import android.content.Context;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;


public class Bases_de_datos extends SQLiteOpenHelper  {

    String tabla = "CREATE TABLE TBLEMPLEADOS (EMAIL STRING PRIMARY KEY, NAME TEXT, PASSWORD TEXT)";

    public Bases_de_datos(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }
    public void onCreate(SQLiteDatabase db){
        db.execSQL(tabla);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE TBLEMPLEADOS");
        db.execSQL(tabla);
    }
}

