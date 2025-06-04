
package com.bisoft20.grafonodirigido;
import java.util.ArrayList;
import java.util.List;

public class Nodo {
    
    private int key;
    public int getKey() {
        return key;
    }


    private List<Nodo> adjacentNodes;

public Nodo(int v) {
    this.key = v;
    this.adjacentNodes = new ArrayList<>();
    
}

public void AgregarAdyacencia(Nodo n)
{
    adjacentNodes.add(n);
}

public List<Nodo> getAdjacentNodes() {
    return adjacentNodes;
}

}

