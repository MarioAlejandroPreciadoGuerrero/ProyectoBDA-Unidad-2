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
public class Address {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idAddress;
    
    @Column()
    private String street;
    
    @Column()
    private String state;
    
    @Column()
    private Long cp;
    
    @Column()
    private String city;
    
    @Column()
    private long number;
    
    @OneToOne
    @JoinColumn(name = "idRestaurant")
    private Restaurant restaurant;
}
