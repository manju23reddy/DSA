import arrays.ContainerWithMostWater.ContainerWithMostWaterKt;
import arrays.hasDuplicate.HasDuplicateKt;
import sliding_window.consequtive_sum_to_target.ConsequtiveSumtToTargetKt;

public class DsaMain {


    public static void main(String []args) {
        int[] lengths = {1, 8, 6, 2, 5, 4, 8, 1, 3, 7};
        boolean result = ConsequtiveSumtToTargetKt.consequtiveSumToTarget(
                lengths, 100
        );
        System.out.println(result);
        assert result == true : "Expected false, but got " + result;

    }
}
