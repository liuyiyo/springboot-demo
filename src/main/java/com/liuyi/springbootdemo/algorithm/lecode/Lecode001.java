package com.liuyi.springbootdemo.algorithm.lecode;

import java.util.*;

/**
 * @ClassName Lecode001
 * @description：给一非空的单词列表，返回前 k 个出现次数最多的单词。
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 * //考点：hash表+排序。hash表+优先队列
 * @author：liuyi
 * @Date：2021/5/20 9:57
 */
public class Lecode001 {
    // 示例
//    输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
//    输出: ["i", "love"]
//    解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
//    注意，按字母顺序 "i" 在 "love" 之前。
    public static void main(String[] args) {
        String[] strArray = new String[]{"i", "love", "leetcode", "i", "love", "coding", "love", "leetcode"};
        System.out.println(topKFrequentLy(strArray, 4));
    }


    public static List<String> topKFrequent(String[] words, int k) {
        //获取每个单词的数量，放到map中
        Map<String, Integer> cnt = new HashMap<String, Integer>();
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }
        //获取所有的单词集合
        List<String> rec = new ArrayList<String>();
        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
            rec.add(entry.getKey());
        }
        Collections.sort(rec, new Comparator<String>() {
            public int compare(String word1, String word2) {
                return cnt.get(word1) == cnt.get(word2) ? word1.compareTo(word2) : cnt.get(word2) - cnt.get(word1);
            }
        });
        return rec.subList(0, k);
    }

    public static List<String> topKFrequentFast(String[] words, int k) {
        int len = words.length;
        String[] keys = new String[len];
        int[] values = new int[len];
        for (int i = 0; i < len; i++) {
            // 去掉符号位
            int hash = (words[i].hashCode() & 0x7FFFFFFF) % len;
            // 防止hash冲突
            while (!words[i].equals(keys[hash]) && values[hash] > 0) {
                hash = (hash + 1) % len;
            }
            keys[hash] = words[i];
            values[hash]++;
        }
        // 这里采用优先级队列利用String默认字典序比较器
        PriorityQueue<String>[] counts = new PriorityQueue[len + 1];
        for (int i = 0; i < len; i++) {
            int value = values[i];
            if (value > 0) {
                if (counts[value] == null) {
                    counts[value] = new PriorityQueue<>();
                }
                counts[value].add(keys[i]);
            }
        }
        // 将存有计数信息的数组counts从后向前遍历k个word
        List<String> result = new ArrayList<>(k);
        for (int i = counts.length - 1; i >= 0; i--) {
            PriorityQueue<String> heap = counts[i];
            if (heap != null) {
                while (!heap.isEmpty()) {
                    result.add(heap.poll());
                    k--;
                    if (k == 0) {
                        return result;
                    }
                }
            }
        }
        return result;
    }

    /**
     * @return java.util.List<java.lang.String>
     * @Author liuyi
     * @Description
     * @Date 2021/5/20 14:18
     * @Param [words, k]
     **/
    public static List<String> topKFrequentLy(String[] words, int k) {
        //获取单词的个数
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        //通过优先队列来获取前K个字符串（个数从大大小排列，个数相同按照自然顺序排列）
        PriorityQueue<Map.Entry<String, Integer>> priorityQueue =
                new PriorityQueue<Map.Entry<String, Integer>>((o1, o2) -> {
                    return o1.getValue() == o2.getValue() ? o1.getKey().compareTo(o2.getKey())
                            : o2.getValue() - o1.getValue();
                });
        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            priorityQueue.add(stringIntegerEntry);
        }
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            strings.add(priorityQueue.poll().getKey());
        }
        return strings;
    }


}
