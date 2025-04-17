package SubSequenceAndSubSets;

import java.util.ArrayList;

public class StringsQ {
    public static void main(String[] args) {
//        System.out.println(skipChar("abaacdefabcd",'b'));
//        System.out.println(skipString("aefappleabcd","apple"));

            //subSequences("","abcd");
        System.out.println(subSequencesArrayList("","abcde"));
    }
    static String skipChar(String up, char ch){
        if(up.isEmpty()){
            return "";
        }
        char c=up.charAt(0);
        if(c==ch){
            return skipChar(up.substring(1),ch);
        }
        else{
            return c+ skipChar(up.substring(1),ch);
        }
    }
    static String skipString(String up, String str){
        if(up.isEmpty()){
            return "";
        }

        if(up.startsWith(str)){
            return skipString(up.substring(str.length()),str);
        }
        else{
            return up.charAt(0)+ skipString(up.substring(1),str);
        }
    }

    static void subSequences(String p, String up){
        if(up.isEmpty()){
            System.out.printf("[%s],", p);
            return;
        }
        char ch=up.charAt(0);
        subSequences(p+ch, up.substring(1));
        subSequences(p, up.substring(1));
    }

    static ArrayList<String> subSequencesArrayList(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch=up.charAt(0);
        ArrayList<String> left= subSequencesArrayList(p+ch, up.substring(1));
        ArrayList<String> right=subSequencesArrayList(p, up.substring(1));
        left.addAll(right);
        return left;
    }
}
