package org.example;

public class ListaDuplamenteEncadeada {
    Elemento inicio;
    Elemento fim;
    int tamanho;

    public void addFirst(int valor){
        Elemento novo = new Elemento(valor);
        if(tamanho == 0){
            this.inicio = novo;
            this.fim = novo;
        }else{
            novo.proximo = inicio;
            inicio.anterior = novo;
            inicio = novo;
        }
        tamanho++;
    }

}
