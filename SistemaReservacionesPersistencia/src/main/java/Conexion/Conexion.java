/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import javax.persistence.*;

/**
 *
 * @author USER
 */
public class Conexion {

    private Conexion() {
    }

    private static EntityManagerFactory emf = null;

    public static EntityManager createConnection() {
        try {
            if (emf == null) {
                emf = Persistence.createEntityManagerFactory("ConexionPU");
            }
            return emf.createEntityManager();
        } catch (Exception e) {
            System.out.println("No se ha podido realizar la conexion" + e.getMessage());
            throw new RuntimeException("Eror con la conexion");
        }
    }

    public static void closeConnection() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
