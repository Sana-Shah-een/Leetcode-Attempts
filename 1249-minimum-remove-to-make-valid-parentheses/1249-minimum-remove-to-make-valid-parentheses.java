class Solution {
    public String minRemoveToMakeValid(String s) {
        
        char[] arr = s.toCharArray();
        int n = arr.length;

        int index = 0;
        int open = 0;

        // PASS 1 → remove extra ')'
        for (int i = 0; i < n; i++) {
            char ch = arr[i];

            if (ch == '(') {
                open++;
                arr[index++] = ch;
            }
            else if (ch == ')') {
                if (open > 0) {
                    open--;
                    arr[index++] = ch;
                }
            }
            else {
                arr[index++] = ch;
            }
        }

        // PASS 2 → remove extra '('
        int finalIndex = index - 1;

        for (int i = finalIndex; i >= 0; i--) {
            if (arr[i] == '(' && open > 0) {
                open--;
            } else {
                arr[finalIndex--] = arr[i];
            }
        }
        int start=finalIndex+1;
        int length=index-start;
        return new String(arr, start,length);
    }
}
