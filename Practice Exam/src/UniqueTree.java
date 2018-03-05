public class UniqueTree<T extends Comparable<T>> {

private UniqueNode<T> root;
private int size;
private int index;

/**
 * Constructor for the RankingIndex class
 */


/**
 * Mutators for RankingIndex class
 * <p>
 * Add nodes into the binary search tree
 */

public void add(T data, int index) {
        root = add(data, index, root);
        }

private UniqueNode<T> add(T data, int index, UniqueNode<T> node) {
        if (node == null) {
        size = size + 1;
        return new UniqueNode<>(data, index);
        } else {
        if (data.compareTo(node.data) < 0) {
        node.left = add(data, index, node.left);
        return node;
        } else {
        node.right = add(data, index, node.right);
        return node;
        }
        }
        }

public Integer[] getPositionData() {
        Integer[] positions = new Integer[size];
        getPositionData(root, positions);
        index = 0;  // clear index;
        return positions;
        }

private void getPositionData(UniqueNode<T> node, Integer[] positions) {
        if (node == null) {
        return;
        } else {
        getPositionData(node.left, positions);
        positions[index] = node.arrayIndex;
        index = index + 1;
        getPositionData(node.right, positions);
        }
        }

public Integer[] getPositionData(T min, T max) {
        Integer[] positions = new Integer[size];

        // TODO: implement

        return positions;
        }

public class UniqueNode<T> {
    public T data;
    public UniqueNode left;
    public UniqueNode right;
    public int arrayIndex;

    /**
     * Constructor for the UniqueNode class
     */
    private UniqueNode(T data, int arrayIndex) {
        this.data = data;
        this.arrayIndex = arrayIndex;
    }

    /**
     * Accessors for UniqueNode class
     * <p>
     * Get the information of this node and return it
     */
    public String toString() {
        String report = "";
        report += "Ranking    : " + data + "\n";
        report += "Array index: " + arrayIndex + "\n";
        return report;
    }
}


}