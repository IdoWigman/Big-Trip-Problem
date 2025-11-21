import java.util.HashMap;
import java.util.Map;

public class HamiltonianPathSolver {


    //'flights' is a non-null square boolean matrix.
    //Returns a Hamiltonian path starting at 0 and ending at 'n-1', or null if no path exists
    public static int[] solve(boolean[][] flights) {
        int numberOfVertices = flights.length;
        int[] hamiltonianPath = null;

        if (numberOfVertices == 0) {
            hamiltonianPath = null; // Empty graph has no Hamiltonian path
        } else {
            Map<String, Integer> dynamicTable = new HashMap<>();

            // Base case: Initialize path starting at vertex 0
            dynamicTable.put("1,0", -1); // Bitmask 1 represents visiting only vertex 0

            for (int subsetMask = 1; subsetMask < (1 << numberOfVertices); subsetMask = subsetMask + 1) {
                for (int currentVertex = 0; currentVertex < numberOfVertices; currentVertex = currentVertex + 1) {
                    if ((subsetMask & (1 << currentVertex)) != 0) {
                        for (int previousVertex = 0; previousVertex < numberOfVertices; previousVertex = previousVertex + 1) {
                            if (currentVertex != previousVertex &&
                                    (subsetMask & (1 << previousVertex)) != 0 &&
                                    flights[previousVertex][currentVertex]) {

                                int previousSubsetMask = subsetMask ^ (1 << currentVertex);
                                String previousKey = previousSubsetMask + "," + previousVertex;

                                if (dynamicTable.containsKey(previousKey)) {
                                    dynamicTable.put(subsetMask + "," + currentVertex, previousVertex);
                                }
                            }
                        }
                    }
                }
            }

            int fullMask = (1 << numberOfVertices) - 1;
            int lastVertexInPath = -1;

            if (dynamicTable.containsKey(fullMask + "," + (numberOfVertices - 1))) {
                lastVertexInPath = numberOfVertices - 1;
            }

            if (lastVertexInPath != -1) {
                int[] reconstructedPath = new int[numberOfVertices];
                int currentVertex = lastVertexInPath;
                int currentMask = fullMask;

                for (int pathIndex = numberOfVertices - 1; pathIndex >= 0; pathIndex = pathIndex - 1) {
                    reconstructedPath[pathIndex] = currentVertex;
                    String key = currentMask + "," + currentVertex;
                    currentVertex = dynamicTable.get(key);
                    currentMask = currentMask ^ (1 << reconstructedPath[pathIndex]);
                }

                if (reconstructedPath[0] == 0) { // Ensure the path starts at vertex 0
                    hamiltonianPath = reconstructedPath;
                }
            }
        }

        return hamiltonianPath;
    }
}
