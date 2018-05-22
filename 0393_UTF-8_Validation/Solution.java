class Solution {
    public boolean validUtf8(int[] data) {
        int i = 0;
        while (i < data.length) {
            if ((data[i] & 0b10000000) == 0) {
                i++;
            } else if ((data[i] & 0b11100000) == 0b11000000) {
                if (isFollower(data, i + 1)) {
                    i += 2;
                } else {
                    return false;
                }
            } else if ((data[i] & 0b11110000) == 0b11100000) {
                if (isFollower(data, i + 1) && isFollower(data, i + 2)) {
                    i += 3;
                } else {
                    return false;
                }
            } else if ((data[i] & 0b11111000) == 0b11110000) {
                if (isFollower(data, i + 1) && isFollower(data, i + 2) && isFollower(data, i + 3)) {
                    i += 4;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean isFollower(int[] data, int i) {
        if (i >= data.length) return false;
        return (data[i] & 0b11000000) == 0b10000000;
    }
}
