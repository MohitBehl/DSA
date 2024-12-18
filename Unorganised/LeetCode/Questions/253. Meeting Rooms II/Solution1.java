class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int st_arr[] = new int[intervals.length];
        int et_arr[] = new int[intervals.length];

        for(int i = 0 ; i < intervals.length ; i++){
            st_arr[i] = intervals[i][0];
            et_arr[i] = intervals[i][1];
        }

        Arrays.sort(st_arr);
        Arrays.sort(et_arr);

        int count = 0 , stPtr = 0, etPtr = 0;

        while(stPtr < intervals.length){
            if(st_arr[stPtr] > et_arr[etPtr]){
                count++;
                stPtr++;
            }else{
                stPtr++;
                etPtr++;
            }
        }

        return count;
    }
}