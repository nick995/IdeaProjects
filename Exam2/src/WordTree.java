public class WordTree {

    Node root;

    public int[] wordLenFreq() {
        int[] frequencies = new int[16];
        wordLenFreq(root, frequencies);
        return frequencies;
    }

    private void wordLenFreq(Node node, int[] frequencies) {
        if (node == null) {
            return;
        } else {
            wordLenFreq(node.left, frequencies);
            frequencies[node.word.length()]++;
            wordLenFreq(node.right, frequencies);
        }
    }

    public void add(String word) {
        root = add(word, root);
    }

    private Node add(String word, Node node) {
        if (node == null) {
            return new Node(word);
        } else {
            if (word.compareTo(node.word) < 0) {
                node.left = add(word, node.left);
                return node;
            } else {
                node.right = add(word, node.right);
                return node;
            }
        }
    }
    private class Node {
        String word;
        Node left;
        Node right;

        public Node(String word) {
            this.word = word;
        }
    }

    public static void main(String[] args) {
        String example = "words go happily into the tree in perfect order as you see";
        WordTree wordTree = new WordTree();

        for(String word : example.split(" ")) {
            wordTree.add(word);
        }
        System.out.println("Words frequencies");
        int[] frequencies = wordTree.wordLenFreq();
        for(int i = 0; i < frequencies.length; i++) {
            System.out.println("Length " + i + " : " + frequencies[i]);
        }
    }
    }
