package cz.mufi.PA165.RentalConstructionMachinery.domain;

/**
 * 
 * @author Tomas
 *
 */
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

@Entity
@Table(name = "REVISION")
// tereticky by tu malo byt implement serializable len somto nechcel spustat ked
// mi nesli testy
public class Revision {

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

    public void setRevisionDate(Date revisionDate) {
        this.revisionDate = revisionDate;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    @Override
    public String toString() {
        return "Revision---> id: " + getId() + " ,date: " + getRevisionDate();
    }

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
        if (machine != revision.getMachine())
            return false;
        if (machine == null) {
            if (revision.getMachine() != null)
                return false;
        } else if (!machine.equals(revision.getMachine()))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((machine == null) ? 0 : machine.hashCode());
        result = prime * result + ((revisionDate == null) ? 0 : revisionDate.hashCode());
        return result;

    }
    

}
