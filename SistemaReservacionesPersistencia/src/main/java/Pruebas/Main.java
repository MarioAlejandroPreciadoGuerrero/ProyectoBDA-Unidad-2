/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Pruebas;

import Conexion.Conexion;
import Entity.PremiumCustomer;
import Entity.Telephone;
import javax.persistence.EntityManager;

/**
 *
 * @author USER
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManager em = Conexion.createConnection();

        try {
            em.getTransaction().begin();

            PremiumCustomer premiumCustomer = new PremiumCustomer.PremiumBuilder()
                    .name("Mario Alejandro")
                    .email("mario@ejemplo.com")
                    .points(1500L)
                    .lvl(2L)
                    .build();

            em.persist(premiumCustomer);

            Telephone phone = new Telephone();
            phone.setTelephone("6441234567");
            phone.setCustomer(premiumCustomer);

            em.persist(phone);

            em.getTransaction().commit();

            System.out.println("¡Éxito! Cliente guardado con el ID: " + premiumCustomer.getIdCustomer());

        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.err.println("Ocurrió un error al guardar en la base de datos:");
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }

            Conexion.closeConnection();
        }
    }

}
