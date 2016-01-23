package cz.mufi.PA165.RentalConstructionMachinery.domain;

/**
 * 
 * @author Tomas
 *
 */
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author tomas
 */
@Entity
@Table(name = "REVISION")
public class Revision implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private Date revisionDate;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "machine_id")
    private Machine machine;

    /*
     * Revision class 
     */

    /**
     *
     * @return id of Revision
     */


    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     * set ID 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return Revision date
     */
    public Date getRevisionDate() {
        return revisionDate;
    }

    /**
     *Set revision Date
     * @param revisionDate
     */
    public void setRevisionDate(Date revisionDate) {
        this.revisionDate = revisionDate;
    }

    /**
     *Return Machine
     * @return
     */
    public Machine getMachine() {
        return machine;
    }

    /**
     *Set machine 
     * @param machine
     */
    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    /**
     *Return String -> output of class
     * @return 
     */
    @Override
    public String toString() {
        return "Revision---> id: " + getId() + " ,date: " + getRevisionDate();
    }

    /**
     *Equals class
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Revision))
            return false;
        Revision revision = (Revision) obj;
        if (revisionDate != revision.getRevisionDate())
            return false;
        if (revisionDate == null) {
            if (revision.getRevisionDate() != null)
                return false;
        } else if (!revisionDate.equals(revision.getRevisionDate()))
            return false;
        return true;
    }

   
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((revisionDate == null) ? 0 : revisionDate.hashCode());
        return result;

    }

}
