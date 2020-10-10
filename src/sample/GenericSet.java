package sample;

import java.util.Iterator;

public class GenericSet<E> implements Iterable<E> {
    public GenericSetItem<E> head = null;

    public boolean add(E item){
        if(contains(item)) return false;
        GenericSetItem<E> gsi =new GenericSetItem<>(item);
        gsi.next = head;
        head=gsi;
        return true;
    }
    public GenericSetItem<E> getHead() {
        return head;
    }

    public boolean remove(E item){
        GenericSetItem<E> temp = head, prev=null;
        while (temp!=null && !temp.item.equals(item
        )){
            prev=temp;
            temp=temp.next;
        }
        if(temp!=null){
            if(prev==null){
                head=temp.next;
            }else{
                prev.next = temp.next;
                return true;
            }

        }
        return false;
    }

    public boolean contains(E item){
        for(E x:this){
            if(x.equals(item)){
                return true;
            }
        }
        return false;
    }

    public void clear(){
        head=null;
    }

    @SuppressWarnings("unused")
    public int size(){
        int count = 0;
        for (E x : this)count++;
        return count;
    }

    @Override
    public Iterator<E> iterator(){
        return new GenericSetIterator<E>(head);

    }

    public class GenericSetItem<T>{
        public T item;
        public GenericSetItem<T> next = null;

        public GenericSetItem(T item){
            this.item = item;
        }
    }

    private class GenericSetIterator<T> implements Iterator<T>{
        private GenericSetItem<T>pos;

        public GenericSetIterator(GenericSetItem<T> start){
            pos=start;
        }

        @Override
        public boolean hasNext(){
            return pos !=null;
        }

        @Override
        public T next(){
            GenericSetItem<T> temp = pos;
            pos = pos.next;
            return temp.item;
        }

    }
}
