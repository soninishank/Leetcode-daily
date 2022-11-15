class OrderedStream {
    String[] str;
    int n = 1;

    public OrderedStream(int n) {
        str = new String[n + 1];
    }

    public List<String> insert(int idKey, String value) {
        str[idKey] = value;
        List<String> list = new ArrayList<>();
        if (idKey == n) {
            int temp = n;
            for (int i = temp; i < str.length; i++) {
                if (str[i] != null && str[i].length() > 0) {
                    list.add(str[i]);
                } else {
                    break;
                }
                n++;
            }
        }
        return list;
    }
}
/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */
