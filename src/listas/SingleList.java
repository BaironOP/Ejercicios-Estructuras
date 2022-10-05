package listas;

public class SingleList<T> {
	
    private Node<T> head;
    private int size;

    public SingleList(){
        head=null;
        size=0;
    }
    
    

    public void add(T data){
    
        if(!isEmpty()){
            
            Node<T> f = new Node<T>();
            f.setData(data);

            Node<T> p = head;

            while(p.getNext()!=null){
                p = p.getNext();
            }

            p.setNext(f);
            size++;
        }else{
            Node<T> n = new Node<T>(data);
            
            head = n;
            size = 1;
        }
    }
    
    public void print() {
        if (!isEmpty()){
            Node<T> p = head;
            while(p!=null) {
                System.out.print(p.getData() + " -> ");
                p = p.getNext();
            }
            System.out.println();
        }else{
            System.out.print("The list is empty");
        }
    }
    
    public void deleteLast() {
        if (!isEmpty()){
            Node<T> p = head;
            Node<T> n = null;

            while(p.getNext()!=null) {
                n = p.getNext();
                if(n.getNext()==null) {
                    p.setNext(null);
                    break;
                }
                p = p.getNext();
            }
            size--;
        }
    }
    
    public void deleteFirst() {
        if (!isEmpty()){
            Node<T> p = head;
            head = head.getNext();
            p.setNext(null);
            size--;
        }
    	
        
    }
    
    public void delete(T data) {
        if (!isEmpty()){
            Node<T> p = head;
            Node<T> q = null;
            if (p.getData()==data){
                deleteFirst();
            }
            while (p.getNext()!=null){
                q = p;
                p = p.getNext();
                if (p.getData() == data){
                    q.setNext(p.getNext());
                    p.setNext(null);
                    size--;
                    break;
                }
            }
            
        }
    	
    }
    
    public void addBefore(T newData, T data) {
        if (!isEmpty()){
            Node<T> p = head;
            Node<T> q = null;
            Node<T> n = new Node(newData);
            if (p.getData()==data){
                n.setNext(head);
                head = n;
                size++;
            }
            while (p.getNext()!=null){
                q = p;
                p = p.getNext();
                if (p.getData()==data){
                    q.setNext(n);
                    n.setNext(p);
                    size++;
                    break;
                }
            }
        }
    }
    
    public void addAfter(T newData, T data) {
        if (!isEmpty()){
            Node<T> p = head;
            Node<T> n = new Node(newData);
            if (p.getData()==data){
                n.setNext(p.getNext());
                p.setNext(n);
                size++;
            }
            while (p.getNext()!=null){
                if (p.getData()==data){
                    n.setNext(p.getNext());
                    p.setNext(n);
                    size++;
                    break;
                }else{
                    p = p.getNext();
                }
            }
        }
    }
    
    public T get (int index){
        if (!isEmpty() && index<size){
            Node <T> p = head;
            while (p.getNext()!=null && index>0){
                p=p.getNext();
                index--;
            }
            return p.getData();
        }else{
            return null;
        }
        
    }
    
    public boolean isEmpty(){
        return head==null;
    }
    
    public T getFirst(){
        if (isEmpty()){
            return head.getData();
        }else{
            return null;
        }
        
    }
    
    public void clear (){
        head=null;
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
            while (p.getNext()!=null){
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









