package com.example.loginsignup;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class Signup_Form extends AppCompatActivity {

    private EditText editTextFullName, editTextUserName, editTextEmail, editTextPassword, editTextConfirmPassword, editTextStreet, editTextBirthDate;
    private Spinner roleSpinner;
    private RadioGroup genderRadioGroup;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_form);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Formulario de registro");
        }

        // Inicialización de vistas
        editTextFullName = findViewById(R.id.editTextFullName);
        editTextUserName = findViewById(R.id.editTextUserName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword);
        editTextStreet = findViewById(R.id.editTextStreet);
        editTextBirthDate = findViewById(R.id.editTextBirthDate);
        roleSpinner = findViewById(R.id.roleSpinner);
        genderRadioGroup = findViewById(R.id.radioGroupGender);
        registerButton = findViewById(R.id.registerButton);

        // Configurar Spinner de roles
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.role_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        roleSpinner.setAdapter(adapter);

        // Configurar selector de fecha
        editTextBirthDate.setOnClickListener(v -> seleccionarFecha());

        // Configurar el botón de registro
        registerButton.setOnClickListener(v -> validarFormulario());
    }

    // Método para validar y registrar usuario
    private void validarFormulario() {
        String fullName = editTextFullName.getText().toString().trim();
        String userName = editTextUserName.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String confirmPassword = editTextConfirmPassword.getText().toString().trim();
        String street = editTextStreet.getText().toString().trim();
        String birthDate = editTextBirthDate.getText().toString().trim();
        String role = roleSpinner.getSelectedItem().toString();
        String gender = getSelectedGender();

        // Validar que todos los campos estén llenos
        if (TextUtils.isEmpty(fullName) || TextUtils.isEmpty(userName) || TextUtils.isEmpty(email) ||
                TextUtils.isEmpty(password) || TextUtils.isEmpty(confirmPassword) || TextUtils.isEmpty(street) ||
                TextUtils.isEmpty(birthDate) || TextUtils.isEmpty(role) || TextUtils.isEmpty(gender)) {
            Toast.makeText(this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show();
            return;
        }

        // Validar que las contraseñas coincidan
        if (!password.equals(confirmPassword)) {
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
            return;
        }

        // Validar formato de correo
        if (!isValidEmail(email)) {
            Toast.makeText(this, "Correo inválido. Debe contener @gmail.com u otro dominio válido", Toast.LENGTH_SHORT).show();
            return;
        }

        // Si pasa todas las validaciones, registrar usuario (por ahora, solo mostrar mensaje)
        Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();

        // Limpiar los campos después del registro
        limpiarCampos();
    }

    // Método para verificar si un correo tiene un formato válido
    private boolean isValidEmail(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    // Método para limpiar los campos después de un registro exitoso
    private void limpiarCampos() {
        editTextFullName.setText("");
        editTextUserName.setText("");
        editTextEmail.setText("");
        editTextPassword.setText("");
        editTextConfirmPassword.setText("");
        editTextStreet.setText("");
        editTextBirthDate.setText("");
        roleSpinner.setSelection(0);
        genderRadioGroup.clearCheck();
    }

    // Método para seleccionar fecha de nacimiento
    private void seleccionarFecha() {
        Calendar calendario = Calendar.getInstance();
        int año = calendario.get(Calendar.YEAR);
        int mes = calendario.get(Calendar.MONTH);
        int dia = calendario.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, (view, selectedYear, selectedMonth, selectedDayOfMonth) -> {
            if (!validarEdad(selectedYear, selectedMonth, selectedDayOfMonth)) {
                Toast.makeText(this, "Debes tener más de 18 años", Toast.LENGTH_SHORT).show();
            } else {
                editTextBirthDate.setText(selectedDayOfMonth + "/" + (selectedMonth + 1) + "/" + selectedYear);
            }
        }, año, mes, dia);

        datePickerDialog.show();
    }

    // Validar si la persona tiene al menos 18 años
    private boolean validarEdad(int año, int mes, int dia) {
        Calendar today = Calendar.getInstance();
        int age = today.get(Calendar.YEAR) - año;

        if (mes > today.get(Calendar.MONTH) || (mes == today.get(Calendar.MONTH) && dia > today.get(Calendar.DAY_OF_MONTH))) {
            age--;
        }

        return age >= 18;
    }

    // Método para obtener el género seleccionado
    private String getSelectedGender() {
        int selectedId = genderRadioGroup.getCheckedRadioButtonId();
        if (selectedId != -1) {
            RadioButton selectedRadioButton = findViewById(selectedId);
            return selectedRadioButton.getText().toString();
        } else {
            return "";
        }
    }
}
