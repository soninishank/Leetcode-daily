class Solution {

    public String destCity(List<List<String>> paths) {
        HashMap<String, Integer> hashmap = new HashMap<>();
        for (List<String> list : paths) {
            String str1 = list.get(0);
            String str2 = list.get(1);
            hashmap.put(str1, hashmap.getOrDefault(str1, 0) - 1);
            hashmap.put(str2, hashmap.getOrDefault(str2, 0) + 1);
        }
        for(String key :hashmap.keySet()){
            if(hashmap.get(key) > 0){
                return key;
            }
        }
        return "";
    }
}
