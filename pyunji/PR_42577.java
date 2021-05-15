class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        Map<Character, ArrayList<String>> preMap = new HashMap<>();
        Stream.of(phone_book).forEach(num->{
            char key = num.charAt(0);
            if (preMap.containsKey(key)) {
                ArrayList<String> tmpVal = preMap.get(key);
                tmpVal.add(num);
                preMap.put(key, tmpVal);
            } else {
                ArrayList<String> tmpVal = new ArrayList<>();
                tmpVal.add(num);
                preMap.put(key, tmpVal);
            }
        });
        for(char key:preMap.keySet()){
            ArrayList<String> valList = preMap.get(key);
            for(int i = 0; i< valList.size()-1; i++) {
                if(valList.get(i + 1).startsWith(valList.get(i)))
                    return false;
            }
        }

        return true;
    }
}