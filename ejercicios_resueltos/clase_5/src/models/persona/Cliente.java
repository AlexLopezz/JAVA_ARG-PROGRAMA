package models.persona;

public class Cliente extends Persona {
    private String n_Socio;

    public Cliente(String nombre, String apellido, String n_Socio) {
        super(nombre, apellido);
        this.n_Socio = n_Socio;
    }

    public Cliente(String n_Socio) {
        super();
        this.n_Socio = n_Socio;
    }

    public String getN_Socio() {
        return n_Socio;
    }

    public void setN_Socio(String n_Socio) {
        n_Socio = n_Socio;
    }
}
