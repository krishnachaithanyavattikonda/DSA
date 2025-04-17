package ProbableAmazonQA;

import java.util.*;

public class WordLadder {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Edge case: endWord not in wordList
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return 0;
        }
        // BFS queue and visited set
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int level = 1;

        // BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                // Try all possible transformations
                for (int j = 0; j < word.length(); j++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        String newWord = word.substring(0, j) + c + word.substring(j + 1);
                        if (!visited.contains(newWord) && dict.contains(newWord)) {
                            if (newWord.equals(endWord)) {
                                return level + 1;
                            }
                            queue.offer(newWord);
                            visited.add(newWord);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}