package data;

import java.util.ArrayList;
import java.util.List;

public class Nodo {

    private String nombre;
    private List<Arista> pasillos;
    int codigo;

    /**
     * @param nombre
     * @param codigo
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public Nodo(String nombre, int codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
        pasillos = new ArrayList();
    }

    public void addPasillo(Arista a) {
        pasillos.add(a);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Arista> getPasillos() {
        return pasillos;
    }

    public int getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        
        String cad = "";
        
         for (Arista pasillo : pasillos) {
            cad+=pasillo;
        }
        
        
        return "Sala: "+this.nombre+" "+cad;
    }

}
