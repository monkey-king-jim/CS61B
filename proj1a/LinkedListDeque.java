public class LinkedListDeque<Item> {

    private class StuffNode {
        public StuffNode prev;
        public Item item;
        public StuffNode next;

        public StuffNode(Item i, StuffNode p, StuffNode n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    private StuffNode sentinel;
    public int size;

    public LinkedListDeque() {
        sentinel = new StuffNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }
    public LinkedListDeque(Item x) {
        sentinel = new StuffNode(null, null, null);
        sentinel.next = new StuffNode(x, sentinel, sentinel);
        sentinel.prev = sentinel.next;
        size += 1;
    }

    public LinkedListDeque(LinkedListDeque<Item> other) {
        sentinel = new StuffNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;

        for (int i = 0; i < other.size(); i++){
            addLast((Item) other.get(i));
        }
    }

    public void addFirst(Item T) {
        sentinel.next = new StuffNode(T, sentinel, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

    public void addLast(Item T) {
        sentinel.prev = new StuffNode(T, sentinel.prev, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size += 1;

    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        StuffNode p = sentinel.next;
        while (p != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }
    public Item removeFirst() {
        Item r = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size -= 1;
        return r;
    }
    public Item removeLast() {
        Item r = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        return r;
    }

    public Item get(int index) {
        StuffNode g = sentinel.next;
        while (index != 0) {
            g = g.next;
            index -= 1;
        }
        return g.item;
    }

    private Item getRecursive(int index) {
        if (index == 0) {
            return sentinel.next.item;
        } else {
            return getRecursive(index - 1);
        }
    }

}
