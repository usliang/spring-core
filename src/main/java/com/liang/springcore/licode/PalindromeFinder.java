package com.liang.springcore.licode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class PalindromeFinder {
    public static void main(String[] args) {
        String s = "qbmhukucteihghldwdobtvgwwnhflpceiwhbkmvxavmqxedfndegztlpjptpdowwavemasyrjxxnhldnloyizyxgqlhejsdylvkpdzllrzoywfkcamhljminikvwwvqlerdilrdgzifojjlgeayprejhaequyhcohoeonagsmfrqhfzllobwjhxdxzadwxiglvzwiqyzlnamqqsastxlojpcsleohgtcuzzrvwzqugyimaqtorkafyebrgmrfmczwiexdzcokbqymnzigifbqzvfzjcjuugdmvegnvkgbmdowpacyspszvgdapklrhlhcmwkwwqatfswmxyfnxkepdotnvwndjrcclvewomyniaefhhcqkefkyovqxyswqpnysafnydbiuanqphfhfbfovxuezlovokrsocdqrqfzbqhntjafzfjisexcdlnjbhwrvnyabjbshqsxnaxhvtmqlfgdumtpeqzyuvmbkvmmdtywquydontkugdayjqewcgtyajofmbpdmykqobcxgqivmpzmhhcqiyleqitojrrsknhwepoxawpsxcbtsvagybnghqnlpcxlnshihcjdjxxjjwyplnemojhodksckmqdvnzewhzzuswzctnlyvyttuhlreynuternbqonlsfuchxtsyhqlvifcxerzqepthwqrsftaquzuxwcmjjulvjrkatlfqshpyjsbaqwawgpabkkjrtchqmriykbdsxwnkpaktrvmxjtfhwpzmieuqevlodtroiulzgbocrtiuvpywtcxvajkpfmaqckgrcmofkxynjxgvxqvkmhdbvumdaprijkjxxvpqnxakiavuwnifvyfolwlekptxbnctjijppickuqhguvtoqfgepcufbiysfljgmfepwyaxusvnsratn";
        int times = 2000;
        long start = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            System.out.println(findPalindromeV3(s));
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
    public static String findPalindromeV1(String s) {
        int longest = s.length();
        while (longest > 1 ) {
            for (int i = 0; i <= s.length() - longest; i++) {
                String sub = s.substring(i, i + longest);
                if (isPalindrome(sub.toCharArray())) {
                    return sub;
                }
            }
            longest--;
        }
        return s.substring(0, 1);
    }

    public static String findPalindromeV3(String s) {
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        List<Future<String>> futures = new ArrayList<>();
        int longest = s.length();
        String result;
        while (longest > 1) {
            for (int i = 0; i <= s.length() - longest; i++) {
                String sub = s.substring(i, i + longest);
                Callable<String> callable = () -> checkPalindrome(sub);
                futures.add(executor.submit(callable));
            }

            for (Future<String> future : futures) {
                try {
                    result = future.get();
                    if (result != null) {
                        return result;
                    }
                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e);
                }
            }
            longest--;
        }
        executor.shutdown();
        return s.substring(0, 1);
    }

    public static String findPalindromeV2(String s) {
        int longest = 1;
        StringBuilder sb = new StringBuilder(s);
        String longestStr = "";
        while (longest <= sb.length() ) {
            int start = 0;
            boolean found = false;
            while (start <= sb.length() - longest) {
                String sub = sb.substring(start, start + longest);
                if (isPalindrome(sub.toCharArray())) {
                    //save the candidate
                    longestStr = sub;
                    found = true;
                    //expand the found from left
                    /*
                    for (int left = start-1; left >= 0; left--) {
                       if (isPalindrome(sb.substring(left, start + longest).toCharArray())) {
                           longestStr = sb.substring(left, start + longest);
                       }else {
                           break;
                       }
                    }
                    */
                    //expand the found from right
                    for (int right = start + longest + 1; right <= sb.length(); right++) {
                        if (isPalindrome(sb.substring(start, right).toCharArray())) {
                            longestStr = sb.substring(start, right);
                        }else {
                            break;
                        }
                    }
                    //expand from both side
                    int left = start -1;
                    int right = start + longest + 1;
                    while (left >= 0 && right < sb.length()) {
                        if (isPalindrome(sb.substring(left, right).toCharArray())) {
                            longestStr = sb.substring(left, right);
                            left--;
                            right++;
                        }else {
                            break;
                        }
                    }
                    longest = longestStr.length() + 1;
                    break;
                }else {
                    start++;
                }
            }
            if (found) {
                longest = longestStr.length() + 1;
            }else {
                longest++;
            }
        }
        return longestStr;
    }


    public static   boolean isPalindrome(char[] input) {
        if (input.length == 1) {
            return  true;
        }

        for (int i = 0; i < input.length / 2; i++) {
            if (input[i] != input[input.length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static   String checkPalindrome(String str) {
        char[] input = str.toCharArray();
        if (input.length == 1) {
            return  str;
        }

        for (int i = 0; i < input.length / 2; i++) {
            if (input[i] != input[input.length - i - 1]) {
                return null;
            }
        }
        return str;
    }
}
