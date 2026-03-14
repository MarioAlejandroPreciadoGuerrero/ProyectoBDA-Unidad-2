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
    
    @Column(length = 100)
    private String street;
    
    @Column()
    private String state;
    
    @Column(nullable = false)
    private Long cp;
    
    @Column(nullable = false)
    private String city;
    
    @Column(nullable = false)
    private long number;
    
    @OneToOne
    @JoinColumn(name = "idRestaurant")
    private Restaurant restaurant;

    public Address() {
    }

    public Long getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Long idAddress) {
        this.idAddress = idAddress;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getCp() {
        return cp;
    }

    public void setCp(Long cp) {
        this.cp = cp;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
    
    
}
