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

    public Telephone() {
    }

    public Long getIdTelephone() {
        return idTelephone;
    }

    public void setIdTelephone(Long idTelephone) {
        this.idTelephone = idTelephone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
