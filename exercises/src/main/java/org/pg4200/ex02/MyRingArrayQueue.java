package org.pg4200.ex02;

import org.pg4200.les02.queue.MyQueue;

public class MyRingArrayQueue<T> implements MyQueue<T> {

    protected Object[] data;

    private int head = -1;
    private int tail = -1;

    public MyRingArrayQueue() {
        this(10);
    }

    public MyRingArrayQueue(int capacity){
        data = new Object[capacity];
    }
    /**
     * Insert a new element at the tail of the queue/line
     *
     * @param value
     */
    @Override
    public void enqueue(T value) {
        if (isEmpty()){
            head = 0;
            tail = 0;
        } else if (head <= tail) {
            if (tail < data.length - 1){
                tail++;
            } else {
                if (head != 0){
                    tail = 0;
                } else {
                    Object[] newArray = new Object[data.length * 2];

                    System.arraycopy(data, 0,
                            newArray, 0, data.length);

                    data = newArray;
                    tail++;
                }
            }
        } else {
            if (tail < head - 1){
                tail++;
            } else {
                Object[] newArray = new Object[data.length * 2];

                int k = data.length - head;
                for (int i = 0; i < k; i++) {
                    newArray[i] = data[head + i];
                }

                for (int i = 0; i < tail + 1; i++) {
                    newArray[k+i] = data[i];
                }

                head = 0;
                tail = data.length;
                data = newArray;
            }
        }
        data[tail] = value;
    }

    /**
     * Remove and return the element at the head of the queue/line
     */
    @Override
    public T dequeue() {
        T value = (T) data[head];

        if (size() == 1){
            head = -1;
            tail = -1;
        } else {
            head++;
            if (head >= data.length){
                head = 0;
            }
        }

        return value;
    }

    /**
     * Look at the head of the queue/line, without removing it
     */
    @Override
    public T peek() {
        return (T) data[head];
    }

    @Override
    public int size() {
        if (head < 0){
            return 0;
        }
        if (head == tail){
            return 1;
        }
        if (head < tail){
            return tail - head + 1;
        } else {
            int size = 0;
            size += (data.length - head);
            size += tail +1;
            return size;
        }
    }
}
