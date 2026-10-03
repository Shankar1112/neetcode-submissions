class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = height[left], rightMax = height[right];
        int total = 0;
        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(height[left], leftMax);
                total +=  leftMax - height[left];
            } else {
                right--;                
                rightMax = Math.max(height[right], rightMax);
                total +=  rightMax - height[right];
            }
        }
        return total;
    }
}
