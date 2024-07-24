public class LinkedListDeque<T>{

    private  class TNode{
        public T item;
        public TNode next;
        public TNode prev;
        public TNode(TNode pr, T i, TNode n){
            item = i;
            next = n;
            prev = pr;
        }
    }

    private TNode sentinelBegin;
    private TNode sentinelLast;
    private int size;
    public LinkedListDeque(){
        sentinelBegin = new TNode(null,null,null);
        size = 0;
        sentinelLast = new TNode(sentinelBegin,null,null);
        sentinelBegin.next = sentinelLast;
    }
    public LinkedListDeque(LinkedListDeque other){
        this();
        TNode p = other.sentinelBegin.next;
        while(p != other.sentinelLast) {
            addLast(p.item);
            p = p.next;
        }

    }
    public LinkedListDeque(T x){
        this();
        addLast(x);
    }

    public void addFirst(T x){
        TNode newNode = new TNode(sentinelBegin,x,sentinelBegin.next);
        sentinelBegin.next.prev = newNode;
        sentinelBegin.next = newNode;
        size += 1;
    }
    public void addLast(T x) {
        TNode newNode = new TNode(sentinelLast.prev, x, sentinelLast);
        sentinelLast.prev.next = newNode;
        sentinelLast.prev = newNode;
        size += 1;
    }

    public boolean isEmpty(){
        if (sentinelBegin.next == sentinelLast) {
            /* if (size == 0)*/
            return true;
        }
        return false;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        TNode p = sentinelBegin.next;
        if (sentinelBegin.next == sentinelLast){
            return;
        }
        while (p.next != sentinelLast ){
            System.out.println(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        TNode firstNode = sentinelBegin.next;
        sentinelBegin.next = firstNode.next;
        firstNode.next.prev = sentinelBegin;
        size -= 1;
        return firstNode.item;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        TNode lastNode = sentinelLast.prev;
        sentinelLast.prev = lastNode.prev;
        lastNode.prev.next = sentinelLast;
        size -= 1;
        return lastNode.item;
    }

    public T get(int index){
        if (index + 1 >size ){
            return null;
        }
        TNode p = sentinelBegin;
        int i = 0;
        while(i < index){
            p = p.next;
            i++;
        }
        return p.item;
    }

    public T getRecursive(int index){
        if (index + 1 > size){
            return null;
        }/*还可以写关于是否在1/2的时候的速度更快的算法*/
        if(index == 0){
            return sentinelBegin.next.item;
        }
        return getRecursive(sentinelBegin.next,index-1);
    }

    private T getRecursive(TNode p,int index){

            if(index == 0){
                return p.item;
            }
            return getRecursive(p.next,index - 1);
        }
}