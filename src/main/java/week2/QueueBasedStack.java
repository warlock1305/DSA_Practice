package week2;

public class QueueBasedStack<Data> {
    private Queue<Data> q1;
    private Queue<Data> q2;

    public QueueBasedStack() {
        q2 = new Queue<>();
        q1 = new Queue<>();
    }

    public void push(Data data) {
        q2.enqueue(data);
        while(!q1.isEmpty()){
            q2.enqueue(q1.dequeue());
        }
        while(!q2.isEmpty()){
            q1.enqueue(q2.dequeue());
        }

    }

    public Data pop() {
        return q1.dequeue();
    }

    public Data peek() {
        return q1.peek();
    }

    public int size() {
        return q1.size();
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }
}
