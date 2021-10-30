impl Solution {
    pub fn single_number(nums: Vec<i32>) -> Vec<i32> {
        let mut res: i32 = 0;
        for x in &nums {
            res ^= x;
        }
        let mut split = 1;
        while res != 1 && res != -1 {
            res >>= 1;
            split <<= 1;
            println!("{}, {}", res, split);
        }
        let mut left: Vec<i32> = Vec::new();
        let mut right: Vec<i32> = Vec::new();
        for x in nums {
            if split & x == 0 {
                left.push(x);
            } else {
                right.push(x);
            }
        }
        let mut l = 0;
        for x in left {
            l ^= x;
        }
        let mut r = 0;
        for x in right {
            r ^= x;
        }
        [l, r].to_vec()
    }
}