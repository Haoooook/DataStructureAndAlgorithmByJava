package DataStructure.chapter6;

/**
 * 映射
 * 键值对，通过key 找到对应的value
 * key不能重复
 * 有序映射 --->基于搜索树的实现
 * 无序映射 --->基于哈希表的实现
 *
 * @author Damon
 * @create 2020-11-05 22:17
 */
public interface Map<K, V> {
    void add(K key, V value);

    V remove(K key);

    boolean contains(K key);

    V get(K key);

    void set(K key, V newValue);

    int getSize();

    boolean isEmpty();
}
