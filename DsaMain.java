import arrays.ContainerWithMostWaterKt;

public class DsaMain {


    public static void main(String []args) {
        int[] lengths = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result = ContainerWithMostWaterKt.ContainerWithMostWater(lengths);
        System.out.println(result);
        assert result == 49 : "Expected 49, but got " + result;

    }
}
