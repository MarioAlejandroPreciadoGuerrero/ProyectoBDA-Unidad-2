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
public class Restaurant {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idRestaurant;
    
    @Column()
    private String name;
    
    @Column()
    private String telephone;
    
    @Column()
    private Long kitchenType;
    
    @OneToOne
    private Address address;
}
