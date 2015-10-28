package cz.mufi.PA165.RentalConstructionMachinery.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import cz.mufi.PA165.RentalConstructionMachinery.enums.MachineType;

@Entity
@Table(name = "MACHINE")
public class Machine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MachineType machineType;

    @OneToMany(mappedBy = "machine")
    private List<Rent> rentHistory = new ArrayList<Rent>();

    @OneToMany(mappedBy = "machine")
    private List<Revision> revisionHistory = new ArrayList<Revision>();

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

}
