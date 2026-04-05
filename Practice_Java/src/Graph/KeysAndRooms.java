package Graph;

import java.util.List;

public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        boolean[] finalList = new boolean[rooms.size()];

        finalList = search(finalList, rooms , 0);

        for(boolean b : finalList){
            if(!b){
                return b;
            }
        }

        return true;
    }
    public boolean[] search(boolean[] finalList, List<List<Integer>> rooms, int row){
        if(finalList[row]){
            return finalList;
        }else{
            finalList[row] = true;
        }
        List<Integer> traverseRow = rooms.get(row);
        for(int a = 0 ; a < traverseRow.size() ; a++){
            finalList = search(finalList, rooms, traverseRow.get(a));
        }
        return finalList;
    }
}
