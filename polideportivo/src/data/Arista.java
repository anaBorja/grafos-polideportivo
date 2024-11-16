package data;


public class Arista {
    
    private Nodo origen;
    private Nodo destino;
    private int distancia; //--> Peso

    public Arista(Nodo origen, Nodo destino, int distancia) {
        this.origen = origen;
        this.destino = destino;
        this.distancia = distancia;
    }

    public Nodo getOrigen() {
        return origen;
    }

    public void setOrigen(Nodo origen) {
        this.origen = origen;
    }

    public Nodo getDestino() {
        return destino;
    }

    public void setDestino(Nodo destino) {
        this.destino = destino;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    @Override
    public String toString() {
        return "La distancia entre la sala "+this.origen.getNombre()+" y "+this.destino.getNombre()+" es"
                + " de "+this.distancia+" ";
    }
    
    
    
    
    
}
