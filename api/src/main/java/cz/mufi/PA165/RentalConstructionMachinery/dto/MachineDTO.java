package cz.mufi.PA165.RentalConstructionMachinery.dto;

import java.util.ArrayList;
import java.util.List;

import cz.mufi.PA165.RentalConstructionMachinery.domain.Rent;
import cz.mufi.PA165.RentalConstructionMachinery.domain.Revision;
import cz.mufi.PA165.RentalConstructionMachinery.enums.MachineState;
import cz.mufi.PA165.RentalConstructionMachinery.enums.MachineType;

public class MachineDTO {
    private Long id;

    private MachineType machineType;

    private List<Rent> rentHistory = new ArrayList<Rent>();

    private List<Revision> revisionHistory = new ArrayList<Revision>();

    private MachineState machineState;
    /*
     * Generated
     */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Revision> getRevisionHistory() {
        return revisionHistory;
    }

    public void setRevisionHistory(List<Revision> revisionHistory) {
        this.revisionHistory = revisionHistory;
    }

    public void addRevision(Revision revision) {
        this.revisionHistory.add(revision);
    }

    public List<Rent> getRentHistory() {
        return rentHistory;
    }

    public void setRentHistory(List<Rent> rentHistory) {
        this.rentHistory = rentHistory;
    }

    public void addRent(Rent rent) {
        this.rentHistory.add(rent);
    }

    public MachineType getMachineType() {
        return machineType;
    }

    public void setMachineType(MachineType machineType) {
        this.machineType = machineType;
    }

    public MachineState getMachineState() {
        return machineState;
    }

    public void setMachineState(MachineState machineState) {
        this.machineState = machineState;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((machineType == null) ? 0 : machineType.hashCode());
        result = prime * result + ((rentHistory == null) ? 0 : rentHistory.hashCode());
        result = prime * result + ((revisionHistory == null) ? 0 : revisionHistory.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof MachineDTO))
            return false;
        MachineDTO other = (MachineDTO) obj;
        if (machineType != other.getMachineType())
            return false;
        if (rentHistory == null) {
            if (other.getRentHistory() != null)
                return false;
        } else if (!rentHistory.equals(other.getRentHistory()))
            return false;
        if (revisionHistory == null) {
            if (other.getRevisionHistory() != null)
                return false;
        } else if (!revisionHistory.equals(other.getRevisionHistory()))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "id: " + id + " Machine type: " + machineType + " Machine state: " + machineState;
    }

}
