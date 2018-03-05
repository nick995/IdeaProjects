//public class Exam {
//
//    public void addInOrder(String data){
//        if(front == null){
//            addAtFront(data);
//        }else {
//            StringNode current = front;
//            while(current.next != null && current.next.data<data){
//                current = current.next;
//            }
//            if(current == front && current.data > data){
//                addAtFront(data);
//            }else{
//                StringNode newNode = new String(data);
//                newNode.next = current.next;
//                current.next = newNode;
//            }
//        }
//
//
//    }
//
//
//    public int[] wordlenFreq(){
//        String str = getDataList(root);
//        if(str.endsWith(",")){
//            str = str.substring(0,str.length()-2);
//        }
//        String[] strList = str.split(",");
//        int[] len = new int[16];
//        for(int index=0; index<16; index++){
//            int count =0;
//            for(int idx =0; idx<strList.length; idx++){
//                count++;
//            }len[index] = count;
//        }
//        return len;
//    }
//
//    private String getDataList(StringNode startNode){
//        String str = "";
//        if(startNode != null){
//            getDataList(startNode.left);
//            str += startNode.data + ",";
//            getDataList(startNode.right);
//        }
//        return str;
//    }
//
//
//
//}
