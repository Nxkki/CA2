package sample;

import java.util.Iterator;

public class GenericIterator<B> implements Iterator<B> {

    private GenericNode<B> pos;

    public GenericIterator(GenericNode<B> gnode) {
        pos = gnode;
    }

    public boolean hasNext() {
        return pos != null;
    }

    public B next() {
        GenericNode<B> temp = pos;
        pos = pos.next;
        return temp.getContents();
    }
}

class GenericNode<A>{
        public GenericNode<A> next =null;
        private A contents;

        public A getContents() {
            return contents;
        }

        public void setContents(A c) {
            contents = c;
        }
    }


