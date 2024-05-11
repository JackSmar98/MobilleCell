package com.example.proyectofinal;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class AuthActivity2 extends AppCompatActivity {
    private TextInputEditText correo, password, nombre, apellido, telefono, pais, confirmPassword;
    private Button login;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth2);

        mAuth = FirebaseAuth.getInstance();

        correo = findViewById(R.id.correo);
        password = findViewById(R.id.password);
        nombre = findViewById(R.id.nombre);
        apellido = findViewById(R.id.apellido);
        telefono = findViewById(R.id.telefono);
        pais = findViewById(R.id.pais);
        confirmPassword = findViewById(R.id.confirm_password);
        login = findViewById(R.id.login);
        progressBar = findViewById(R.id.loading);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String correoTexto = correo.getText().toString();
                String passwordTexto = password.getText().toString();
                String nombreTexto = nombre.getText().toString();
                String apellidoTexto = apellido.getText().toString();
                String telefonoTexto = telefono.getText().toString();
                String paisTexto = pais.getText().toString();
                String confirmPasswordTexto = confirmPassword.getText().toString();

                if (TextUtils.isEmpty(correoTexto) || TextUtils.isEmpty(passwordTexto) || TextUtils.isEmpty(nombreTexto)
                        || TextUtils.isEmpty(apellidoTexto) || TextUtils.isEmpty(telefonoTexto) || TextUtils.isEmpty(paisTexto)
                        || TextUtils.isEmpty(confirmPasswordTexto)) {
                    Toast.makeText(AuthActivity2.this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
                } else {
                    if (passwordTexto.equals(confirmPasswordTexto)) {
                        registerUser(correoTexto, passwordTexto);
                    } else {
                        Toast.makeText(AuthActivity2.this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void registerUser(String correo, String password) {
        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(correo, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressBar.setVisibility(View.GONE);
                        if (task.isSuccessful()) {
                            Toast.makeText(AuthActivity2.this, "Registro exitoso", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(AuthActivity2.this, MainActivity3.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(AuthActivity2.this, "Error al registrar usuario: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
