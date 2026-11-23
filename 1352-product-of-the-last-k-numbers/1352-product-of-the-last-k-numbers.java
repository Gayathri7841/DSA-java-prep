class ProductOfNumbers {
List<Integer> list;
    public ProductOfNumbers() {
        list=new ArrayList<>();
    }
    
    public void add(int num) {
        list.add(num);

    }
    
    public int getProduct(int k) {
        int n=list.size();
        int mul=1;
        for(int i=n-1;i>=n-k;i--){
mul=mul*list.get(i);
        }
        return mul;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */