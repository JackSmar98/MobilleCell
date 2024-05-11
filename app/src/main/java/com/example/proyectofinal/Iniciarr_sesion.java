package com.example.proyectofinal;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Iniciarr_sesion extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private TextInputEditText correoEditText, passwordEditText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciarr_sesion);

        mAuth = FirebaseAuth.getInstance();

        correoEditText = findViewById(R.id.correo);
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.login);

        loginButton.setOnClickListener(v -> signInWithEmailAndPassword());
    }

    private void signInWithEmailAndPassword() {
        String email = correoEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Inicio de sesión exitoso, mostrar mensaje "Si estas registrado"
                            Toast.makeText(Iniciarr_sesion.this, "Si estas registrado", Toast.LENGTH_SHORT).show();
                            // Redireccionar a la actividad principal
                            Intent intent = new Intent(Iniciarr_sesion.this, MainActivity3.class);
                            startActivity(intent);
                            finish();
                        } else {
                            // El inicio de sesión falló, mostrar mensaje "No estas registrado"
                            Log.w("Login", "signInWithEmail:failure", task.getException());
                            Toast.makeText(Iniciarr_sesion.this, "No estas registrado", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
