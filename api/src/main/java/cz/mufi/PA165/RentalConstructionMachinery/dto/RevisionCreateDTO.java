package cz.mufi.PA165.RentalConstructionMachinery.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

/**
 * Created by jakac on 27.11.15.
 */
public class RevisionCreateDTO {

    @NotNull
    private MachineDTO machine;

    @NotNull
    private Date revisionDate;

    public MachineDTO getMachine() {
        return machine;
    }

    public void setMachine(MachineDTO machine) {
        this.machine = machine;
    }

    public Date getRevisionDate() {
        return revisionDate;
    }

    public void setRevisionDate(Date revisionDate) {
        this.revisionDate = revisionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        RevisionCreateDTO that = (RevisionCreateDTO) o;

        // if (machine != null ? !machine.equals(that.machine) : that.machine !=
        // null)
        // return false;
        return !(revisionDate != null ? !revisionDate.equals(that.revisionDate) : that.revisionDate != null);

    }

    @Override
    public int hashCode() {
        // int result = machine != null ? machine.hashCode() : 0;
        int result = (revisionDate != null ? revisionDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RevisionCreateDTO [machine=" + machine + ", revisionDate=" + revisionDate + "]";
    }
}
