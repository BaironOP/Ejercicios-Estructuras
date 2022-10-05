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
public class TwinLinkedList<T> {
    private TwinNode<T> head;
    private int size;

    public TwinLinkedList() {
        head = null;
        size = 0;
    }
    
    public boolean isEmpty(){
        return head == null;
    }
    
    public void add(T data){
        if (isEmpty()){
            head = new TwinNode<T>(data);
            head.setBack(null);
            head.setNext(null);
            size++;
        }else{
            TwinNode<T> p = head;
            TwinNode<T> n = new TwinNode<T>(data);
            for (int i = size; i>1; i--){
                p = p.getNext();
            }
            p.setNext(n);
            n.setBack(p);
            n.setNext(null);
            size++;
        }
    }
    
    public void print(){
        if (isEmpty()){
            System.out.println("The List is Empty");
        }else{
            TwinNode<T> p = head;
            int i = size;
            while (p.getNext()!=null && i>1){
                System.out.print(p.getData()+" -> ");
                i--;
            }
            System.out.println();
        }
    }
    
    public void deleteLast(){
        if (!isEmpty() && size>1){
            TwinNode<T> p = head;
            int i = size;
            while (p.getNext()!=null && i>0){
                p = p.getNext();
                i--;
            }
            p = p.getBack();
            p.setNext(null);
            size--;
        }else if (size==1 && !isEmpty()){
            head = null;
            size--;
        }
    }
    
    public void deleteFirst(){
        if (!isEmpty() && size>1){
            TwinNode<T> p = head;
            head = head.getNext();
            head.setBack(null);
            p.setNext(null);
            size--;
        } else if (!isEmpty() && size==1){
            head = null;
        }
    }
    
    public void delete (T data){
        if (!isEmpty()){
            TwinNode<T> p = head;
            TwinNode<T> q = p;
            while (p.getNext()!=null){
                if (p.getData() == data){
                    q.setNext(p.getNext());
                    p.getNext().setBack(q);
                    p.setNext(null);
                    p.setBack(null);
                    size--;
                    break;
                }
                q = p;
                p = p.getNext();
            }
        }
    }
    
    public void addBefore(T newData, T data){
        if (!isEmpty()){
            if (size>1){
                TwinNode<T> p = head;
                TwinNode<T> q = p;
                TwinNode<T> n = new TwinNode<T>(data);
                while (p.getNext()!=null){
                    if (p.getData() == data){
                        q.setNext(n);
                        n.setBack(q);
                        n.setNext(p);
                        p.setBack(n);
                        size++;
                        break;
                    }
                    q = p;
                    p = p.getNext();
                }
            }
        }
    }
    
    public void addAfter(T newData, T data){
        if (!isEmpty()){
            if (size>1){
                TwinNode<T> p = head;
                TwinNode<T> q = p;
                TwinNode<T> n = new TwinNode<T>(data);
                while (p.getNext()!=null){
                    if (p.getData() == data){
                        q=p;
                        p = p.getNext();
                        q.setNext(n);
                        n.setBack(q);
                        n.setNext(p);
                        p.setBack(n);
                        size++;
                        break;
                    }
                    q = p;
                    p = p.getNext();
                }
            }
        }
    }
    
    public T get(int index){
        TwinNode<T> p = head;
        if (!isEmpty()&&index<=size){
            while (index<0){
                p = p.getNext();
                index--;
            }
            return p.getData();
        }else{
            return null;
        }
    }
    
    public T getFirst(){
        if (isEmpty()){
            return null;
        }else{
            return head.getData();
        }
    }
    
    public void clear(){
        head = null;
        size = 0;
    }
    
    public int getSize(){
        return size;
    }
    
    public int indexOf(T data){
        if (isEmpty()){
            TwinNode<T> p = head;
            int i = 0;
            while (p.getData() != data && i<=size){
                p = p.getNext();
                i++;
            }
            return i;
        }else{
            return -1;
        }
    }
}
