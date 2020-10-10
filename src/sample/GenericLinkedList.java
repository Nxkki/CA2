package sample;

import java.util.Iterator;

public class GenericLinkedList<G> implements Iterable<G> {
    public GenericNode<G> head = null;
static int size =0;
    int numElem = 0;

    public GenericNode<G> getHead() {
        return head;
    }

    public void setHead(GenericNode<G> head) {
        this.head = head;
    }


    public void addElement(G e) {
        GenericNode<G> gn = new GenericNode<>();
        gn.setContents(e);
        gn.next = head;
        head = gn;
        size++;
        numElem++;
    }

    @Override
    public Iterator<G> iterator() {
        return new GenericIterator<G>(head);
    }

    public void clear() {
        head = null;
    }

    public void setNumElem() {
        GenericNode temp = head;
        this.numElem=0;
        while(temp != null) {
            this.numElem++;
            temp = temp.next;
        }
    }
    public int size() {
        return numElem;

    }
    public G getElement(int index) {
        GenericNode temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;

        }
        return  (G) temp.getContents();

    }

    public GenericNode<G> getNode(int index) {
        GenericNode<G> temp= getHead();
        for (int i = 0; i < index; i++) {
            temp = temp.next;

        }
        return  temp;
    }

    public  void setElement(int index, G e) {
        getNode(index).setContents(e);

    }


    public void swopNode(G e){
        GenericNode temp = head;
        GenericNode tmp = temp.next;
        GenericNode tempest = null;
        if (temp.getContents()== e){
            tempest.setContents(tmp);
            tmp.setContents(temp);
            temp.setContents(tmp);

        }
    }

//    public void clear() {
//        head = null;
//    }

}
