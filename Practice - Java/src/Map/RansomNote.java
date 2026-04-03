package Map;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] m = new int[26];
        for (char c : magazine.toCharArray())
            m[c - 'a']++;
        for (char c : ransomNote.toCharArray()) {
            if (m[c - 'a']-- == 0)
                return false;
        }
        return true;
    }
}
