package examExtrasInterfaces;

public interface PriorityQue <T extends Comparable<T>> extends Queue<T>{


     void swim(T element, int index);
     void sink(T element, int index);

}
