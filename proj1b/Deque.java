/**
 * Created by jingxin on 12/27/17.
 */
public interface Deque <Item> {
    public void printDeque();
    public Item get(int i);
    public Item getRecursive(int i);
    public void addFirst(Item i);
    public Item removeFirst();
    public void addLast(Item i);
    public Item removeLast();
    public int size();
    public boolean isEmpty();

}
