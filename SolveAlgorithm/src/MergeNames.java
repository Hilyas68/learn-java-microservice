import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeNames {

    public static List<String> uniqueNames(String[] names1, String[] names2) {
        //= Arrays.asList(names1);
        //List<String> merger = Arrays.asList(names1);
        List<String> merger = new ArrayList<>();
        Collections.addAll(merger, names1);
        for (String string : names2) {
            if (!isInArray(merger, string)) {
                merger.add(string);
            }
        }
        return merger;
    }

    public static boolean isInArray(List<String> strArr, String name){
        for (String s : strArr){
            if(name.equals(s)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] names1 = new String[]{"Ava", "Emma", "Olivia"};
        String[] names2 = new String[]{"Olivia", "Sophia", "Emma"};
        for (String string : MergeNames.uniqueNames(names1, names2)) {
            System.out.println(string); // should print Ava, Emma, Olivia, Sophia
        }

    }
}
