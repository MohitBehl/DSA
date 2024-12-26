package TopicWise.arraysAndStrings.intervalPattern;

import java.util.Arrays;

public class Main {
    static Main main = new Main();
    public int[] getMinMax(int[][] intervals){
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int[] interval: intervals){
            min = Math.min(min,interval[0]);
            max = Math.max(max,interval[1]);
        }

        return new int[]{min, max};
    }
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0 || intervals.length == 1)
            return 0;

        int[] minMax = getMinMax(intervals);

        int[] range = new int[minMax[1] - minMax[0] + 1];

        for(int[] interval: intervals){
            int sp = interval[0] - minMax[0] , ep = interval[1] - minMax[0];
            range[sp]++;
            range[ep]--;
        }

        int res = range[0];
        for(int i = 1 ; i < range.length ; i++){
            range[i] = range[i] + range[i-1];
            res = Math.max(res,range[i]);
        }

        return res-1;
    }
    public static void main(String[] args){
        int[][] intervals = testCases(4);
        System.out.println(main.eraseOverlapIntervals(intervals));
    }

    public static int[][] testCases(int tcNum){
        return switch (tcNum){
            case 1 -> new int[][]{{1,2},{2,3},{3,4},{1,3}};
            case 2 -> new int[][]{{1,2},{1,2},{1,2}};
            case 3 -> new int[][]{{1,2},{2,3}};
            default -> new int[][]{};
        };
    }
}
