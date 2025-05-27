package com.liang.springcore.licode;

//to remove next a*
//input a*a*
//output a*
//input a*a*a*
//output a*
//intput a*a*b
//output a*b
//input a*a*a*b
//output a*b
//input a*a*a*ba*
//output a*ba*
public class RepeatSubStringRemover {
    public static void main(String[] args) {
        RepeatSubStringRemover remover = new RepeatSubStringRemover();
        String str, expected, reduced;

        str = "a";
        expected ="a";
        reduced = remover.removeSubstring(str);
        System.out.println(reduced);
        assert reduced.equalsIgnoreCase(expected);

        str = "a*";
        expected ="a*";
        reduced = remover.removeSubstring(str);
        System.out.println(reduced);
        assert reduced.equalsIgnoreCase(expected);

        str = "a*a";
        expected ="a*a";
        reduced = remover.removeSubstring(str);
        System.out.println(reduced);
        assert reduced.equalsIgnoreCase(expected);

        str = "a*a*";
        expected ="a*";
        reduced = remover.removeSubstring(str);
        System.out.println(reduced);
        assert reduced.equalsIgnoreCase(expected);

        str = "a*a*a*";
        expected ="a*";
        reduced = remover.removeSubstring(str);
        System.out.println(reduced);
        assert reduced.equalsIgnoreCase(expected);

        str = "a*a*a*a*";
        expected ="a*";
        reduced = remover.removeSubstring(str);
        System.out.println(reduced);
        assert reduced.equalsIgnoreCase(expected);

        str = "a*a*b";
        expected ="a*b";
        reduced = remover.removeSubstring(str);
        System.out.println(reduced);
        assert reduced.equalsIgnoreCase(expected);

        str = "a*a*bb";
        expected ="a*bb";
        reduced = remover.removeSubstring(str);
        System.out.println(reduced);
        assert reduced.equalsIgnoreCase(expected);

        str = "a*a*a*a*b";
        expected ="a*b";
        reduced = remover.removeSubstring(str);
        System.out.println(reduced);
        assert reduced.equalsIgnoreCase(expected);

        str = "a*a*a*a*bb";
        expected ="a*bb";
        reduced = remover.removeSubstring(str);
        System.out.println(reduced);
        assert reduced.equalsIgnoreCase(expected);

        str = "a*a*a*a*ba*";
        expected ="a*ba*";
        reduced = remover.removeSubstring(str);
        System.out.println(reduced);
        assert reduced.equalsIgnoreCase(expected);

        str = "a*a*a*a*ba*a*";
        expected ="a*ba*";
        reduced = remover.removeSubstring(str);
        System.out.println(reduced);
        assert reduced.equalsIgnoreCase(expected);

        str = "a*a*a*a*ba*a*cc";
        expected ="a*ba*cc";
        reduced = remover.removeSubstring(str);
        System.out.println(reduced);
        assert reduced.equalsIgnoreCase(expected);

        str = "a*a*a*a*ba*a*ccc";
        expected ="a*ba*ccc";
        reduced = remover.removeSubstring(str);
        System.out.println(reduced);
        assert reduced.equalsIgnoreCase(expected);

        str = "a*a*a*a*ba*a*ccc.*.*";
        expected ="a*ba*ccc.*";
        reduced = remover.removeSubstring(str);
        System.out.println(reduced);
        assert reduced.equalsIgnoreCase(expected);

        str = "a*a*a*a*ba*a*ccc.*.*.*";
        expected ="a*ba*ccc.*";
        reduced = remover.removeSubstring(str);
        System.out.println(reduced);
        assert reduced.equalsIgnoreCase(expected);


    }
    public RepeatSubStringRemover() {}
    public String removeSubstring(String pattern) {
        if (pattern.length() < 4) {
            return pattern;
        }
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < pattern.length() -2) {
            if (pattern.charAt(index + 1) != '*') {
                sb.append(pattern.charAt(index));
                index++;
            } else { //index + 1 = *
                sb.append(pattern.charAt(index));
                sb.append(pattern.charAt(index + 1)); //append *
                String substring = pattern.substring(index + 2);
                StringBuilder cut = new StringBuilder();
                while (removeFromHead(substring, pattern.charAt(index), pattern.charAt(index + 1), cut)){
                    substring = cut.toString();
                    cut.setLength(0); //delete all
                    index = index + 2;
                }
                //move index forward
                index = index + 2;
            }
        }
        for (int i = index; i < pattern.length(); i++) {
            sb.append(pattern.charAt(i));
        }
        return sb.toString();
    }
    public boolean removeFromHead(String source, char firstChar, char secondChar, StringBuilder builder ) {
        if (source.length() < 2) {
            return false;
        } else {
            if (source.charAt(0) == firstChar && source.charAt(1) == secondChar) {
                builder.append(source.substring(2));
                return true;
            } else {
                return false;
            }
        }
    }

}
