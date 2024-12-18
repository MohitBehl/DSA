import java.util.ArrayList;

class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        ArrayList<Int[]> list = new ArrayList<>();

        int i = 0 , j = 0;

        while(i < firstList.length && j < secondList.length){
            int cSP = Math.max(firstList[i][0],secondList[j][0]);
            int cEP = Math.min(firstList[i][1],secondList[j][1]);

            if(cSP <= cEP){
                int interval[] = {cSP,cEP};
                list.add(interval);
            }

            if(firstList[i][1] < secondList[j][1]){
                i++;
            }else{
                j++;
            }
        }

        return list.toArray(new int[list.size()][]);
    }
}