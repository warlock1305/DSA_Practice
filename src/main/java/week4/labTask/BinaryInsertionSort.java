package week4.labTask;

public class BinaryInsertionSort {

    public static <Data extends Comparable<Data>> void sort(LinkedList<Data> ll) {
        int fe = 1;
        while(fe != ll.count()){
            ll.add(findInsertionPoint(ll, fe, ll.get(fe)), ll.get(fe));
            ll.remove(fe + 1);
            fe++;
        }
    }

    public static <Data extends Comparable<Data>> int findInsertionPoint(LinkedList<Data> ll, int top, Data key) {
        int bottom = 0;
        while(bottom <= top){
            int mid = bottom + (top - bottom) / 2;
            if(ll.get(mid).compareTo(key) < 0){
                bottom = mid + 1;
            }
            else if(ll.get(mid).compareTo(key) > 0){
                top = mid - 1;
            }
            else{
                return mid;
            }
        }
        return bottom;
    }
}
