package org.example;

/**
 * removeFirst(): Remove um nó do início da lista e retorna seu valor. O(1)
 * remove(int index): Remove um nó da posição especificada da lista, e retorna seu valor. O(n)
 * getFirst(): Obtêm um valor no início da lista. O(1)
 * <p>
 * getLast(): Obtêm um valor no fim da lista. O(1)
 * get(int position): Retorna o valor do nó na posição especificada. O(n)
 * toString(): Exibe todos os elementos da lista, do início ao fim, separados por um espaço. O(n)
 */

public class ListaDuplamenteEncadeada {
    Elemento inicio;
    Elemento fim;
    int tamanho;

    public void print() {
        Elemento elemento = inicio;
        if (size() > 0) {
            for (int i = 0; i < size(); i++) {
                System.out.print(elemento.valor + " --> ");
                elemento = elemento.proximo;
            }
        }
    }

    public void addFirst(int valor) {
        Elemento novo = new Elemento(valor);
        if (size() == 0) {
            this.inicio = novo;
            this.fim = novo;
        } else {
            novo.proximo = inicio;
            inicio.anterior = novo;
            inicio = novo;
        }
        addTamanho();
    }

    public void addLast(int valor) {
        Elemento novo = new Elemento(valor);
        if (size() == 0) {
            this.inicio = novo;
            this.fim = novo;
        } else {
            novo.anterior = fim;
            fim.proximo = novo;
            fim = novo;
        }
        addTamanho();
    }

    public void add(int valor, int index) {
        Elemento novo = new Elemento(valor);
        Elemento atual = inicio;
        if (index == 0) {
            addFirst(valor);
            return;
        } else if (index == size()) {
            addLast(valor);
            return;
        } else if (index > size() || index < 0) {
            System.out.println("Error: index invalido. Ocorreu um erro ao inserir o valor " + valor + " na posição " + index);
            return;
        } else if (index >= (size() / 2)) {
            atual = fim;
            for (int i = size() - 1; i > index; i--) {
                atual = atual.anterior;
            }
        } else if (index < (size() / 2)) {
            atual = inicio;
            for (int i = 0; i < index; i++) {
                atual = atual.proximo;
            }
        }
        novo.proximo = atual;
        novo.anterior = atual.anterior;
        atual.anterior.proximo = novo;
        atual.anterior = novo;
        addTamanho();
    }

    public void removeFirst() {
        if (size() == 1) {
            clear();
        } else {
            inicio = inicio.proximo;
            inicio.anterior = null;
            removeTamanho();
        }
    }

    public void removeLast() {
        if (size() == 1) {
            clear();
        } else {
            fim = fim.anterior;
            fim.proximo = null;
            removeTamanho();
        }
    }

    public void remove(int index) {
        if (size() > 0) {
            Elemento elemento = inicio;
            if (index == 0) {
                removeFirst();
                return;
            }
            if (index == size() - 1) {
                removeLast();
                return;
            }
            // tratar situação indice maior que lista, deveria retornar nulo.
            if (index >= 0 && index < size()) {
                for (int i = 0; i < index; i++) {
                    elemento = elemento.proximo;
                }
            }
            Elemento elementoAnterior = elemento.anterior;
            Elemento elementoProximo = elemento.proximo;
            elementoAnterior.proximo = elementoProximo;
            elementoProximo.anterior = elementoAnterior;
            removeTamanho();
        }
    }

    public int getFirst() {
        return inicio.valor;
    }

    public int getLast() {
        return fim.valor;
    }

    public int get(int index) {
        Elemento elemento = null;
        if (size() > 0) {
            elemento = inicio;
            if (tamanho > index) {
                for (int i = 0; i < index; i++) {
                    elemento = elemento.proximo;
                }
            }
        }
        return elemento.valor;
    }

    // utilitarios
    // tamanho, limpar, e tamanho mais 1
    private void addTamanho() {
        tamanho++;
    }

    private void removeTamanho() {
        tamanho--;
    }

    public int size() {
        return tamanho;
    }

    public void clear() {
        inicio = null;
        fim = null;
        tamanho = 0;
    }

    public static void main(String[] args) {
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
        System.out.println("Lista no formato inicial");
        System.out.println("Elemento valor início: " + lista.inicio);
        System.out.println("Elemento valor fim: " + lista.fim);
        System.out.println("Tamanho da lista: " + lista.tamanho);
        System.out.println("------------------------");
        lista.addFirst(10);
        lista.addLast(11);
        lista.add(12, 1);
        System.out.println(lista.get(1));
        lista.remove(1);
        lista.print();
//        System.out.println("Lista com elementos adicionados");
//        System.out.println("Elemento valor no índice 0: " + lista.get(0));
//        System.out.println("Elemento valor no índice 1: " + lista.get(1));
//        System.out.println("Elemento valor no índice 2: " + lista.get(2));
//        System.out.println("Tamanho da lista: " + lista.tamanho);
//        System.out.println("-------------------------------");
//        lista.removeFirst();
//        lista.removeLast();
//        lista.remove(0);
//        System.out.println("Lista com elementos removidos");
//        System.out.println("Elemento valor início: " + lista.inicio);
//        System.out.println("Elemento valor fim: " + lista.fim);
//        System.out.println("Tamanho da lista: " + lista.tamanho);
//        System.out.println("-------------------------------");

    }
}
