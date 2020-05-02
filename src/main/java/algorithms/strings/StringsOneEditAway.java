package algorithms.strings;

public class StringsOneEditAway {
    public static void main(String args[]) {
        //true
        System.out.println(run("pale", "ple"));
        System.out.println(run("ple", "pale"));

        System.out.println(run("pales", "pale"));
        System.out.println(run("pale", "pales"));

        System.out.println(run("pale", "bale"));

        //false
        System.out.println(run("pale", "bake"));
        System.out.println(run("pales", "pal"));
    }

    static boolean run(String str1, String str2) {
        String smaller = str1, larger = str2;
        if (str1.length() > str2.length()) {
            smaller = str2;
            larger = str1;
        }
        if(larger.length()-smaller.length() > 1){
            return false;
        }
        boolean diffFlag = false;
        for (int i = 0, j = 0; i < smaller.length(); i++, j++) {
            if (smaller.charAt(i) != larger.charAt(j)) {
                if (diffFlag) {
                    return false;
                }

                diffFlag = true;
                //on mismatch, move one more char in bigger string
                if (smaller.length() != larger.length()) {
                    j++;
                }
            }
        }
        return true;
    }
}
