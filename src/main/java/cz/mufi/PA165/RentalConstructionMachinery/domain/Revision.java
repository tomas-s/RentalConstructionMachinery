package cz.mufi.PA165.RentalConstructionMachinery.domain;

/**
 * 
 * @author Tomas
 *
 */
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "REVISION")
public class Revision {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private Date revisionDate;

    // tymto som si neni isty treba sa este nato pozriet
    // @ManyToOne(fetch=FetchType.LAZY)
    // private Machine machine;

    /*
     * Generated
     */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getRevisionDate() {
        return revisionDate;
    }

    public void setRevisionDate(java.sql.Date revisionDate) {
        this.revisionDate = revisionDate;
    }

    // public Machine getMachine() {
    // return machine;
    // }
    //
    // public void setMachine(Machine machine) {
    // this.machine = machine;
    // }

    @Override
    public String toString() {
        return "Revision---> id: "+getId()+" ,date: "+getRevisionDate();
    }

    
}
