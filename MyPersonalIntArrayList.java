package mycollections;

import java.util.Arrays;

public class MyPersonalIntArrayList {

    private int[] array;
    private int size;


    public MyPersonalIntArrayList() {
        this(10);
    }

    public MyPersonalIntArrayList(int capacity) {
        this.array = new int[capacity];
    }

    public MyPersonalIntArrayList(MyPersonalIntArrayList array) {
        this();
        this.size = array.size();
        for (int i = 0; i < array.size(); i++) {
            this.array[i] = array.get(i);
        }

    }

    public int size() {
        return this.size;
    }

    public void clear() {
        this.size = 0;
    }

    public int get(int index) {
        return this.array[index];
    }

    public void add(int index, int element) {
        if (this.size == array.length) {
            this.array = Arrays.copyOf(this.array, this.array.length * 2);
        }

        for (int i = size; i > index; i--) {
            this.array[i] = this.array[i - 1];
        }

        this.array[index] = element;
        this.size++;
    }

    public boolean add(int element) {
        if (this.size == array.length) {
            this.array = Arrays.copyOf(this.array, this.array.length * 2);
        }

        this.array[size] = element;
        this.size++;

        return true;
    }

    public boolean contains(int element) {
        for (int i = 0; i < this.size; i++) {
            if (element == array[i]) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(int element) {
        for (int i = 0; i < size; i++) {
            if (this.array[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(int element) {
        for (int i = size; i >= 0; i--) {
            if (array[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public boolean remove(int element) {
        int index = -1;

        for (int i = 0; i < this.size; i++) {
            if (this.array[i] == element) {
                index = i;
                break;
            }
        }

        for (int i = index; i < this.size - 1; i++) {
            this.array[i] = this.array[i + 1];
        }
        this.size--;
        return index != -1;
    }

    public int removeElementAtIndex(int index) {

        if (index > size - 1) {
            System.out.println("Eroare");
            return -1;
        }

        for (int i = index; i < this.size - 1; i++) {
            this.array[i] = this.array[i + 1];
        }
        this.size--;
        return index;
    }

    public int set(int index, int element) {
        if (index > size - 1) {
            System.out.println("Eroare");
            return -1;
        }
        this.array[index] = element;
        return element;
    }

    public boolean addAll (MyPersonalIntArrayList array) {
        if (array.size() == 0) {
            return false;
        }

        int newArrayCapacity = this.size + array.size();
        int iterator = 0;

        for (int i = this.size; i < newArrayCapacity; i++) {
            this.size++;
            if (this.size == this.array.length) {
                this.array = Arrays.copyOf(this.array, this.array.length * 2);
            }
            this.array[i] = array.get(iterator++);
        }

        return true;
    }

    public boolean addAll(int index, MyPersonalIntArrayList array) {
        if (array.size() == 0) {
            return false;
        }

        // Creez un nou array in care retin elemente de la "index" pana la this.size
        int[] croppedArray = new int[this.size - index];
        int iterator = 0;
        for (int i = index; i < this.size; i++) {
            croppedArray[iterator++] = this.array[i];
        }

        // Populez array-ul local (incepand cu pozitia index primita ca paramatru)
        // cu MyIntArrayList primit ca parametru
        iterator = 0;
        for (int i = index; i < this.array.length; i++) {
            this.array[i] = array.get(iterator++);
        }

        // La final dau append elementele retinute anterior in "croppedArray"
        for (int i = 0; i < croppedArray.length; i++) {
            add(croppedArray[i]);
        }

        return true;
    }

    public void ensureCapacity(int minCapacity) {
        if (minCapacity < this.size) {
            return;
        }
        this.size = minCapacity;
    }

    public void trimToSize() {
        this.array = Arrays.copyOf(this.array, size);
    }

    public int[] toArray() {
        int[] array = new int[this.size];
        for (int i = 0; i < this.size; i++) {
            array[i] = this.array[i];
        }
        return array;
    }

    public String toString() {
        return Arrays.toString(toArray());
    }

}

