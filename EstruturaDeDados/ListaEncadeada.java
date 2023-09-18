package EstruturaDeDados;


class No {
    int valor;
    No proximo;

    public No(int valor) {
        this.valor = valor;
        proximo = null;
    }
}

class ListaEncadeada {
    No cabeca;

    public ListaEncadeada() {
        cabeca = null;
    }

    void adicionar(int valor) {
        No novoNo = new No(valor);
        if (cabeca == null) {
            cabeca = novoNo;
        } else {
            No atual = cabeca;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novoNo;
        }
    }

    void mostrar() {
        No atual = cabeca;
        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.proximo;
        }
    }
}

