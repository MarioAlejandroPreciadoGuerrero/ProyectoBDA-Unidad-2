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
public class Restaurant {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idRestaurant;
    
    @Column(nullable = false)
    private String name;
    
    @Column(length = 10) 
    private String telephone;
    
    @Column(nullable = false)
    private Long kitchenType;
    
    @OneToOne(mappedBy = "restaurant",cascade = CascadeType.REMOVE)
    private Address address;
    
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.REMOVE)
    private List<DiningTable> tableList;
    
    @ManyToMany(mappedBy = "restaurantList")
    private List<Customer> customerList;

    public Restaurant() {
    }

    public Long getIdRestaurant() {
        return idRestaurant;
    }

    public void setIdRestaurant(Long idRestaurant) {
        this.idRestaurant = idRestaurant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Long getKitchenType() {
        return kitchenType;
    }

    public void setKitchenType(Long kitchenType) {
        this.kitchenType = kitchenType;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<DiningTable> getTableList() {
        return tableList;
    }

    public void setTableList(List<DiningTable> tableList) {
        this.tableList = tableList;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
    
    
}
