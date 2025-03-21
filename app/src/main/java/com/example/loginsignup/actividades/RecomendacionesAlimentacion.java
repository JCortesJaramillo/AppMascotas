package com.example.loginsignup.actividades;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.loginsignup.R;

public class RecomendacionesAlimentacion extends AppCompatActivity {

    private Spinner spinnerActividad;
    private Button buttonGenerarRecomendacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recomendaciones_alimentacion);

        // Inicializa las vistas
        spinnerActividad = findViewById(R.id.spinnerActividad);
        buttonGenerarRecomendacion = findViewById(R.id.buttonGenerarRecomendacion);

        // Configura el botón "Generar recomendación"
        buttonGenerarRecomendacion.setOnClickListener(v -> generarRecomendacion());
    }

    // Método para generar la recomendación según la actividad seleccionada
    private void generarRecomendacion() {
        int seleccion = spinnerActividad.getSelectedItemPosition();

        // Dependiendo de la opción seleccionada en el Spinner, mostrar la recomendación
        switch (seleccion) {
            case 0: // "Activo"
                Toast.makeText(this, "Recomendación: Actividad física intensa, consumir más calorías", Toast.LENGTH_SHORT).show();
                break;
            case 1: // "Moderado"
                Toast.makeText(this, "Recomendación: Actividad física moderada, equilibrar calorías", Toast.LENGTH_SHORT).show();
                break;
            case 2: // "Sedentario"
                Toast.makeText(this, "Recomendación: Actividad ligera, evitar el exceso de calorías", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this, "Por favor, selecciona un nivel de actividad", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
