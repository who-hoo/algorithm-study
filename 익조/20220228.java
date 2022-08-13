class Solution {
    
    int[] numbers;
    int target;
    int maxIndex;
    int result = 0;
    
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        maxIndex = numbers.length;
        dfs(0, 0);
        
        return result;
    }
    
    public void dfs(int index, int sum) {
        if (index == maxIndex) return;
        if (index == maxIndex -1 && (sum + numbers[index]) == target) result++;
        if (index == maxIndex -1 && (sum - numbers[index]) == target) result++;

        dfs(index + 1, sum + numbers[index]);
        dfs(index + 1, sum - numbers[index]);
    }
}
