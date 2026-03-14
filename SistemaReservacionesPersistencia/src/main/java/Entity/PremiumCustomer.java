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
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("Premium")
public class PremiumCustomer extends Customer {
    
    @Column()
    private Long points;
    
    @Column()
    private Long lvl;
}
