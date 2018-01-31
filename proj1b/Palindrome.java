/**
 * Created by jingxin on 12/27/17.
 */

public class Palindrome {

    public Palindrome(){};

    public static Deque<Character> wordToDeque(String word){
        Deque<Character> res = new ArrayDequeSolution<>();
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            res.addLast(c);
        }
        return res;
    }

    public static boolean isPalindrome(String word, CharacterComparator cc){
        int l = word.length();
        for(int i = 0; i < l / 2; i++){
            if(!cc.equalChars(word.charAt(i), word.charAt(l - 1 - i)))
                return false;
        }
        return true;
    }


    public static boolean isPalindrome(String word){
        int l = word.length();
        for(int i = 0; i < l / 2; i++){
            if(word.charAt(i) != word.charAt(l - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean helper(Deque<Character> d, int i){
        if(i >= d.size() / 2)    return true;
        if(d.get(i) != d.get(d.size() - i - 1)) return false;
        return helper(d, i + 1);
    }

    public static boolean isPalindrome(Deque<Character> d){
        return helper(d, 0);
    }

    public static void main(String[] args){
        Deque<Character> d = wordToDeque("abba");
        //d.printDeque();
        //System.out.println(isPalindrome(d));
        //System.out.println(isPalindrome("abba"));
        CharacterComparator cc1 = new OffByOne();
        System.out.println(isPalindrome("flake", cc1));
        CharacterComparator cc2 = new OffByN(5);
        System.out.println(isPalindrome("fgala", cc2));
    }
}
