use std::cmp::min;
use std::collections::HashSet;

impl Solution {
    pub fn distribute_candies(candy_type: Vec<i32>) -> i32 {
        let mut map: HashSet<i32> = HashSet::new();
        for &x in &candy_type {
            map.insert(x);
        }
        min(candy_type.len()/2, map.len()) as i32
    }
}