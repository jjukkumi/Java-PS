import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Comparator<Map.Entry<? extends Object, Integer>> comparator = new Comparator<>() {
        @Override
        public int compare(Map.Entry<? extends Object, Integer> o1, Map.Entry<? extends Object, Integer> o2) {
            if(o1.getValue()<o2.getValue())
                return 1;
            else if(o1.getValue()>o2.getValue())
                return -1;
            return 0;
            }
        };
        Map<String, Integer> genCntMap = new HashMap<>();
        for (int i=0;i< genres.length;i++){
            if (genCntMap.containsKey(genres[i])) {
                genCntMap.put(genres[i], genCntMap.get(genres[i]) + plays[i]);
            } else {
                genCntMap.put(genres[i], plays[i]);
            }
        }
        List<Map.Entry<String, Integer>> sortedCntList = genCntMap.entrySet().stream().sorted(comparator)
                .collect(Collectors.toList());
        ArrayList<String> sortedKeyList = new ArrayList<>();
        for(int i = 0;i<sortedCntList.size();i++) {
            sortedKeyList.add(sortedCntList.get(i).getKey());
        }
        Map<String, Map<Integer, Integer>> genIdCntMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            if (genIdCntMap.containsKey(genres[i])){
                Map<Integer, Integer> tmpMap = genIdCntMap.get(genres[i]);
                tmpMap.put(i, plays[i]);
                genIdCntMap.put(genres[i], tmpMap);
            } else {
                Map<Integer, Integer> tmpMap = new HashMap<>();
                tmpMap.put(i, plays[i]);
                genIdCntMap.put(genres[i], tmpMap);
            }
        }
        Map<String, List<Map.Entry<Integer, Integer>>> genIdCntListMap = new HashMap<>();
        for (String genre:sortedKeyList){
            genIdCntListMap.put(genre, genIdCntMap.get(genre).entrySet().stream().sorted(comparator).collect(Collectors.toList()));
        }
        ArrayList<Integer> answerList = new ArrayList();
        for(String genre: sortedKeyList){
            List<Map.Entry<Integer, Integer>> oneList = genIdCntListMap.get(genre);
            if (oneList.size() < 2) {
                answerList.add(oneList.get(0).getKey());
            } else {
                for(int i = 0; i < 2; i++){
                    answerList.add(oneList.get(i).getKey());
                }
            }
        }
        return answerList.stream().mapToInt(i->i).toArray();

    }
}