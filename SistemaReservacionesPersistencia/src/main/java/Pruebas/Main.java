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
            // 2. Iniciar la transacción con la base de datos
            em.getTransaction().begin();

            // 3. Crear el cliente usando tu Patrón Builder
            PremiumCustomer premiumCustomer = new PremiumCustomer.PremiumBuilder()
                    .name("Mario Alejandro")
                    .email("mario@ejemplo.com")
                    .points(1500L)
                    .lvl(2L)
                    .build();

            // 4. Guardar (persistir) el cliente
            em.persist(premiumCustomer);

            // 5. Crear un teléfono y asociarlo al cliente
            Telephone phone = new Telephone();
            phone.setTelephone("6441234567");
            phone.setCustomer(premiumCustomer);

            // Guardar el teléfono
            em.persist(phone);

            // 6. Confirmar la transacción (hacer el commit)
            em.getTransaction().commit();

            System.out.println("¡Éxito! Cliente guardado con el ID: " + premiumCustomer.getIdCustomer());

        } catch (Exception e) {
            // Si algo falla, hacemos rollback para no dejar datos a medias
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.err.println("Ocurrió un error al guardar en la base de datos:");
            e.printStackTrace();
        } finally {
            // 7. Cerrar el EntityManager de esta transacción
            if (em != null && em.isOpen()) {
                em.close();
            }

            // 8. Cerrar la conexión global (el Factory) al terminar la ejecución de tu programa
            Conexion.closeConnection();
        }
    }

}
