class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        //in the group anadrom we firstly sort the arr by using the has map
       Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
// convert string into character
            char[] chars = str.toCharArray();
            // short that character
            Arrays.sort(chars);
            // convert back to string
            String key = new String(chars);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
