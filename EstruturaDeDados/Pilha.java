package EstruturaDeDados;

import java.util.Stack;

class Pilha {
    Stack<Integer> pilha;

    public Pilha() {
        pilha = new Stack<>();
    }

    void empilhar(int valor) {
        pilha.push(valor);
    }

    int desempilhar() {
        if (!pilha.isEmpty()) {
            return pilha.pop();
        }
        return -1; // Pilha vazia
    }

    int topo() {
        if (!pilha.isEmpty()) {
            return pilha.peek();
        }
        return -1; // Pilha vazia
    }

    int tamanho() {
        return pilha.size();
    }

    boolean vazia() {
        return pilha.isEmpty();
    }
}

