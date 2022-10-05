/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

/**
 *
 * @author Usuario
 */
public class TwinNode<T> {
    private T data;
    private TwinNode<T> next;
    private TwinNode<T> back;

    public TwinNode(T data) {
        this.data = data;
    }

    public TwinNode() {
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public TwinNode<T> getNext() {
        return next;
    }

    public void setNext(TwinNode<T> next) {
        this.next = next;
    }

    public TwinNode<T> getBack() {
        return back;
    }

    public void setBack(TwinNode<T> back) {
        this.back = back;
    }

    
}
