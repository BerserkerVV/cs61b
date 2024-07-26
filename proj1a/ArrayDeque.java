public class ArrayDeque<Item>{
    private Item[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    private static final int INIT_CAPACITY = 8;

    public ArrayDeque() {
        items = (Item[]) new Object[INIT_CAPACITY];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    public ArrayDeque(ArrayDeque<Item> other) {
        items = (Item[]) new Object[other.items.length];
        size = other.size;
        nextFirst = other.nextFirst;
        nextLast = other.nextLast;
        System.arraycopy(other.items, 0, items, 0, other.items.length);

    }
    public void resize(int capacity) {
        Item[] newItems = (Item[]) new Object[capacity];
        int currentIndex = plusOne(nextFirst);
        for (int i = 0; i < size; i++){
            newItems[i] = items[currentIndex];
            currentIndex = plusOne(currentIndex);
        }
        items = newItems;
        nextFirst = capacity - 1;
        nextLast = size;

    }

    private int minusOne(int index) {
        return (index - 1 + items.length) % items.length;
    }

    private int plusOne(int index) {
        return (index + 1) % items.length;
    }

    public void addFirst(Item x){
        if(size == items.length){
            resize(size * 2);
        }
        items[nextFirst] = x;
        size += 1;
        minusOne(nextFirst);
    }
    public void addLast(Item x){
        if(size == items.length){
            resize(size * 2);
        }
        items[nextLast] = x;
        size = size + 1;
        plusOne(nextLast);
    }

    public Item get(int index) {
        if (index < 0 || index >= size){
            return null;
        }
        int currentIndex = (plusOne(nextFirst) + index) % items.length;
        return items[currentIndex];
    }

    public Item removeFirst() {
        Item x = items[plusOne(nextFirst)];
        nextFirst = (nextFirst);
        size --;
        if (items.length >= 16 && size < items.length / 4) {
            resize(items.length / 2);
        }
        return x;
    }

    public Boolean isEmpty() {
        return size == 0;
    }
    public Item removeLast() {
        if(isEmpty()){
            return null;
        }
        Item x = items[minusOne(nextLast)];
        nextLast =  minusOne(nextLast);
        size --;
        if (items.length >= 16 && size < items.length / 4) {
            resize(items.length / 2);
        }
        return x;
    }

    public int size() {
        return size;
    }





}