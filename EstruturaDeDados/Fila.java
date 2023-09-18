package EstruturaDeDados;

import java.util.LinkedList;
import java.util.Queue;

class Fila {
    Queue<Integer> fila;

    public Fila() {
        fila = new LinkedList<>();
    }

    void enfileirar(int valor) {
        fila.offer(valor);
    }

    int desenfileirar() {
        if (!fila.isEmpty()) {
            return fila.poll();
        }
        return -1; // Fila vazia
    }

    int tamanho() {
        return fila.size();
    }

    boolean vazia() {
        return fila.isEmpty();
    }
}

