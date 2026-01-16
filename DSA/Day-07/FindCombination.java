import java.util.*;


public class FindCombination {
    static void generateCombinations(int[] arr, int n, int r, int index, List<Integer> temp, List<List<Integer>> res){
        // base case: if the combination is of size r, add it to results
        if(temp.size() == r){
            res.add(new ArrayList<>(temp));
            return;
        }
        // start from the current index and try to build combinations
        for(int i = index; i < n; i++){
            temp.add(arr[i]);
            generateCombinations(arr, n, r, i + 1, temp, res);
            temp.remove(temp.size() - 1); // backtrack
        }
    }
    static List<List<Integer>> findCombination(int[] arr, int r){
        int n = arr.length;

        // to store all combinations
        List<List<Integer>> res = new ArrayList<>();

        // temporary list to store current combination
        List<Integer> temp = new ArrayList<>();
        generateCombinations(arr, n,  r, 0, temp, res);
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int r = 2;
        List<List<Integer>> combinations = findCombination(arr, r);
        System.out.println("Combinations of size " + r + " are: ");
        for(List<Integer> comb : combinations){
            System.out.print(comb + " ");
        }
    }
    
}
