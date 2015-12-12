package cz.mufi.PA165.RentalConstructionMachinery.dto;

/**
 * Created by Matej Jakimov on 12.12.15.
 */
public class LoginDTO {

    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoginDTO loginDTO = (LoginDTO) o;

        if (username != null ? !username.equals(loginDTO.username) : loginDTO.username != null) return false;
        return !(password != null ? !password.equals(loginDTO.password) : loginDTO.password != null);

    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
