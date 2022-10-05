package listas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
public class CircleSingleList<T> {
    
    private Node<T> head;
    private int size;

    public CircleSingleList() {
        head = null;
        size = 0;
    }
    
    public boolean isEmpty(){
        return head == null;
    }
    
    public void add(T data){
        if (isEmpty()){
            head = new Node<T>(data);
            head.setNext(head);
            size++;
        }else{
            Node<T> n = new Node<T>(data);
            Node<T> p = head;
            int i = size;
            while (i>1){
                p = p.getNext();
                i--;
            }
            p.setNext(n);
            n.setNext(head);
            size++;
        }
    }
    
    public void print(){
        if (isEmpty()){
            System.out.println("The list is empty");
        }else{
            Node<T> p = head;
            for (int i=0; i<size; i++){
                System.out.print(p.getData()+" -> ");
                p = p.getNext();
            }
            System.out.println();
        }
    }
    
    public void deleteLast(){
        if (!isEmpty()&&size>1){
            Node<T> p = head;
            Node<T> q=p;
            for (int i=1; i<size; i++){
                q = p;
                p = p.getNext();
            }
            q.setNext(head);
            p.setNext(null);
            size--;
        }else if (size==1 && !isEmpty()){
            head=null;
            size--;
        }
    }
    
    public void deleteFirst(){
        if (!isEmpty()&&size>1){
            Node<T> p = head;
            Node<T> q=p;
            for (int i=1; i<size; i++){
                q = q.getNext();
            }
            head = p.getNext();
            q.setNext(head);
            p.setNext(null);
            size--;
        }
    }
    
    public void delete(T data){
        if (!isEmpty()&&size>1){
            Node<T> p = head;
            Node<T> q = p;
            int i = size;
            while (i>0){
                if (p.getData()==data){
                    q.setNext(p.getNext());
                    p.setNext(null);
                    size--;
                    break;
                }
                q = p;
                p = p.getNext();
                i--;
            }
        }else if (size==1){
            head = null;
            size--;
        }
    }
    
    public void addBefore(T newData, T data){
        if (!isEmpty()){
            Node<T> p = head;
            Node<T> q = p;
            Node<T> n = new Node<T>(newData);
            int i = size;
            while (i>0){
                if (p.getData()==data){
                    q.setNext(n);
                    n.setNext(p);
                    size++;
                    break;
                }
                q = p;
                p = p.getNext();
                i--;
            }
        }
    }
    
    public void addAfter(T newData, T data){
        if (!isEmpty()){
            Node<T> p = head;
            Node<T> q;
            Node<T> n = new Node<T>(newData);
            int i = size;
            while (i>0){
                if (p.getData()==data){
                    q = p.getNext();
                    p.setNext(n);
                    n.setNext(q);
                    size++;
                    break;
                }
                p = p.getNext();
                i--;
            }
        }
    }
    
    public T get(int index){
        if (!isEmpty()){
            Node<T> p = head;
            while (index>0){
                p = p.getNext();
                index--;
            }
            return p.getData();
        }else{
            return null;
        }
    }
    
    public T getFirst(){
        if (!isEmpty()){
            return head.getData();
        }else{
            return null;
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
        int cont = -1;
        if (!isEmpty()){
            Node<T> p = head;
            cont = 0;
            while (cont<=size){
                if (p.getData()==data){
                    
                    break;
                }
                p = p.getNext();
                cont++;
            }
            if(p.getData()!=data){
                cont = -1;
            }
        }
        return cont;
    }
}
