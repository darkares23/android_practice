package a.a209.proyectofinal;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    EditText etCorreo, etNombre, etClave;
    Button btnGuardar, btnIniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        etCorreo = findViewById(R.id.etCorreo);
        etNombre = findViewById(R.id.etNombre);
        etClave = findViewById(R.id.etClave);

        btnGuardar = findViewById(R.id.btnGuardar);
        btnIniciar = findViewById(R.id.btnIniciar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardar(etCorreo.getText().toString(),
                        etNombre.getText().toString(),
                        etClave.getText().toString());
            }
        });

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main3Activity.this, MainActivity.class));
            }
        });
    }

    private void guardar (String email, String userName, String password){
        Bases_de_datos helper = new Bases_de_datos(this, "BDEMPLEADOS", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
            try {
                ContentValues c = new ContentValues();
                c.put("EMAIL", email);
                c.put("NAME", userName);
                c.put("PASSWORD", password);

                db.insert("TBLEMPLEADOS", null, c);
                db.close();
                Toast.makeText(this, "Usuario registrado con éxito", Toast.LENGTH_SHORT).show();
            }
            catch (Exception e){
                Toast.makeText(this, "¡ERROR!: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
    }
}

