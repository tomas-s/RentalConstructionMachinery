package cz.mufi.PA165.RentalConstructionMachinery.dto;

import java.util.Date;


public class RevisionDTO {

    private Long id;

    private Date revisionDate;

    private MachineDTO machine;

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

    public MachineDTO getMachine() {
        return machine;
    }

    public void setMachine(MachineDTO machine) {
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
        if (!(obj instanceof RevisionDTO))
            return false;
        RevisionDTO revision = (RevisionDTO) obj;
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
