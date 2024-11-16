package data;

import java.util.ArrayList;
import java.util.List;

public class Grafo {

    List<Nodo> habitaciones;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public Grafo(List<Nodo> salas) {
        this.habitaciones = new ArrayList();
        this.habitaciones = salas;
    }

    public void visualizar() {
            
        for (Nodo sala : habitaciones) {
            System.out.println(""+sala);
        }
        
        
    }

    public List<Nodo> getHabitaciones() {
        return habitaciones;
    }
    
    
    
     public Nodo buscarNodo(int codigoNodo){
        for (Nodo no : habitaciones) {
            if(no.getCodigo()==codigoNodo){
                return no;
            }
        }
        return null;
    }

}
