/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author DAM2P
 */
@Entity
@Table(name = "planetas")
public class Planeta implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "planeta_id")
    private int id;
    
    @Column(name = "nombre_planeta", nullable = false, length = 100)
    private String nombrePlaneta;
    
    @Column(name = "sector_galactico", nullable = false, length = 100)
    private String sectorGalactivo;
    
    @OneToMany(mappedBy = "planeta", cascade = CascadeType.ALL)
    private List<Nave> navesRegistradas = new ArrayList<>();
    

    public Planeta() {
    }

    public Planeta(int id, String nombrePlaneta, String sectorGalactivo) {
        this.id = id;
        this.nombrePlaneta = nombrePlaneta;
        this.sectorGalactivo = sectorGalactivo;
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
     * @return the nombrePlaneta
     */
    public String getNombrePlaneta() {
        return nombrePlaneta;
    }

    /**
     * @param nombrePlaneta the nombrePlaneta to set
     */
    public void setNombrePlaneta(String nombrePlaneta) {
        this.nombrePlaneta = nombrePlaneta;
    }

    /**
     * @return the sectorGalactivo
     */
    public String getSectorGalactivo() {
        return sectorGalactivo;
    }

    /**
     * @param sectorGalactivo the sectorGalactivo to set
     */
    public void setSectorGalactivo(String sectorGalactivo) {
        this.sectorGalactivo = sectorGalactivo;
    }
    
    
    
    @Override
    public String toString(){
        return "Nombre: " + nombrePlaneta + " | " + "Sector galactico: " + sectorGalactivo;
    }
    
    
    public void agregarNave (Nave nave){
        navesRegistradas.add(nave);
        nave.setPlanetaOrigen(this);
    }
    
    public void quitarNave (Nave nave){
        navesRegistradas.remove(nave);
        nave.setPlanetaOrigen(null);
    }

    /**
     * @return the navesRegistradas
     */
    public List<Nave> getNavesRegistradas() {
        return navesRegistradas;
    }

    /**
     * @param navesRegistradas the navesRegistradas to set
     */
    public void setNavesRegistradas(List<Nave> navesRegistradas) {
        this.navesRegistradas = navesRegistradas;
    }
}
