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
public class DiningTable {
    
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long idDiningTable;
    
    @Column(nullable  = false)
    private Long number;
    
    @Column(nullable = false )
    private Long capacity;
    
    @ManyToOne()
    @JoinColumn(name = "idRestaurant" )
    private Restaurant restaurant;
    
    @OneToMany(mappedBy = "diningTable")
    private List<Reservation> reservationList;
    

    public DiningTable() {
    }

    public Long getIdDiningTable() {
        return idDiningTable;
    }

    public void setIdDiningTable(Long idDiningTable) {
        this.idDiningTable = idDiningTable;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }
    
    
    
}
