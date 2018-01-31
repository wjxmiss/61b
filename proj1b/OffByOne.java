/**
 * Created by jingxin on 12/27/17.
 */
public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char x, char y){
        return (x - y == 1 || x - y == -1);
    }
}
