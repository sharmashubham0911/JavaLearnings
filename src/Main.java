import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int arr[] = {12, 3, 6, 1, 6, 9};
        int target = 24;

        System.out.println("called the getTriplate method");

        List<List<Integer>> res = Interview.getTriplateSum(arr, target);

        System.out.println("all triplates are");

        for (int i = 0; i < res.size(); i ++){
            List<Integer> smallRes = res.get(i);
            for (int el: smallRes){
                System.out.print(el + " ");
            }
            System.out.println();
        }

    }
}