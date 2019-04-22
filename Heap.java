public class Heap<Comparable>{
    private static int DEFAULT_CAPACITY = 10;
    private Comparable[] list;
    private int size;

    public Heap(int initialSize) {
        list = (Comparable[])new Object[initialSize];
        size = 0;
    }

    public Heap() {
        this(DEFAULT_CAPACITY);
    }

    public void add(Comparable data) {
        if (size >= list.length) {
            expand();
        }
        list[size++] = data;
        heapify(size);
    }

    private void expand() {
        Comparable[] temp = (Comparable[])(new Object[list.length*2]);
        for (int i = 0; i < size; i++) {
            temp[i] = list[i];
        }
        list = temp;
    }

    private void heapify(int index) {

    }

    public Comparable remove() {


        return null;
    }



}
