package DataStructure.chapter8;

/**
 * 测试segmentTree
 *
 * @author Haoooook
 * @create 2020-11-17 23:25
 */
public class testSegmentTree {
    public static void main(String[] args) {

        Integer[] nums = {4, 0, -1, 99, 100, 21, 9, 17};
//1.第一种方式
//        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, new Merger<Integer>() {
//            @Override
//            public Integer merge(Integer a, Integer b) {
//                return a + b;
//            }
//        });
//第二种方式 Lambda表达式
        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, (a, b) -> a + b);

        System.out.println(segmentTree);
//      [ 249, 102, 147, 4, 98, 121, 26, 4, 0, -1, 99, 100, 21, 9, 17,
//          NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL ]


        System.out.println(segmentTree.query(1, 4));
        System.out.println(segmentTree.query(5, 7));
        System.out.println(segmentTree.query(1, 3));
        System.out.println(segmentTree.query(2, 2));

//        198
//        47
//        98
    }
}
