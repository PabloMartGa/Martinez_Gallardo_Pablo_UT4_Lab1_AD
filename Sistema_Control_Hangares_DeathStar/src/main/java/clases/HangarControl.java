/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import jakarta.persistence.Query;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import org.hibernate.query.Query;
import org.hibernate.Session;
import util.HibernateUtil;
/**
 *
 * @author DAM2P
 */
public class HangarControl {
    Scanner sc = new Scanner(System.in);
    
    public void registrarNuevaNave()throws IOException{
        System.out.println("Inserta nombre de la nueva nave: ");
        String nuevoNombre = sc.nextLine();
        
        System.out.println("Inserta modelo de la nave '" + nuevoNombre + "': ");
        String nuevoModelo = sc.nextLine();
        
        System.out.println("Inserta la capacidad de la nave: ");
        int nuevaCapacidad = sc.nextInt();
        
        System.out.println("Inserta estado del sistema de la nave: ");
        String nuevoEstado = sc.nextLine();
        
        Nave n = new Nave(nuevoNombre, nuevoModelo, nuevaCapacidad, nuevoEstado);
        
        System.out.println("Nave registrada correctamente");
        System.out.println(n.toString());
    }
    
    public void actualizarEstadoNave(){
        System.out.println("Inserta ID de la nave que se va a modificar el estado: ");
        String id = sc.nextLine();
        
        System.out.println("Inserte el nuevo estado de la nave");
        String estadoActualizado = sc.nextLine();
        
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            String hqlFiltro = "UPDATE naves SET estado_sistema = :estadoRef WHERE nombre_id = :idRef";
            
            Query<Nave> queryFiltro = session.createQuery(hqlFiltro, Nave.class);
            queryFiltro.setParameter("idRef", id);
            queryFiltro.setParameter("estadoRef", estadoActualizado);
            
            System.out.println("Estado de la nave actualizado correctamente");
            
        } catch (Exception e) {
            System.err.println("Error en el filtrado: " + e.getMessage());
        } finally {
            HibernateUtil.shutdown();
        }
    }
    
    public void obtenerCazasPorModelo(String modeloBuscado){
        
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            String hqlFiltro = "FROM Nave n WHERE n.modelo = :modeloRef";
            
            Query<Nave> queryFiltro = session.createQuery(hqlFiltro, Nave.class);
            queryFiltro.setParameter("modeloRef", modeloBuscado);
            
            List<Nave> navesBuscadas = queryFiltro.getResultList();
            
            for(Nave nave: navesBuscadas){
                System.out.println(nave);
            }
            
        } catch (Exception e) {
            System.err.println("Error en el filtrado: " + e.getMessage());
        } finally {
            HibernateUtil.shutdown();
        }
    }
}
