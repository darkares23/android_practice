package a.a209.proyectofinal;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etCorreo, etClave;
    Button btnIniciar, btnRegistrarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        etCorreo = findViewById(R.id.etCorreo);
        etClave = findViewById(R.id.etClave);

        btnIniciar = findViewById(R.id.btnIniciar);
        btnRegistrarse = findViewById(R.id.btnRegistrarse);

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciar(etCorreo.getText().toString(),
                        etClave.getText().toString());
            }
        });

        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Main3Activity.class));
            }
        });
    }

    private void iniciar(String correo, String clave){

        Bases_de_datos helper = new Bases_de_datos(this, "BDEMPLEADOS", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        try {

            String sqlComand = "SELECT * FROM TBLEMPLEADOS WHERE EMAIL=? AND PASSWORD=?";
            String[] args = {correo, clave};
            Cursor c = db.rawQuery(sqlComand,  args);
            if (c.moveToFirst()){
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
            } else
            {
                Toast.makeText(this,"Correo o Contraseña INVALIDOS", Toast.LENGTH_SHORT).show();
            }
            db.close();
        }
        catch (Exception e){
            Toast.makeText(this, "ERROR101: "+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

}
