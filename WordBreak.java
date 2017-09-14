package com.company.facebook;

import java.util.Set;

/**
 * Created by Ravneet on 6/20/17.
 */
public class WordBreak {

        public boolean wordBreak(String s, Set<String> dict) {
            return wordBreakHelper(s, dict, 0);
        }

        public boolean wordBreakHelper(String s, Set<String> dict, int index){
            if(index == s.length())
                return true;

            for(String currentWord: dict){
                int currentWordLength = currentWord.length();
                int endIndex = index + currentWordLength;

                //end index should be <= string length
                if(endIndex > s.length())
                    continue;

                if(s.substring(index, endIndex).equals(currentWord))
                    if(wordBreakHelper(s, dict, index+currentWordLength))
                        return true;
            }

            return false;
        }
}
