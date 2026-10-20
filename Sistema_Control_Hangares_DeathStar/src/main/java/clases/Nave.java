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
    @Column(name = "id_nave")
    private int id;
    
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    
    @Column(name = "mdoelo", nullable = false, length = 50)
    private String modelo;
    
    @Column(name = "capacidad_pasajeros", nullable = false)
    private int capacidadPasajeros;
    
    @Column(name = "estado_sistema", nullable = false, length = 20)
    private String estadoSistema;

    
    public Nave() {
    }

    
    public Nave(int id, String nombre, String modelo, int capacidadPasajeros, String estadoSistema) {
        this.id = id;
        this.nombre = nombre;
        this.modelo = modelo;
        this.capacidadPasajeros = capacidadPasajeros;
        this.estadoSistema = estadoSistema;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
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
        return "ID: " + id + " | Nombre: " + nombre + " (" + modelo + ") | Estado: " + estadoSistema;
    }
}
