class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        
        for (int h = 0; h < 12; h++) {        // Hours: 0-11
            for (int m = 0; m < 60; m++) {    // Minutes: 0-59
                // Count total 1s in hour and minute
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    // Format time: hour no leading zero, minute 2 digits
                    String time = h + ":" + (m < 10 ? "0" + m : m);
                    result.add(time);
                }
            }
        }
        
        return result;
    }
}