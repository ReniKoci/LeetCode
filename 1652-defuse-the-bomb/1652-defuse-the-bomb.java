class Solution {
    public int[] decrypt(int[] code, int k) {
        int[] res = new int[code.length];

        if (k == 0) {
            return res;
        }

        int flag = k > 0 ? 1 : -1;
        for (int i = 0; i < code.length; i++) {
            int j = i + flag, counter = k * flag, sum = 0;
            while (counter > 0) {
                if (j < 0)
                    j = code.length - 1;
                if (j > code.length - 1)
                    j = 0;

                System.out.println(j);

                sum += code[j];
                j += flag;

                counter--;
            }
            res[i] = sum;
        }
        return res;
    }
}