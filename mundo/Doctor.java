package mundo;

import java.util.ArrayList;

public class Doctor extends Usuario {

    /*------------------------------------
     * Atributos
     *----------------------------------*/
    private String especialidad;
    private ArrayList<Doctor> doctores = new ArrayList<>();

    /*----------------------------------------
     * Metodos
     *---------------------------------------*/

    public Doctor(String nombre, String especialidad, String clave) {
        super(nombre, clave);
        this.especialidad = especialidad;

    }
    public Doctor()
    {
        
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    public ArrayList<Doctor> baseDoctores() {

        doctores.add(new Doctor("jonathan Burbano ", null, "12345678"));
        doctores.add(new Doctor("keren  ", null, "87654321"));
        doctores.add(new Doctor("rocio ", null, "19733791"));
        return doctores;
    }

}
