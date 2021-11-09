package deque;
public class LinkedListDeque<T>{
    private static int size;
//    private LinkedListNode sentinel;
    public LinkedListNode sentinel;
    private LinkedListNode last;

    public static class LinkedListNode<T>{
        public T value;
        public LinkedListNode next;
        public LinkedListNode pre;
        public LinkedListNode(T v, LinkedListNode n, LinkedListNode p) {
            value = v;
            next = n;
            pre = p;
        }
    }

    public LinkedListDeque() {
        size = 0;
        sentinel = new LinkedListNode(null, null, null);
//        last = new LinkedListNode(null, null, null);
    }

    public void addLast(T x) {
        size += 1;
        if(size == 1) {
            last = new LinkedListNode(x, sentinel, sentinel);
            sentinel.next = last;
            sentinel.pre = last;
            return;
        }
        last.next = new LinkedListNode(x, sentinel, last);
        last = last.next;
        sentinel.pre = last;
    }

    public void addFirst(T x) {
        size += 1;
        if(size == 1) {
            last = new LinkedListNode(x, sentinel, sentinel);
            sentinel.next = last;
            sentinel.pre = last;
            return;
        }
        sentinel.next = new LinkedListNode(x, sentinel.next, sentinel);
    }

    public T removeFirst(){
        if (size > 0) {
            size -= 1;
            T ret = (T) sentinel.next.value;
            sentinel.next = sentinel.next.next;
            return ret;
        }
        return null;
    }

    public T removeLast(){
        if (size > 0) {
            size -= 1;
            T ret = (T) last.value;
            last = last.pre;
            last.next = sentinel;
            return ret;
        }
        return null;
    }

    public T get (int index) {
        if (isEmpty()) {
            return null;
        }
        LinkedListNode p = sentinel.next;
        for(int i=0; i < index; i++) {
            p = p.next;
        }
        return (T) p.value;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printDeque() {
        if (isEmpty()) {
            return ;
        }
        LinkedListNode current = sentinel.next;
        String s = "";
        while(current.next != sentinel) {
            s += (current.value + " ");
            current = current.next;
        }
        s += current.value;
        System.out.println(s);
    }

//    public T getRecursive(int index, LinkedListNode iter=sentinel.next) {
//        if(index == 0) {
//            return (T) iter.value;
//        } else {
//            return getRecursive(--index, iter.next);
//        }
//    }

}