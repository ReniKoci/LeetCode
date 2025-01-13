use std::collections::HashMap;

impl Solution {
    pub fn two_sum(nums: Vec<i32>, target: i32) -> Vec<i32> {
        let mut map = HashMap::new();
        for i in 0..nums.len() {
            let diff: i32 = target - nums[i];
            if map.contains_key(&diff) {
                return vec![map[&diff] as i32, i as i32];
            }
            map.insert(nums[i], i);
        }
        vec![-1, -1]
    }
}