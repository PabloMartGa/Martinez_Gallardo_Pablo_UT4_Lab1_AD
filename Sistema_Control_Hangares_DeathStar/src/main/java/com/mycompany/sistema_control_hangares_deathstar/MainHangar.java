/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistema_control_hangares_deathstar;

import clases.Nave;
import clases.Planeta;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author DAM2P
 */
public class MainHangar {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        try {
            // ---------- SESIÓN 1: crear y persistir el grafo de objetos ----------
            System.out.println("=== 1. Registro del astillero y sus naves ===");
            Transaction tx = null;
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                tx = session.beginTransaction();
 
                // Planeta y naves en estado transitorio
                Planeta corellia = new Planeta(1, "Astillero de Corellia", "Mundos del Núcleo");
                Nave basico = new Nave("Caza TIE Básico", "Basic", 3, "normal");
                Nave bomber = new Nave("TIE Bomber", "Basic", 6, "critico");
 
                // El helper sincroniza ambos lados de la relación
                corellia.agregarNave(basico);
                corellia.agregarNave(bomber);
 
                // Con cascade = ALL, persistir el planeta persiste también las naves
                session.persist(corellia);
                tx.commit();
 
                int idPlaneta = corellia.getId();
                System.out.println("Planeta guardado con ID: " + idPlaneta);
            } catch (Exception e) {
                if (tx != null && tx.isActive()) {
                    tx.rollback();
                }
                System.err.println("Error al registrar el astillero, rollback realizado: " + e.getMessage());
                return;
            }
 
            // ---------- SESIÓN 2: sesión limpia, recuperar y recorrer el grafo ----------
            System.out.println("\n=== 2. Manifiesto del astillero ===");
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                Planeta planeta = session.get(Planeta.class, "planeta_id");
 
                if (planeta == null) {
                    System.out.println("No existe ningún planeta con ID " + "planeta_id");
                    return;
                }
 
                System.out.println("Planeta: " + planeta.getNombrePlaneta()
                        + " (Sector: " + planeta.getSectorGalactivo()+ ")");
                System.out.println("Naves amarradas:");
 
                // La colección es LAZY: se carga aquí, con la sesión aún abierta
                for (Nave n : planeta.getNavesRegistradas()) {
                    System.out.println(" - " + n);
                }
            } catch (Exception e) {
                System.err.println("Error al recuperar el manifiesto: " + e.getMessage());
            }
        } finally {
            HibernateUtil.shutdown();
        }
        
    }
}
