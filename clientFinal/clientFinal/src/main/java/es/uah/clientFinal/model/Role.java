package es.uah.clientFinal.model;

public class Role {

    private Integer idRole;

    private String authority;

    public Role() {
    }

    public Role(String idRoleAndName) {
        if(idRoleAndName != null && idRoleAndName.length() > 0){
            String[] fieldPositions = idRoleAndName.split("-");
            this.idRole = Integer.parseInt(fieldPositions[0]);
            this.authority = fieldPositions[1];
        }
    }

    public Role(Integer idRole, String authority) {
        this.idRole = idRole;
        this.authority = authority;
    }

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return ""+this.idRole+"-"+this.authority;
    }
}
