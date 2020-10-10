package sample;

import java.util.*;

public class FastHashSC<E> {
    public  GenericLinkedList<E>[] hashTable;

    @SuppressWarnings("unchecked")
    public FastHashSC(int size) {
        hashTable=(GenericLinkedList<E>[])new GenericLinkedList [size];
        for(int i=0;i<hashTable.length;i++)
            hashTable[i]=new GenericLinkedList<>();
    }

    public void displayHashTable() {
        int num=1;
        for(GenericLinkedList<E> lis : hashTable){
            System.out.println("Chain "+num++);
            System.out.println("===========");
            for(E item: lis) {
                System.out.println(item);
            }
        }
    }


    public int hashFunction(E obj) {
        return obj.hashCode()%hashTable.length;
    }

    public int hashFunctiond(Drink drink){
        return drink.hashCode()%hashTable.length;
    }
    public int hashFunction1(String obj) {
        return obj.hashCode()%hashTable.length;
    }

    public int hashFunction2(int key) {

        return key%hashTable.length;
    }

    public GenericLinkedList<E>[] getHashTable() {
        return hashTable;
    }

    public void add(E item) {
        hashTable[hashFunction(item)].addElement(item);
    }

//    public void add(GenericSet<Drink>.GenericSetItem<Drink> item) {
//        hashTable[hashFunction(GenericSet<Drink>.GenericSetItem<Drink> item)].addElement(item);
//    }

    public void add(E item, int key) {

        hashTable[hashFunction2(key)].addElement(item);
    }

    public void add(E item, String key) {
        hashTable[hashFunction1(key)].addElement(item);
    }

//    public void search(int key){
//
//     int hashIndex = hashCode(((int)key));
//    }

    public void clear(){
        for (int i = 0; i < hashTable.length; i++)
            hashTable[i].setHead(null);
    }
    public GenericLinkedList<E>  getLinkListAtElement(int elementIndex) {

        return hashTable[hashFunction2(elementIndex)];
    }

    public static void main(String[] args){


        //fh.add("Pat"); //Adding with hashing based on object's own hashcode, or...

       // Main1.ingrednts.add(,41); //Adding with a key to use to hash with etc.
//        fh.add("Timmy",41);
//        fh.add("Tim",42);

       // fh.displayHashTable();

    }

}
