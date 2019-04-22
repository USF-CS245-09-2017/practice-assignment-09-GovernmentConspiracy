//Heavy leaves, light root
public class BinaryHeap{
    private static int DEFAULT_CAPACITY = 10;
    private int[] heap;
    private int size;

    public BinaryHeap(int initialSize) {
        heap = new int[initialSize];
        size = 0;
    }

    public BinaryHeap() {
        this(DEFAULT_CAPACITY);
    }

    public void add(int data) {
        if (size >= heap.length) {
            expand();
        }
        heap[size++] = data;
        siftUp(size-1);
    }

    private void expand() {
        int[] temp = new int [heap.length*2];
        System.arraycopy(heap, 0, temp, 0, heap.length);
        heap = temp;
    }

    private void siftUp(int child) {
        if (child >= 0) {
            int parent = (child - 1)/2;
            if (heap[child] < heap[parent]) {
                swap(parent, child);
                siftUp(parent);
            }
        }
    }

//    private void siftUp(int index) {
//        int data = heap[index];
//        int child = index;
//        int parent = (child - 1)/2;
//
//        while (parent >= 0 && data < heap[parent]) {
//            heap[child] = heap[parent];
//            child = parent;
//            parent = (child - 1)/2;
//        }
//
//        heap[parent] = data;
//    }

    public int remove() {
        if (size == 0)
            throw new IndexOutOfBoundsException();
        int light = heap[0];
        heap[0] = heap[--size];
        siftDown(0);
        return light;
    }

    private void siftDown(int parent) {
        int child1 = 2*parent+1, child2 = child1+1, favorite = parent;
        if (child1 < size && heap[child1] < heap[favorite])
            favorite = child1;
        if (child2 < size && heap[child2] < heap[favorite]) {
            favorite = child2;
        }
        if (parent != favorite) {
            swap(parent, favorite);
            siftDown(favorite);
        }
    }

//    private void siftDown(int index) {
//        int data = heap[index];
//        int parent = index;
//        int child1 = 2*parent+1, child2 = child1+1, favorite;
//        while (parent < size) {
//            if (child2 >= size || heap[child1] < heap[child2]) {
//                favorite = child1;
//            }
//            else {
//                favorite = child2;
//            }
//            if (data < heap[favorite]) {
//                heap[parent] = heap[favorite];
//                parent = favorite;
//                child1 = 2*parent + 1;
//                child2 = child1 + 1;
//            }
//            else
//                break;
//
//        }
//        heap[parent] = data;
//    }

    public int size() {
        return size;
    }

    public void swap(int index1, int index2) {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    public String toString() {
        String display = "[";
        for (int i = 0; i < size - 1; i++) {
            display += heap[i] + ", ";
        }
        if (size > 0)
            display += heap[size-1] + "";
        display += "]";
        return display;
    }


}
