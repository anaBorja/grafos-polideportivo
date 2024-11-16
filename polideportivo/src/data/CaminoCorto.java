package data;

import java.util.PriorityQueue;

public abstract class CaminoCorto {

            /*
 Clase donde se intentara sacar el camino corto con lista o mapas 
el calculo de del peso menor lo he calculado a mano seria de esta manera 
    
    0   1   2   3   4   5   6
0   0   10  12  21  3   10  12
1   10  0   2   11  4   7   19
2   12  2   0   9   6   5   7
3   21  11  9   0   15  10  8
4   3   4   6   15  0   7   9
5   10  7   5   10  7   0   2
6   12  19  7   8   9   2   0

         */

    
    
    public static String encontrarCaminoMinimo(Grafo g, int inicio, int destino) {


        //metodo donde se calculara camino corto: le pasamos Grafo dos int representara el inicio y destino
        

            // variables para --> grafo, int origen, int destino
            int nodos = g.getHabitaciones().size();// el tamaño del grafo...numero de salsa
            Nodo nodoAux;
            int[] distancia = new int[nodos]; // distancias posible de origen y destino
            int[] nodoOrigen = new int[nodos];//nodo donde queremos iniciar 
            String cad = "";

            // recorrer el grafo para iniciarlo donde el valor de distancia es mayor y nodoOrigen 
            //se dice que no hay nada que se va a guargar un nodoOrigen
            for (int i = 0; i < nodos; i++) {
                distancia[i] = Integer.MAX_VALUE;
                nodoOrigen[i] = -1;

            }

            // distancia se ha iniciar con int origen
            distancia[inicio] = 0;

            // se usa PriorityQueue para la busqueda del caminocorto ya que al recorrer el grafo 
            //crea una cola de prioridad donde el camino corto o el peso minimo esta en la parte superior de la cola
            //dando al camino corto tenga proiridad 1 y camino largo n prioridad (ultimo de la lista)
            PriorityQueue<Integer> nodosNoVisitados = new PriorityQueue<>();
            nodosNoVisitados.add(inicio); // Mete el origen en la cola, es decir, que empezara a investigar las aristas desde este nodo (el inicial)

            while (!nodosNoVisitados.isEmpty()) { //Se va a repetir mientras queden caminos que recorrer
                int nodoConPesoMenor = nodosNoVisitados.poll(); //Saca al elemento que tiene menor peso 
                
                /*
                La razon por la que el while acaba aunque se sigan metiendo nodos es que
                la cola se va a ir reduciendo gradualmente con cada iteracion del bucle con
                el elemento de menor peso, con todos los nodos que encontremos
                */
                
                nodoAux = g.buscarNodo(nodoConPesoMenor); //Busca el nodo de menor peso (la primera iteracion si elijes el nodo en posicion 0, seria 0, osea la sala de pesas)
                if (nodoAux != null) {  //Si el nodo no es nulo
                    if (!nodoAux.getPasillos().isEmpty()) {    //Si tiene aristas el nodo
                        for (Arista a : nodoAux.getPasillos()) { //Recorre todos los caminos posibles del nodoAux
                            int pos = a.getDestino().getCodigo();  //Obtiene el codigo del nodo del destino
                            int distanciaHaciaDestino = a.getDistancia(); //Obtiene la distancia del origen al destino
                            
                            /*
                            Si la distancia conocida hacia ese nodo es mayor que la distancia entre
                            el nodo con menor peso + la distancia que hacia ese nodo, significa que
                            hemos encontrado un camino con menor distancia.
                            */
                            if (distancia[pos] > (distancia[nodoConPesoMenor] + distanciaHaciaDestino)) {
                                //Actualizo la distancia mas corta
                                distancia[pos] = (distancia[nodoConPesoMenor] + distanciaHaciaDestino);
                                
                                //Esto guarda desde que nodo hemos ido al nodo destino
                                nodoOrigen[pos] = nodoConPesoMenor;
                                //Al encontrar un camino nuevo, se vuelve a añadir a la cola
                                nodosNoVisitados.add(pos);
                            }
                        }
                    }
                }

            }
            
            //Acabo de terminar de recorrer mi grafo, esto comprueba que el 
            //inicio no es igual a destino, es decir, que hay distancia entre ellos
            if (distancia[destino] != 0) {
                cad = "El camino mas corto es: \n";
                cad += visualizarRuta(g, nodoOrigen, inicio, destino) + "\n";
                cad += "La distancia es de " + distancia[destino] + " metros.";
            } else {
                cad = "Se encuentra en el mismo sitio";
            }

            return cad;
        }

        private static String visualizarRuta(Grafo g, int[] padre, int inicio, int destino) {
            
            String cad = "", nombreNodoDestino;
            while (destino != inicio) {  //Va a ir "marcha atras" hasta que llege al nodo desde el que empezó 
                nombreNodoDestino = g.buscarNodo(destino).getNombre(); //Busca el nombre del nodo destino
                cad = " -> " + nombreNodoDestino + cad;  //Agrego a la cadena ese nombre
                destino = padre[destino]; //Cojo en la variable destino a su padre y repito el bucle si no estamos en el inicio.
            }
            cad = g.buscarNodo(inicio).getNombre() + cad; //Saco por pantalla el nombre del nodo Inicial y todos sus caminos
            return cad;
        }
    }


