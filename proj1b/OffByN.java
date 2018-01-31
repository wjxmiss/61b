/**
 * Created by jingxin on 12/27/17.
 */
public class OffByN implements CharacterComparator {

    private int Offset;

    public OffByN(int N){
        Offset = N;
    }

    @Override
    public boolean equalChars(char x, char y){
        return (x - y == Offset || x - y == -Offset);
    }
}
