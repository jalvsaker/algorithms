package org.pg4200.ex02;

import org.pg4200.les02.list.MyList;

public class MyBidirectionalLinkedList<T> implements MyList<T> {

    ListNode head;
    ListNode tail;

    int size;

    private class ListNode{
        T value;
        ListNode next;
        ListNode previous;
    }

    /**
     * Delete the element at position "index".
     * <p>
     * Throw an exception if index is invalid
     *
     * @param index
     */
    @Override
    public void delete(int index) {
        if (index == 0){
            if (head.next != null){
                head = head.next;
            }
            else {
                head = null;
                tail = null;
            }
        }
        else if (index == size -1){
            tail.previous.next = null;
            tail = tail.previous;
        }
        else{
            ListNode current;
            int counter;

            if (index <= size/2) {
                current = head;
                counter = 0;
                while (counter != index){
                    current = current.next;
                    counter++;
                }
            } else {
                current = tail;
                counter = size-1;
                while (counter != index){
                    current = current.previous;
                    counter--;
                }
            }
            current.previous.next = current.next;
            current.next.previous = current.previous;
        }

        size--;
    }


    /**
     * Get the value stored in position defined by "index".
     * <p>
     * Throw an exception if index is invalid
     *
     * @param index
     * @return
     */
    @Override
    public T get(int index) {
        checkIndex(index);

        ListNode current;
        int counter;

        if (index <= size/2){
            current = head;
            counter = 0;
            while (current != null){
                if (index == counter){
                    return current.value;
                }
                counter++;
                current = current.next;
            }
        }else {
            current = tail;
            counter = size -1;
            while (current != null){
                if (index == counter){
                    return current.value;
                }
                counter--;
                current = current.previous;
            }
        }

        return null;
    }


    /**
     * Add a new value to the list, at the specified index position.
     * <p>
     * Throw an exception if index is invalid
     *
     * @param index
     * @param value
     */
    @Override
    public void add(int index, T value) {
        ListNode node = new ListNode();
        node.value = value;

        if (head == null) {
            head = node;
            tail = node;
        } else if (index == 0){
            node.next = head;
            head = node;
        } else if (index == size){
            node.previous = tail;

            tail.next = node;
            tail = node;


        } else {
            ListNode previous;
            int counter;
            if (index <= size/2){
                previous = head;
                counter = 0;
                while (counter != index-1){
                    previous = previous.next;
                    counter++;
                }
            } else {
                previous = tail;
                counter = size;
                while (counter != index-1){
                    previous = previous.previous;
                    counter--;
                }
            }
            node.next = previous.next;
            node.previous = previous;
            previous.next = node;
        }

        size++;
    }

    /**
     * Get how many elements this collection has.
     */
    @Override
    public int size() {
        return size;
    }

    private void checkIndex(int i){
        if (i < 0 || i > size -1 ){
            throw new IndexOutOfBoundsException();
        }
    }
}
