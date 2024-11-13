package hashMapSet.findDifference;

import java.util.*;

class Solution {
    /**
     * findDifferenceメソッドは、2つの整数配列nums1とnums2を受け取り、
     * nums1にのみ含まれる要素と、nums2にのみ含まれる要素をそれぞれリストとして返します。
     * 手順は以下の通りです：
     *  1. 2つのセットを作成し、それぞれnums1とnums2の要素を追加します。
     *     これにより、各配列内の重複が取り除かれ、ユニークな要素のみがセットに含まれます。
     *  2. set1に含まれていて、set2に含まれていない要素をリストに追加します。
     *  3. 同様に、set2に含まれていて、set1に含まれていない要素をリストに追加します。
     * 
     * @param nums1 配列1
     * @param nums2 配列2
     * @return 2つのサブリストからなるリスト。1つ目のサブリストはnums1にのみ存在する要素、2つ目はnums2にのみ存在する要素です。
     */
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();                           // nums1の要素を保持するためのハッシュセット
        Set<Integer> set2 = new HashSet<>();                           // nums2の要素を保持するためのハッシュセット
        
        for(int num : nums1) { 
            set1.add(num);                                             // nums1の全ての要素をset1に追加
        }
        for(int num : nums2) { 
            set2.add(num);                                             // nums2の全ての要素をset2に追加
        }
        
        List<List<Integer>> resultList = new ArrayList<>();            // 結果リストを初期化
        resultList.add(new ArrayList<>());                             // 1つ目のサブリストを追加
        resultList.add(new ArrayList<>());                             // 2つ目のサブリストを追加

        for(int num : set1) {                                          // set1の各要素を順にチェック
            if(!set2.contains(num)) {                                  // set2に存在しない要素であれば
                resultList.get(0).add(num);                            // 結果リストの1つ目のサブリストに追加
            }
        }

        for(int num : set2) {                                          // set2の各要素を順にチェック
            if(!set1.contains(num)) {                                  // set1に存在しない要素であれば
                resultList.get(1).add(num);                            // 結果リストの2つ目のサブリストに追加
            }
        }

        return resultList;                                             // 最終的な結果リストを返す
    }
}
