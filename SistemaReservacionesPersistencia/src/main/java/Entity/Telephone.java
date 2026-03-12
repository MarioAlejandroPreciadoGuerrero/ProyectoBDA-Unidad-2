/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import javax.persistence.*;

/**
 *
 * @author USER
 */
@Entity
@Table()
public class Telephone {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTelephone;
    
    @Column(length = 10)
    private String telephone;
    
    @ManyToOne
    @JoinColumn(name = "idCustomer")
    private Customer customer;
}
