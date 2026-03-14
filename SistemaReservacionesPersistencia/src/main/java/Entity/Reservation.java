/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.util.Date;
import javax.persistence.*;
/**
 *
 * @author USER
 */
@Entity
@Table()
public class Reservation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;
    
    @Column(nullable = false )
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHour;
    
    @ManyToOne()
    @JoinColumn(name = "idDiningTable")
    private DiningTable diningTable;
    
    @ManyToOne()
    @JoinColumn(name = "idCustomer")
    private Customer customer;
    
    public Reservation() {
    }

    public Long getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Long idReservation) {
        this.idReservation = idReservation;
    }

    public Date getDateHour() {
        return dateHour;
    }

    public void setDateHour(Date dateHour) {
        this.dateHour = dateHour;
    }

    public DiningTable getDiningTable() {
        return diningTable;
    }

    public void setDiningTable(DiningTable diningTable) {
        this.diningTable = diningTable;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    
    
    
}
