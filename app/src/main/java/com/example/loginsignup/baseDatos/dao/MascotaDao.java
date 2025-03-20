package com.example.loginsignup.baseDatos.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import com.example.loginsignup.baseDatos.entidades.Mascota;

@Dao
public interface MascotaDao {
    @Insert
    long insertarMascota(Mascota mascota);

    @Update
    void actualizarMascota(Mascota mascota);

    @Delete
    void eliminarMascota(Mascota mascota);

    @Query("SELECT * FROM mascotas WHERE id_dueño = :idUsuario")
    List<Mascota> obtenerMascotasDeUsuario(int idUsuario);

    @Query("SELECT * FROM mascotas WHERE id_mascota = :idMascota")
    Mascota obtenerMascotaPorId(int idMascota);

    @Query("SELECT * FROM mascotas WHERE id_enfermedad IS NOT NULL")
    List<Mascota> obtenerMascotasConEnfermedad();

    @Query("UPDATE mascotas SET id_enfermedad = :idEnfermedad WHERE id_mascota = :idMascota")
    void asignarEnfermedadAMascota(int idMascota, int idEnfermedad);
}
