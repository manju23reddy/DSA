import arrays.ContainerWithMostWater.ContainerWithMostWaterKt;
import arrays.hasDuplicate.HasDuplicateKt;

public class DsaMain {


    public static void main(String []args) {
        int[] lengths = {1, 8, 6, 2, 5, 4, 8, 1, 3, 7};
        boolean result = HasDuplicateKt.hasDuplicate(lengths);
        System.out.println(result);
        assert result == true : "Expected false, but got " + result;

    }
}
