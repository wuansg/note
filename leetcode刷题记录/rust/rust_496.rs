use std::collections::HashMap;

impl Solution {
    pub fn next_greater_element(nums1: Vec<i32>, nums2: Vec<i32>) -> Vec<i32> {
        let mut map: HashMap<i32, i32> = HashMap::new();
        let mut stack: Vec<i32> = Vec::new();
        for &x in &nums2 {
            while !stack.is_empty() && stack.last().unwrap() < &x {
                map.insert(stack.pop().unwrap(), x);
            }
            stack.push(x);
        }
        stack.clear();
        for &x in &nums1 {
            if map.contains_key(&x) {
                stack.push(*map.get(&x).unwrap());
            } else {
                stack.push(-1);
            }
        }
        stack
    }
}