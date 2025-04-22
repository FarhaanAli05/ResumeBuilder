package FinalProject;

/*
 * Date: June 16, 2022
 * Author: Farhaan Ali
 * Description: Queue class; stores objects in indices, which make up a queue
 */
public class Queue {
    private int front, end, maxSize;
    private Category[] data;
    
    // Constructors
    public Queue() {
        front = -1;
        end = -1;
        data = new Category[0];
        maxSize = data.length;
    }
    
    public Queue(int size) {
        front = -1;
        end = -1;
        data = new Category[size];
        maxSize = data.length;
    }
    
    // Methods
    
    /*
    *  Pre: Receives no input
    *  Post: Returns first element of queue
    *  Description: Returns the first object entered into queue
    */
    public Category front() {
        return data[front];
    }
    
    /*
    *  Pre: Receives no input
    *  Post: Returns last element of queue (if queue contains elements)
    *  Description: Retrieves the last object entered into queue
    */
    public String end() {
        if (!isEmpty()) {
            return data[end] + "";
        }
        return "Empty"; // Indicates if queue is empty
    }
    
    /*
    *  Pre: Receives no input
    *  Post: Returns true if the queue's front and end references point to index -1
    *  Description: Indicates if the queue is empty
    */
    public boolean isEmpty() {
        return front == -1 && end == -1; // Index -1 is invalid
    }
    
    /*
    *  Pre: Receives no input
    *  Post: Returns length between front and end indices plus 1
    *  Description: Returns number of objects in queue
    */
    public int size() {
        if (!isEmpty()) {
            int diff = end - front; // Difference of end and front indices in queue (end moves as elements are added)
            if (diff < 0) {
                diff = maxSize + diff; // If element is enqueued after it is full, end minus front will be smaller than 0; length of queue is added
            }
            return diff + 1; // Difference is increased by 1 as front and end values are indices
        }
        return 0;
    }
    
    /*
    *  Pre: Receives no input
    *  Post: Sets queue's front and end indices as -1, effectively evading all of its contents
    *  Description: Empties queue
    */
    public void makeEmpty() {
        front = -1;
        end = -1;
    }
    
    /*
    *  Pre: Receives no input
    *  Post: Returns true if the queue has as many elements as its size
    *  Description: Indicates if the queue is full
    */
    public boolean isFull() {
        return front == 0 && end == data.length - 1; // Queue length is decreased by 1 because end is an index value
    }
    
    /*
    *  Pre: Receives inputted name
    *  Post: Occupies space in queue with inputted name, and cyclces to front if queue is empty
    *  Description: Adds object to front of queue
    */
    public void enque(Category n) {
        if (isEmpty()) {
            front++;
            end++;
            data[end] = n;
        } else {
            end = (end + 1) % maxSize; // If item is enqueued after queue is full, overwrites first item in queue with new item
            data[end] = n;
        }
    }
    
    /*
    *  Pre: Receives no input
    *  Post: Replaces element at front of queue with following element and returns dequeued element
    *  Description: Removes object from queue
    */
    public String dequeue() {
        if (!isEmpty()) {
            Category temp = data[front]; // Stores front value before it is dequeued
            front = (front + 1) % data.length; // Overwrites front value with one after it
            maxSize--; // Reduces size of queue by 1 to effectively remove value
            return temp + ""; // Returns dequeued value
        }
        return "Already empty";
    }
    
    /*
    *  Pre: Receives no input
    *  Post: Returns number of spaces within queue/string array
    *  Description: Returns length of queue
    */
    public int length() {
        return data.length;
    }
}