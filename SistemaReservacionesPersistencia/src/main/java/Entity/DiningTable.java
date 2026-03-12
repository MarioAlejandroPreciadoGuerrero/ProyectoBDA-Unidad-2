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
public class DiningTable {
    
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long idDiningTable;
    
    @Column(nullable  = false)
    private Long number;
    
    @Column(nullable = false )
    private Long capacity;
    
}
