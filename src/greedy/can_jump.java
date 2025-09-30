package greedy;

public class can_jump {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxlen = 0; // 当前能到的最远距离
        for (int i = 0; i < n; i++) {
            if (i > maxlen) {
                return false; // 到不了这个点
            }
            maxlen = Math.max(maxlen, i + nums[i]);
            if (maxlen >= n-1) { // 可以到达
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        can_jump obj = new can_jump();
        System.out.println(obj.canJump(new int[]{2,3,1,1,4}));
    }
}
