import java.util.*;
public class Practice {
    public static final int code = 97;
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String strNum = "abcdfdsa";
        int alphabet[] = new int[26];
        char ch;
        int chcode;

        for(int i=0; i<strNum.length(); i++) {
            ch = strNum.charAt(i);
            chcode = ch - code;
            alphabet[chcode]++;
        }

        for(int i=0; i<26; i++){
            if(alphabet[i] !=0 )
                System.out.printf("%c-%d\n", i+97,alphabet[i]);
        }
    }
}

