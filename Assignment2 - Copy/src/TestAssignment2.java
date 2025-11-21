import java.util.Arrays;

public class TestAssignment2 {
    public static void main(String[] args){

		// Test task 1.1
        boolean[][] flights = {{false, false, true, true},
                                {false, false, true, true},
                                {true, true, false, true},
                                {true, true, true, false}};
        testIsLegalInstance(flights, true);

        // Test task 1.2
        boolean[][] matrix1 = {{false,false},{true,true}};
        testIsSquareMatrix(matrix1, true);
        boolean[][] matrix2 = {{true,false,true},{false,false}};
        testIsSquareMatrix(matrix2, false);
        boolean[][] matrix3 = {};
        testIsSquareMatrix(matrix3, true);

		// Test task 1.3
        boolean[][] matrix4 = {{false,false,true},{false,false,true},{true,true,true}};
        testIsSymmetricMatrix(matrix4, true);

		// Test task 1.4
        boolean[][] matrix5 = {{false,false},{true,false}};
        testIsAntiReflexiveMatrix(matrix5, true);
        boolean[][] matrix6 = {{false,false},{true,true}};
        testIsAntiReflexiveMatrix(matrix6, false);

		// Test task 1.5
        int[] tour = {0,2,1,3};
        testIsValidSolution(flights, tour, true);

		// Test task 1.6
        int[] array1 = {0,2,1,3};
        testIsPermutation(array1, true);
        int[] array2 = {1,4,3,2};
        testIsPermutation(array2, false);

		// Test task 1.7
        testAreStepsLegal(flights, tour, true);

		// Test task 2.1
        int[][] perm1 = {{0,1},{1,0}};
        testGeneratePermutations(2, perm1);
        int[][] perm2 = {{0,1,2},{0,2,1},{2,0,1},{2,1,0}, {1,2,0},{1,0,2}};
        testGeneratePermutations(3, perm2);

		// Test task 2.2
        int[] permutation1 = {0,1,2};
        int[] directions1 = {-1,-1,-1};
        int[] postPermutation1 = {0,2,1};
        int[] postDirections1 = {-1,-1,-1};
        testSwap(permutation1, directions1, 2, postPermutation1, postDirections1);
        int[] permutation2 = {2,1,0};
        int[] directions2 = {1,-1,-1};
        int[] postPermutation2 = {1,2,0};
        int[] postDirections2 = {-1,1,-1};
        testSwap(permutation2, directions2, 0, postPermutation2, postDirections2);

		// Test task 2.3
        int[] permutation3 = {0,1,3,2};
        int[] directions3 = {1,-1,1,-1};
        int[] postDirections3 = {1,-1,-1,1};
        testReverseDirections(permutation3, directions3, 1, postDirections3);
        int[] permutation4 = {4,1,3,2,0};
        int[] directions4 = {1,-1,1,-1,1};
        int[] postDirections4 = {-1,1,-1,1,1};
        testReverseDirections(permutation4, directions4, 0, postDirections4);

		// Test task 2.4
        int[] permutation5 = {0,1,3,2};
        int[] directions5 = {-1,1,-1,1};
        testFindMobileIndex(permutation5, directions5, 2);
        int[] permutation6 = {0,2,1,3};
        int[] directions6 = {-1,-1,1,1};
        testFindMobileIndex(permutation6, directions6, 1);

		// Test task 2.5
        int[] tour1 = {0,3,1,2};
        testSolveBigTripProblemExhaustive(flights, tour1);

		// Test task 3.1
        boolean[][] postFlights = {{false, false, true, true, false},
                                {false, false, true, true, false},
                                {true, true, false, true, true},
                                {true, true, true, false, true},
                                {false, false, true, true, false}};
        testEncoder(flights, postFlights);

		// Test task 3.2
        int[] tour2 = {0,2,1};
        testDecoder(tour, tour2);
    }


    // Test task 1.1
    public static void testIsLegalInstance(boolean[][] matrix, boolean output) {
        String result = "";
        if (Assignment2.isLegalInstance(matrix) == output){
            result = "Success";
        }
        else{
            result = "Failed";
        }
        System.out.println("Testing isLegalInstance: input = "+arrayToString(matrix)+ "; Expected output= " + output + "; --> "+result);
    }

    // Test task 1.2
    public static void testIsSquareMatrix(boolean[][] matrix, boolean output) {
        String result = "";
        if (Assignment2.isSquareMatrix(matrix) == output){
            result = "Success";
        }
        else{
            result = "Failed";
        }
        System.out.println("Testing isSquareMatrix: input = "+arrayToString(matrix)+ "; Expected output= " + output + "; --> "+result);
    }

    // Test task 1.3
    public static void testIsSymmetricMatrix(boolean[][] matrix, boolean output) {
        String result = "";
        if (Assignment2.isSymmetricMatrix(matrix) == output){
            result = "Success";
        }
        else{
            result = "Failed";
        }
        System.out.println("Testing isSymmetricMatrix: input = "+arrayToString(matrix)+ "; Expected output= " + output + "; --> "+result);
    }

    // Test task 1.4
    public static void testIsAntiReflexiveMatrix(boolean[][] matrix, boolean output) {
        String result = "";
        if (Assignment2.isAntiReflexiveMatrix(matrix) == output){
            result = "Success";
        }
        else{
            result = "Failed";
        }
        System.out.println("Testing isAntiReflexiveMatrix: input = "+arrayToString(matrix)+ "; Expected output= " + output + "; --> "+result);
    }

    // Test task 1.5
    public static void testIsValidSolution(boolean[][] flights, int[] tour, boolean output) {
        String result = "";
        if (Assignment2.isValidSolution(flights, tour) == output){
            result = "Success";
        }
        else{
            result = "Failed";
        }
        System.out.println("Testing isValidSolution: input = "+arrayToString(flights) +", "+ Arrays.toString(tour)+ "; Expected output= " + output + "; --> "+result);
    }

    // Test task 1.6
    public static void testIsPermutation(int[] array, boolean output) {
        String result = "";
        if (Assignment2.isPermutation(array) == output){
            result = "Success";
        }
        else{
            result = "Failed";
        }
        System.out.println("Testing isPermutation: input = "+Arrays.toString(array)+ "; Expected output= " + output + "; --> "+result);
    }

    // Test task 1.7
    public static void testAreStepsLegal(boolean[][] flights, int[] tour, boolean output) {
        String result = "";
        if (Assignment2.areStepsLegal(flights, tour) == output){
            result = "Success";
        }
        else{
            result = "Failed";
        }
        System.out.println("Testing areStepsLegal : input = "+arrayToString(flights) +", " + Arrays.toString(tour)+ "; Expected output= " + output + "; --> "+result);
    }

    // Test task 2.1
    public static void testGeneratePermutations(int n, int[][] output) {
        String result = "";
        // permutations generated by Johnson's algorithm in deterministic manner
        if (Arrays.deepEquals(Assignment2.generatePermutations(n), output)){
            result = "Success";
        }
        else{
            result = "Failed";
        }
        System.out.println("Testing generatePermutations: input = " + n+ "; Expected output= " + Arrays.deepToString(output) + "; --> "+result);
    }

    // Test task 2.2
    public static void testSwap(int[] permutation, int[] directions, int mobileIndex, int[] newPermutation, int[] newDirections) {
        String result = "";
        Assignment2.swap(permutation, directions, mobileIndex);
        if (Arrays.equals(permutation, newPermutation) && Arrays.equals(directions, newDirections)){
            result = "Success";
        }
        else{
            result = "Failed";
        }
        System.out.println("Testing swap: input = "+Arrays.toString(permutation) +", "
            + Arrays.toString(directions) + ", " + mobileIndex + "; Expected output= "
            + Arrays.toString(newPermutation) +", " + Arrays.toString(newDirections) + "; --> "+result);
    }

    // Test task 2.3
    public static void testReverseDirections(int[] permutation, int[] directions, int mobileElement, int[] newDirections) {
        String result = "";
        Assignment2.reverseDirections(permutation, directions, mobileElement);
        if (Arrays.equals(directions, newDirections)){
            result = "Success";
        }
        else{
            result = "Failed";
        }
        System.out.println("Testing reverseDirections: input = "+Arrays.toString(permutation) +", "
            + Arrays.toString(directions) + ", " + mobileElement + "; Expected output= "
            + Arrays.toString(newDirections) + "; --> "+result);
    }

    // Test task 2.4
    public static void testFindMobileIndex(int[] permutation, int[] directions, int output) {
        String result = "";
        if (Assignment2.findMobileIndex(permutation, directions) == output){
            result = "Success";
        }
        else{
            result = "Failed";
        }
        System.out.println("Testing findMobileIndex: input = "+Arrays.toString(permutation) +", "
            + Arrays.toString(directions) + "; Expected output= " + output + "; --> "+result);
    }

    // Test task 2.5
    public static void testSolveBigTripProblemExhaustive(boolean[][] flights, int[] output) {
        String result = "";
        if (Assignment2.isValidSolution(flights,
                Assignment2.solveBigTripProblemExhaustive(flights))){
            result = "Success";
        }
        else{
            result = "Failed";
        }
        System.out.println("Testing solveBigTripProblemExhaustive: input = "+ arrayToString(flights)+ "; Expected output= " + Arrays.toString(output) + "; --> "+result);
    }

    // Test task 3.1
    public static void testEncoder(boolean[][] flights, boolean[][] output) {
        // Note: Should test if original flights array wasn't changed?
        String result = "";
        if (Arrays.deepEquals(Assignment2.encoder(flights), output)){
            result = "Success";
        }
        else{
            result = "Failed";
        }
        System.out.println("Testing encoder: input = "+arrayToString(flights)+ "; Expected output= " + arrayToString(output) + "; --> "+result);
    }

    // Test task 3.2
    public static void testDecoder(int[] hamiltonianPath, int[] output) {
        String result = "";
        if (Arrays.equals(Assignment2.decoder(hamiltonianPath), output)){
            result = "Success";
        }
        else{
            result = "Failed";
        }
        System.out.println("Testing decoder: input = "+ Arrays.toString(hamiltonianPath)+ "; Expected output= " + Arrays.toString(output) + "; --> "+result);
    }

	//return an inline string representing the array
    public static String arrayToString(boolean[][] array) {
        String result = "";
        if (array == null) {
            result = null;
        }
        else {
            result = result + "{";
            for (int i = 0; i < array.length; i=i+1) {
                result = result + "{";
                for (int j = 0; j < array[i].length; j=j+1) {
                    result = result + array[i][j];
                    if (j < array[i].length - 1) {
                        result = result+ ",";
                    }
                }
                result = result + "}";
                if (i < array.length - 1) {
                    result = result + ",";
                }
            }
            result = result + "}";
        }
        return result;
    }
}