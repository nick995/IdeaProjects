public class NonUniqueTree<T extends Comparable<T>> {

    private NonUniqueNode<T> root;
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

    private NonUniqueNode<T> add(T data, int index, NonUniqueNode<T> startNode) {
        if (startNode == null) {
            size = size + 1;
            return new NonUniqueNode<>(data, index);
        } else {
            if (data.compareTo(startNode.data) < 0) {
                startNode.left = add(data, index, startNode.left);
                return startNode;
            } else {
                startNode.right = add(data, index, startNode.right);
                return startNode;
            }
        }
    }


    public Integer[] getPositionData() {
        Integer[] positions = new Integer[size];
        getPositionData(root, positions);
        index = 0;  // clear index;
        return positions;
    }

    private void getPositionData(NonUniqueNode<T> node, Integer[] positions) {
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

    public class NonUniqueNode<T> {
        public T data;
        public NonUniqueNode left;
        public NonUniqueNode right;
        public DupNode<T> same;
        public int arrayIndex;

        /**
         * Constructor for the UniqueNode class
         */
        private NonUniqueNode(T data, int arrayIndex) {
            this.data = data;
            this.arrayIndex = arrayIndex;
        }

    }
    public class DupNode<T>
    {
        public DupNode<T> next;
        public int arrayIndex;
        /**
         * Constructor for the DupNode class
         */
        public DupNode(int arrayIndex)
        {
            this.arrayIndex = arrayIndex;
        }
    }

}