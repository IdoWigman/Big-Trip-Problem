public class Assignment2 {

    // task 1.1
    // No input requirements
    // Checks if the given matrix is a valid instance of the Big Trip Problem
    public static boolean isLegalInstance(boolean[][] matrix) {
        boolean result = false; // default return value
        // ---------------write your code BELOW this line only! ------------------
        if ((matrix != null) && (isSymmetricMatrix(matrix)) && (isAntiReflexiveMatrix(matrix))) {
            result = true;
        }
        // ---------------write your code ABOVE this line only! ------------------
        return result;
    }

    // task 1.2
    // Requires matrix is not null
    // Checks if the matrix is square.
    public static boolean isSquareMatrix(boolean[][] matrix) {
        boolean result = true; // default return value
        // ---------------write your code BELOW this line only! ------------------
        if (matrix == null) {
            throw new IllegalArgumentException("Matrix is null");
        }
        int rows = matrix.length;
        for (int i = 0; i < rows && result; i++) {
            if ((matrix[i] == null) || (matrix[i].length != rows)) {
                result = false;
            }
        }
        // ---------------write your code ABOVE this line only! ------------------
        return result;
    }
    
    // task 1.3
    // Requires matrix is a non-null, square boolean matrix.
    // Checks if the matrix is symmetric.
    public static boolean isSymmetricMatrix(boolean[][] matrix) {
        boolean result = true; // default return value
        // ---------------write your code BELOW this line only! ------------------
        if (!isSquareMatrix(matrix)) {
            throw new IllegalArgumentException("Matrix is not square");
        }
        for (int i = 0; i < matrix.length && result; i++) {
            for (int j = 0; j < matrix[i].length && result; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    result = false;
                }
            }
        }
        // ---------------write your code ABOVE this line only! ------------------
        return result;
    }

    // task 1.4
    // Requires matrix is a non-null, square boolean matrix.
    // Checks if the matrix is anti-reflexive (no self-loops).
    public static boolean isAntiReflexiveMatrix(boolean[][] matrix) {
        boolean result = true; // default return value
        // ---------------write your code BELOW this line only! ------------------
        if (!isSquareMatrix(matrix)) {
            throw new IllegalArgumentException("Matrix is not square");
        }
        for (int i = 0; i < matrix.length && result; i++) {
            result = !matrix[i][i];
        }
        // ---------------write your code ABOVE this line only! ------------------
        return result;
    }

    // task 1.5
    // Requires flights is a boolean matrix representing valid flights
    // and tour is an array of integers matching the size of flights.
    // Validates if the given tour is a correct solution for the flight's matrix.
    public static boolean isValidSolution(boolean[][] flights, int[] tour) {
        boolean result = false; // default return value
        // ---------------write your code BELOW this line only! ------------------
        result = ((areStepsLegal(flights, tour)) && (isPermutation(tour)) && (tour[0] == 0)); // 'areStepsLegal' throws exception on illegal input
        // ---------------write your code ABOVE this line only! ------------------
        return result;
    }

    // task 1.6
    // Requires array is not null
    // Checks if the array is a permutation of numbers from 0 to array.length-1.
    public static boolean isPermutation(int[] array) {
        boolean result = true; // default return value, CHANGED IT TO TRUE.
        // ---------------write your code BELOW this line only! ------------------
        if (array == null) {
            throw new IllegalArgumentException("Array is null");
        }
        for (int i = 0; i < array.length && result; i++) {
            boolean isEqual = false;
            for  (int j = 0; j < array.length && !isEqual; j++) {
                if (array[j] == i) {
                    isEqual = true;
                }
            }
            result = isEqual;
        }
        // ---------------write your code ABOVE this line only! ------------------
        return result;
    }

    // task 1.7
    // Requires flights is a valid instance matrix and tour only includes valid city indices
    // Checks if there are legal flights between consecutive cities in the tour.
    public static boolean areStepsLegal(boolean[][] flights, int[] tour) {
        boolean result = true;
        // ---------------write your code BELOW this line only! ------------------
        if ((tour == null) || !isLegalInstance(flights) || (flights.length == 0) || (flights.length != tour.length)) {
            throw new IllegalArgumentException("Illegal input");
        }
        for (int i = 0; i < flights.length - 1; i++) {
            if ((tour[i] < 0) || (tour[i] >= flights.length)) {
                throw new IllegalArgumentException("Illegal input");
            }
            if (i != flights.length - 1) {
                if (!flights[tour[i]][tour[i+1]]) {
                    result = false;
                }
            }
            else {
                if (!flights[tour[i]][tour[0]]) {
                    result = false;
                }
            }
        }
        // ---------------write your code ABOVE this line only! ------------------
        return result;
    }

    ///////////////////////////////////
    /////// Part 1 ends here ////////
    ///////////////////////////////////

    // Requires n is a non-negative integer.
    // Creates an array of integers from 0 to n-1.
    public static int[] createRange(int n) {
        if (n<0) {
            throw new IllegalArgumentException("n must be non-negative.");
        }
		int[] res = new int[n];
		for (int i = 0; i < n; i++) {
            res[i] = i;
        }
        return res;
    }

    // Requires source and destination arrays are non-null arrays of the same length.
    // Copies the contents of source array into destination array.
    public static void copyArray(int[] source, int[] destination) {
        if (source == null || destination == null || source.length != destination.length) {
            throw new IllegalArgumentException("Source and destination must be initialized arrays of the same length.");
        }
        for (int i = 0; i < source.length; i++) {
            destination[i] = source[i];
        }
    }

    // Requires n is a non-negative integer.
    // Computes the factorial of n.
    public static int factorial(int n) {
        if (n<0) {
            throw new IllegalArgumentException("n must be non-negative.");
        }
        int res = 1;
        for(; n > 1; n--) {
            res = res * n;
        }
        return res;
    }

    // task 2.1
    // Requires n is a positive integer.
    // Generates all permutations of numbers from 0 to n-1 using the Johnson-Trotter algorithm.
    public static int[][] generatePermutations(int n) {
        int[][] result = null; // default return value
        // ---------------write your code BELOW this line only! ------------------
        if (n <= 0) {
            throw new IllegalArgumentException("n isn't positive.");
        }
        int[] permutations = createRange(n);
        int[] directions = new int[n];
        for (int i = 0; i < n; i++) {
            directions[i] = -1;
        }
        int rowsNum = factorial(n); // n! is the number of possible permutations of an array that has n elements in it
        result = new int [rowsNum][n];
        for (int i = 0; i < rowsNum; i++) {
            copyArray(permutations, result[i]);
            int mobileIndex = findMobileIndex(permutations, directions);
            if (mobileIndex != -1) {
                int mobileElement = permutations[mobileIndex];
                swap(permutations, directions, mobileIndex);
                reverseDirections(permutations, directions, mobileElement);
            }
        }
        // ---------------write your code ABOVE this line only! ------------------
        return result;
    }

    // task 2.2
    // Requires permutation and directions are non-null arrays of the same length, directions contains only -1 and 1, and mobileIndex is a valid index in the array.
    // Swaps elements in permutation and directions based on the mobile index.
    public static void swap(int[] permutation, int[] directions, int mobileIndex) {
        // ---------------write your code BELOW this line only! ------------------
        if ((permutation == null) || (directions == null) || (permutation.length != directions.length) || (mobileIndex < 0) || (mobileIndex >= permutation.length)) {
            throw new IllegalArgumentException("Invalid input.");
        }
        for (int i = 0; i < directions.length; i++) {
            if ((directions[i] != -1) && (directions[i] != 1)) {
                throw new IllegalArgumentException("Invalid input.");
            }
        }
        int newMobileIndex = mobileIndex + directions[mobileIndex];
        if ((newMobileIndex >= 0)  && (newMobileIndex < permutation.length)) {
            ///   We'll swap the values in the permutation array   ///
            int swappedValue = permutation[mobileIndex];
            permutation[mobileIndex] = permutation[newMobileIndex];
            permutation[newMobileIndex] = swappedValue;
            ///   We'll now swap the values in the directions array   ///
            swappedValue = directions[mobileIndex];
            directions[mobileIndex] = directions[newMobileIndex];
            directions[newMobileIndex] = swappedValue;
        }
        // ---------------write your code ABOVE this line only! ------------------
    }

    // task 2.3
    // Requires permutation and directions are non-null arrays of the same length, and directions contains only -1 and 1.
    // Reverses the directions of elements greater than the given mobile element.
    public static void reverseDirections(int[] permutation, int[] directions, int mobileElement) {
        // ---------------write your code BELOW this line only! ------------------
        if ((permutation == null) || (directions == null) || (permutation.length != directions.length)) {
            throw new IllegalArgumentException("Invalid input.");
        }
        for (int i = 0; i < directions.length; i++) {
            if ((directions[i] != -1) && (directions[i] != 1)) {
                throw new IllegalArgumentException("Invalid input.");
            }
            if (permutation[i] > mobileElement) {
                directions[i] = -directions[i];
            }
        }
        // ---------------write your code ABOVE this line only! ------------------
    }

    // task 2.4
    // Requires permutation and directions are non-null arrays of the same length, and directions contains only -1 and 1.
    // Finds and returns the index of the largest mobile element or -1 if none exist.
    public static int findMobileIndex(int[] permutation, int[] directions) {
        int result = -1; // default return value
        // ---------------write your code BELOW this line only! ------------------
        if ((permutation == null) || (directions == null) || (permutation.length != directions.length)) {
            throw new IllegalArgumentException("Invalid input.");
        }
        int biggestNum = 0;
        for (int i = 0; i < directions.length; i++) {
            if ((directions[i] != -1) && (directions[i] != 1)) {
                throw new IllegalArgumentException("Invalid input.");
            }
            int adjIndex = i + directions[i];
            if ((adjIndex >= 0) && (adjIndex < permutation.length) && (permutation[i] > permutation[adjIndex])) {
                if ((result == -1) || (permutation[i] > biggestNum)) {
                    result = i;
                    biggestNum = permutation[i];
                }
            }
        }
        // ---------------write your code ABOVE this line only! ------------------
        return result;
    }


    // task 2.5
    // Requires flights is a valid problem instance.
    // Finds a valid solution to the Big Trip Problem using exhaustive search.
    public static int[] solveBigTripProblemExhaustive(boolean[][] flights) {
        int[] result = null; // default return value
        // ---------------write your code BELOW this line only! ------------------
        if (!isLegalInstance(flights)) {
            throw new IllegalArgumentException("Invalid instance.");
        }
        int[][] permutations = generatePermutations(flights.length);
        for (int i = 0; i < permutations.length && result == null; i++) {
            if (isValidSolution(flights, permutations[i])) {
                result = permutations[i];
            }
        }
        // ---------------write your code ABOVE this line only! ------------------
        return result;
    }

    ///////////////////////////////////
    /////// Part 2 ends here ////////
    ///////////////////////////////////

    // Requires flights is a valid instance of the Big Trip Problem.
    // Solves the Big Trip Problem using reduction
    public static int[] solveBigTripProblemReduction(boolean[][] flights) {
        if (!isLegalInstance(flights)) {
            throw new IllegalArgumentException("Flights instance must be valid.");
        }
        boolean[][] encodedFlights = encoder(flights);
        int[] hamiltonianPath = HamiltonianPathSolver.solve(encodedFlights);
        return decoder(hamiltonianPath);
    }

    // task 3.1
    // Requires flights is a valid problem instance.
    // Adds a dummy city to the matrix and returns the new matrix.
    public static boolean[][] encoder(boolean[][] flights) {
        boolean[][] result = null; // default return value
        // ---------------write your code BELOW this line only! ------------------
        if ((!isLegalInstance(flights)) || (flights.length == 0)) {
            throw new IllegalArgumentException("Invalid instance.");
        }
        int newSize = flights.length + 1;
        result = new boolean[newSize][newSize];
        for (int i = 0; i < newSize; i++) {
            int flightsI = i % flights.length; // if i = flights.length than it should represent the first city
            for (int j = 0; j < newSize; j++) {
                int flightsJ = j % flights.length; // same as with i
                result[i][j] = flights[flightsI][flightsJ];
            }
        }
        // ---------------write your code ABOVE this line only! ------------------
        return result;
    }

    // task 3.2
    // Assumes hamiltonianPath is a valid Hamiltonian path or null.
    // Converts the Hamiltonian path back to the original Big Trip Problem solution.
    public static int[] decoder(int[] hamiltonianPath) {
        int[] result = null; // default return value
        // ---------------write your code BELOW this line only! ------------------
        if (hamiltonianPath != null) {
            result = new int[hamiltonianPath.length - 1];
            for (int i = 0; i < result.length; i++) {
                result[i] = hamiltonianPath[i];
            }
        }
        // ---------------write your code ABOVE this line only! ------------------
        return result;
    }

}
