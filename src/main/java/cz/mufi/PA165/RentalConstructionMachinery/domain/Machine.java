package cz.mufi.PA165.RentalConstructionMachinery.domain;

import java.util.List;

import cz.mufi.PA165.RentalConstructionMachinery.enums.MachineType;

import javax.persistence.*;

@Entity
@Table(name = "MACHINE")
public class Machine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //private List<Revision> revisionHistory;

    @OneToMany(mappedBy = "machine")
    private List<Rent> rentHistory;

    @Column
    private MachineType machineType;

    /*
     * Generated
     */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //public List<Revision> getRevisionHistory() {
    //    return revisionHistory;
    //}

    //public void setRevisionHistory(List<Revision> revisionHistory) {
    //    this.revisionHistory = revisionHistory;
    //}

    public List<Rent> getRentHistory() {
        return rentHistory;
    }

    public void setRentHistory(List<Rent> rentHistory) {
        this.rentHistory = rentHistory;
    }

    public MachineType getMachineType() {
        return machineType;
    }

    public void setMachineType(MachineType machineType) {
        this.machineType = machineType;
    }
}
