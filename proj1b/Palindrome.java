public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> res = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            res.addLast(word.charAt(i));
        }
        return res;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> wordTransform = wordToDeque(word);
        while (wordTransform.size() > 1) {
            if (wordTransform.removeFirst() != wordTransform.removeLast()) {
                return false;
            }
        }

        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> words = wordToDeque(word);
        while (words.size() > 1) {
            if (!cc.equalChars(words.removeFirst(), words.removeLast())) {
                return false;
            }
        }

        return true;
    }
}