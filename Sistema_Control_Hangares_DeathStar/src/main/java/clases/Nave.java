/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import jakarta.persistence.*;
import java.io.Serializable;
/**
 *
 * @author DAM2P
 */

@Entity
@Table(name = "naves")
public class Nave implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nombre_id")
    private String nombre;
    
    @Column(name = "mdoelo", length = 50)
    private String modelo;
    
    @Column(name = "capacidad_pasajeros")
    private int capacidadPasajeros;
    
    @Column(name = "estado_sistema", length = 20)
    private String estadoSistema;

    
    public Nave() {
    }

    public Nave(String nombre, String modelo, int capacidadPasajeros, String estadoSistema) {
        this.nombre = nombre;
        this.modelo = modelo;
        this.capacidadPasajeros = capacidadPasajeros;
        this.estadoSistema = estadoSistema;
    }
    
    
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the capacidadPasajeros
     */
    public int getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    /**
     * @param capacidadPasajeros the capacidadPasajeros to set
     */
    public void setCapacidadPasajeros(int capacidadPasajeros) {
        this.capacidadPasajeros = capacidadPasajeros;
    }

    /**
     * @return the estadoSistema
     */
    public String getEstadoSistema() {
        return estadoSistema;
    }

    /**
     * @param estadoSistema the estadoSistema to set
     */
    public void setEstadoSistema(String estadoSistema) {
        this.estadoSistema = estadoSistema;
    }
    
    
    
    @Override
    public String toString(){
        return "Nombre: " + nombre + " (" + modelo + ") | Estado: " + estadoSistema + " | Capacidad: " + capacidadPasajeros;
    }
}
