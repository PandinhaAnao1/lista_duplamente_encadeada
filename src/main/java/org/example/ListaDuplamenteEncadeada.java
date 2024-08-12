package org.example;

/**
 *  removeFirst(): Remove um nó do início da lista e retorna seu valor. O(1)
    remove(int index): Remove um nó da posição especificada da lista, e retorna seu valor. O(n)
    getFirst(): Obtêm um valor no início da lista. O(1)

    getLast(): Obtêm um valor no fim da lista. O(1)
    get(int position): Retorna o valor do nó na posição especificada. O(n)
    toString(): Exibe todos os elementos da lista, do início ao fim, separados por um espaço. O(n)
 */

public class ListaDuplamenteEncadeada {
    Elemento inicio;
    Elemento fim;
    int tamanho;

    public void addFirst(int valor){
        Elemento novo = new Elemento(valor);
        if(size() == 0){
            this.inicio = novo;
            this.fim = novo;
        }else{
            novo.proximo = inicio;
            inicio.anterior = novo;
            inicio = novo;
        }
        addTamanho();
    }

    public void addLast(int valor){
        Elemento novo = new Elemento(valor);
        if(size() == 0){
            this.inicio = novo;
            this.fim = novo;
        }else{
            novo.anterior = fim;
            fim.proximo = novo;
            fim = novo;
        }
        addTamanho();
    }

    public void add(int valor, int index){
        Elemento novo = new Elemento(valor);
        Elemento atual = inicio;
        if(index == 0){
            addFirst(valor);
            return;

        }else if(index == size()){
            addLast(valor);
            return;
        
        }else if(index > size() || index < 0){
            System.out.println("Error: index invalido. Ocorreu um erro ao incerir o valor "+valor+" na posição "+index);

            return;
        }else if(index >= (size() / 2)){
            atual = fim;
            for(int i = size(); i != index; i--){
                atual = fim.anterior;
            }

        }else if(index < (size() / 2)){
            atual = inicio;
            for(int i = 0; i != index; i++){
                atual = fim.proximo;
            }
        }

        novo.proximo = atual;
        novo.anterior = atual.anterior;
        novo.anterior.proximo = novo;
        novo.proximo.anterior = novo; 
    }

    public void removeLast(){
        if(size() == 1){
            clear();
        }else{
            fim = fim.anterior;
            fim.proximo = null;
        }
    }

    // utilitarios
    // tamanho, limpar, e tamanho mais 1
    public void addTamanho(){
        tamanho++;
    }

    public int size(){
        return tamanho;
    }

    public void clear(){
        inicio = null;
        fim = null;
    }

    public static void main(String[] args) {
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
        lista.addFirst(10);
        lista.addFirst(15);
        lista.addLast(12);
        lista.add(10, -1);
        lista.removeLast();
        System.out.println(lista.fim.valor);

    }
}
