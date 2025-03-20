package com.example.loginsignup.actividades;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.loginsignup.R;

public class Login_Form extends AppCompatActivity {

    // Declaramos los campos de correo y contraseña
    private EditText editTextEmail;
    private EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);

        // Inicialización de los campos de correo y contraseña
        editTextEmail = findViewById(R.id.editTextTextEmailAddress);
        editTextPassword = findViewById(R.id.editTextPassword);
    }

    // Método para manejar el clic del botón "Register"

    public void btn_signupForm(View view) {
        startActivity(new Intent(getApplicationContext(), Signup_Form.class));
    }

    public void btn_loginForm(View view) {
        // Obtener los valores de correo y contraseña
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();

        // Verificar si los campos están vacíos
        if (email.isEmpty() || password.isEmpty()) {
            // Si algún campo está vacío, mostrar un mensaje de error
            Toast.makeText(this, "Por favor, ingresa tu correo y contraseña", Toast.LENGTH_SHORT).show();
        } else {
            // Si ambos campos están completos, puedes proceder con la autenticación
            // Aquí puedes agregar tu lógica para verificar las credenciales (por ejemplo, en base de datos o Firebase)

            // Solo un mensaje de prueba por ahora
            Toast.makeText(this, "Login exitoso", Toast.LENGTH_SHORT).show();

            // Si la autenticación es exitosa, navegar a la siguiente actividad
            // Por ejemplo, si quieres ir a la actividad de inicio, puedes hacerlo así:
            // startActivity(new Intent(getApplicationContext(), HomeActivity.class));
        }
    }
}
