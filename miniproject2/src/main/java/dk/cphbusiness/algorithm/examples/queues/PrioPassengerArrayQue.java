package dk.cphbusiness.algorithm.examples.queues;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;


import dk.cphbusiness.airport.template.Passenger;

public class PrioPassengerArrayQue implements PriorityQueue<Passenger> {

  private final Passenger[] items;
  private int size = 0;
  private int head = 0; // index of the current front item, if one exists
  private int tail = 0; // index of next item to be added

  public PrioPassengerArrayQue(int capacity) {
    // items = (T[])new Object[capacity];
    items = new Passenger[capacity];
  }

  public synchronized void enqueue(Passenger item) {
    if (size == items.length)
      throw new IllegalStateException("Cannot add to full queue");
    items[tail] = item;
    tail = (tail + 1) % items.length;
    size++;
  }

  public synchronized Passenger dequeue() {
    if (size == 0)
    throw new NoSuchElementException("Cannot remove from empty queue");
    
    if (size > 1) {
      HeapSort<Passenger> hs = new HeapSort<Passenger>(prio());
      Passenger[] newArray = Arrays.copyOfRange(items, head % items.length, tail % items.length);
      hs.heapSort(newArray);
      for (int k = 0; k < newArray.length; k++) {
        items[head + k] = newArray[k];
      }
      if(!checkForAnyError(items, head, tail)){
        System.out.println("IT WENT WRONG, FIX YOUR ALGO!!!!!!!!!!!!!11111");
        System.out.println("IT WENT WRONG, FIX YOUR ALGO!!!!!!!!!!!!!11111");
        System.out.println("IT WENT WRONG, FIX YOUR ALGO!!!!!!!!!!!!!11111");
        System.out.println("IT WENT WRONG, FIX YOUR ALGO!!!!!!!!!!!!!11111");
        System.out.println("IT WENT WRONG, FIX YOUR ALGO!!!!!!!!!!!!!11111");
        System.out.println("IT WENT WRONG, FIX YOUR ALGO!!!!!!!!!!!!!11111");
        System.out.println("IT WENT WRONG, FIX YOUR ALGO!!!!!!!!!!!!!11111");
        System.out.println("IT WENT WRONG, FIX YOUR ALGO!!!!!!!!!!!!!11111");
        System.out.println("IT WENT WRONG, FIX YOUR ALGO!!!!!!!!!!!!!11111");
      }
    }

    Passenger item = items[head];

    


    item = items[head];

    System.out.println("WILL NOW DEQUE : " + item.getCategory().toString());
    
        for (int i = head; i < tail; i++) {
          System.out.println(items[i].getCategory().toString());
        }
        try {
          Thread.sleep(200);
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
    
    items[head] = null;
    head = (head + 1) % items.length;
    size--;

    return item;
  }

  public Passenger peek() {
    if (size == 0)
      throw new NoSuchElementException("Cannot peek into empty queue");
    return items[head];
  }

  public int size() {
    return size;
  }

  public Comparator<Passenger> prio() {
    Comparator<Passenger> comparePassenger = new Comparator<Passenger>() {
      @Override
      public int compare(Passenger s1, Passenger s2) {
        if (s1.getCategory().ordinal() > s2.getCategory().ordinal()) {
          return -1;
        }
        if (s1.getCategory().ordinal() == s2.getCategory().ordinal()) {
          return 0;
        }
        if (s1.getCategory().ordinal() < s2.getCategory().ordinal()) {
          return 1;
        }
        return 0;
      }
    };

    return comparePassenger;
  }

  public boolean checkForAnyError(Passenger[] arr, int start, int end)  {
    Passenger p = arr[start];
    Comparator<Passenger> comparator = prio();
    for (int i = start+1; i < end; i++) {
      if(comparator.compare(p, arr[i]) < 0){
        return false;
      }
    }

    return true;
  }

}