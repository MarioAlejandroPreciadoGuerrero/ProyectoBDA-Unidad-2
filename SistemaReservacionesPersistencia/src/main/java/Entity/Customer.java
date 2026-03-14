/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.util.List;
import javax.persistence.*;
/**
 *
 * @author USER
 */
@Entity
@Table()
@Inheritance(strategy =InheritanceType.SINGLE_TABLE )
@DiscriminatorColumn(name = "Tipo", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Normal")
public class Customer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long idCustomer;
    
    @Column(nullable = false, length = 50)
    protected String name;
    
    @Column(nullable = false)
    protected String email;
    
    @OneToMany(mappedBy = "customer",cascade = CascadeType.REMOVE)
    protected List<Telephone> telephoneList;
    
    @OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE)
    protected List<Reservation> reservationList;
    
    @ManyToMany()
    @JoinTable(
            joinColumns = @JoinColumn(name = "idCustomer"),
            inverseJoinColumns = @JoinColumn(name = "idRestaurant")
    )
    private List<Restaurant> restaurantLists;
}
