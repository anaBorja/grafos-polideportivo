package data;

import GUI.VPpal;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        
        VPpal v = new VPpal("Mapa polideportivo");
        
        v.setVisible(true);
        
       // f.visualizar();
      

    }

    public static Grafo obtenerGrafo() {
        Nodo NPesas = new Nodo("Zona de pesas", 0);
        Nodo NPista = new Nodo("Pista de atletismo", 1);
        Nodo NPiscina = new Nodo("Piscina olimpica", 2);
        Nodo NYoga = new Nodo("Sala de yoga", 3);
        Nodo NArco = new Nodo("Campo de tiro con arco", 4);
        Nodo NDuchas = new Nodo("Duchas", 5);
        Nodo NCafeteria = new Nodo("Cafeteria", 6);

        NPesas.addPasillo(new Arista(NPesas, NPista, 10));
        NPesas.addPasillo(new Arista(NPesas, NArco, 3));
        NPesas.addPasillo(new Arista(NPesas, NCafeteria, 15));

        ////////////////////////////////////////////////////
        NPista.addPasillo(new Arista(NPista, NPesas, 10));
        NPista.addPasillo(new Arista(NPista, NPiscina, 2));
        NPista.addPasillo(new Arista(NPista, NArco, 4));

        ///////////////////////////////////////////////////
        NPiscina.addPasillo(new Arista(NPiscina, NPista, 2));
        NPiscina.addPasillo(new Arista(NPiscina, NYoga, 9));
        NPiscina.addPasillo(new Arista(NPiscina, NDuchas, 5));

        ///////////////////////////////////////////////////
        NYoga.addPasillo(new Arista(NYoga, NPiscina, 9));
        NYoga.addPasillo(new Arista(NYoga, NCafeteria, 8));

        ///////////////////////////////////////////////////
        NArco.addPasillo(new Arista(NArco, NPesas, 3));
        NArco.addPasillo(new Arista(NArco, NPista, 4));
        NArco.addPasillo(new Arista(NArco, NDuchas, 7));

        ///////////////////////////////////////////////////
        NDuchas.addPasillo(new Arista(NDuchas, NPiscina, 5));
        NDuchas.addPasillo(new Arista(NDuchas, NArco, 7));
        NDuchas.addPasillo(new Arista(NDuchas, NCafeteria, 2));

        ///////////////////////////////////////////////////
        NCafeteria.addPasillo(new Arista(NCafeteria, NPesas, 15));
        NCafeteria.addPasillo(new Arista(NCafeteria, NYoga, 8));
        NCafeteria.addPasillo(new Arista(NCafeteria, NDuchas, 2));
        
        @SuppressWarnings({ "rawtypes", "unchecked" })
        List<Nodo> habitaciones = new ArrayList();
        
        habitaciones.add(NPesas);
        habitaciones.add(NPista);
        habitaciones.add(NPiscina);
        habitaciones.add(NYoga);
        habitaciones.add(NArco);
        habitaciones.add(NDuchas);
        habitaciones.add(NCafeteria);
                
        return new Grafo(habitaciones);

    }

}
