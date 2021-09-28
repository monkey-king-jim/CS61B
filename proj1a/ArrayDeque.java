public class ArrayDeque<T> {
    T[] items;
    int size;
    int nextFirst = 1;
    int nextLast = nextFirst + 1;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
    }

    public ArrayDeque(T x) {
        items = (T[]) new Object[8];
        items[nextFirst] = x;
        nextFirst -= 1;
        size += 1;
    }

    public ArrayDeque(ArrayDeque<T> other) {
        items = (T[]) new Object[other.items.length];
        size = other.size;
        for (int i = 0; i < size; i++) {
            addLast((T) other.get(i));
        }
    }

    public void resize(int x) {
        T[] resize = (T[]) new Object[x];
        if (x > items.length) {
            System.arraycopy(items, nextLast, resize, 1, items.length - nextLast);
            System.arraycopy(items, 0, resize, 1 + (items.length - nextLast), nextLast);
        } else {
            System.arraycopy(items, nextFirst, resize, 0, Math.min(size + 1, items.length - nextFirst));
            if (nextFirst - nextLast > 0) {
                System.arraycopy(items, 0, resize, nextLast, nextLast - 1);
            }
        }
        nextFirst = 0;
        nextLast = 1 + size;
        items = resize;
    }

    public void addFirst(T x) {
        size += 1;
        items[nextFirst] = x;
        nextFirst -= 1;
        if (nextFirst < 0) {
            nextFirst = items.length - 1;
        }
        if (size == items.length) {
            this.resize(size * 2);
        }
    }

    public void addLast(T x) {
        size += 1;
        items[nextLast] = x;
        nextLast += 1;
        if (nextLast == items.length) {
            nextLast = 0;
        }
        if (size == items.length) {
            this.resize(size * 2);
        }
    }

    public T removeFirst() {
        size -= 1;
        nextFirst += 1;
        T r = items[nextFirst];
        if (nextFirst == items.length) {
            nextFirst = 0;
        }
        if (size == items.length) {
            this.resize(size / 2);
        }
        return r;
    }

    public T removeLast() {
        size -= 1;
        nextLast -= 1;
        T r = items[nextLast];
        if (nextLast < 0) {
            nextLast = items.length - 1;
        }
        if (size == items.length) {
            this.resize(size / 2);
        }
        return r;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        if (nextFirst < nextLast){
            for (int i = 1; i <= size; i++) {
                System.out.print(items[nextFirst + i] + " ");
            }
        } else {
            for (int i = 1; i < items.length - nextFirst; i++) {
                System.out.print(items[nextFirst + i] + " ");
            }
            for (int i = 0; i < nextLast; i++) {
                System.out.print(items[i] + " ");
            }
        }
        System.out.println();
    }

    public T get(int index) {
        if (index + nextFirst < items.length - 1) {
            return items[nextFirst + 1];
        }
        return items[index - (items.length - nextFirst - 1)];
    }
}
