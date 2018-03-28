class Solution {
    public String getHint(String secret, String guess) {
        int bull = 0, cow = 0;
        int[] number = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bull++;
            } else {
                if (number[secret.charAt(i) - '0'] < 0) {
                    cow++;
                }
                if (number[guess.charAt(i) - '0'] > 0) {
                    cow++;
                }
                number[secret.charAt(i) - '0']++;
                number[guess.charAt(i) - '0']--;
            }
        }
        return bull + "A" + cow + "B";
    }
}
