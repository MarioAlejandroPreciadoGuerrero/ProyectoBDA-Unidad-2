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
@DiscriminatorValue("Premium")
public class PremiumCustomer extends Customer {

    @Column()
    private Long points;

    @Column()
    private Long lvl;

    public PremiumCustomer() {
    }

    private PremiumCustomer(PremiumBuilder builder) {
        super(builder);
        this.points = builder.points;
        this.lvl = builder.lvl;
    }

    public Long getPoints() {
        return points;
    }

    public Long getLvl() {
        return lvl;
    }

    @Override
    public Long getIdCustomer() {
        return idCustomer;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public List<Telephone> getTelephoneList() {
        return telephoneList;
    }

    @Override
    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public static class PremiumBuilder extends Builder<PremiumBuilder> {

        private Long points;
        private Long lvl;

        @Override
        protected PremiumBuilder self() {
            return this;
        }

        public PremiumBuilder points(Long points) {
            this.points = points;
            return this;
        }

        public PremiumBuilder lvl(Long lvl) {
            this.lvl = lvl;
            return this;
        }
        
        public PremiumCustomer build(){
            return new PremiumCustomer(this);
        }
    }
}
