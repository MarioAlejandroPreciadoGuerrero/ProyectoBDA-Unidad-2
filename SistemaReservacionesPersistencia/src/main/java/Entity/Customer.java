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
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
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

    @OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE)
    protected List<Telephone> telephoneList;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE)
    protected List<Reservation> reservationList;

    @ManyToMany()
    @JoinTable(
            joinColumns = @JoinColumn(name = "idCustomer"),
            inverseJoinColumns = @JoinColumn(name = "idRestaurant")
    )
    private List<Restaurant> restaurantList;
    
    public Customer(){}
    
    protected Customer (Builder builder){
        this.name = builder.name;
        this.email = builder.email;
        this.telephoneList = builder.telephoneList;
        this.reservationList = builder.reservationList;
        this.restaurantList = builder.restaurantList;
    }

    public Long getIdCustomer() {
        return idCustomer;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Telephone> getTelephoneList() {
        return telephoneList;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public List<Restaurant> getRestaurantList() {
        return restaurantList;
    }

    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelephoneList(List<Telephone> telephoneList) {
        this.telephoneList = telephoneList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    public void setRestaurantList(List<Restaurant> restaurantList) {
        this.restaurantList = restaurantList;
    }
    
    

    public abstract static class Builder<T extends Builder<T>> {
        private String name;
        private String email;
        private List<Telephone> telephoneList;
        private List<Reservation> reservationList;
        private List<Restaurant> restaurantList;
        
        protected abstract T self();
        
        public T name (String name){
            this.name = name;
            return self();
        }
        
        public T email (String email){
            this.email = email;
            return self();
        }
        
        public T telephoneList (List<Telephone> telephoneList){
            this.telephoneList = telephoneList;
            return self();
        }
        
        public T reservationList (List<Reservation> reservationList){
            this.reservationList = reservationList;
            return self();
        }
        
        public T restaurantList (List<Restaurant> restaurantList){
            this.restaurantList = restaurantList;
            return self();
        }
    }
    
    public static class CustomerBuilder extends Builder<CustomerBuilder>{

        @Override
        protected CustomerBuilder self() {
            return this;
        }
        
        public Customer build (){
            return new Customer (this);
        }
        
    }
}
