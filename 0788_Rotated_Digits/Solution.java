class Solution {
    public int rotatedDigits(int N) {
        int res = 0;
        for (int i = 1; i <= N; i++) {
            if (isRotate(i)) {
                res++;
            }
        }
        return res;
    }

    public boolean isRotate(int num) {
        boolean containValid = false;
        while (num > 0) {
            int digit = num % 10;
            switch (digit) {
                case 0:
                case 1:
                case 8:
                    break;
                case 2:
                case 5:
                case 6:
                case 9:
                    containValid = true;
                    break;
                case 3:
                case 4:
                case 7:
                    return false;
            }
            num /= 10;
        }
        return containValid;
    }
}
