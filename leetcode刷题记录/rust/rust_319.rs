impl Solution {
    pub fn bulb_switch(n: i32) -> i32 {
        let mut res = 0;
        let mut i = 1;
        while i * i <= n {
            i += 1;
            res += 1;
        }
        res
    }
}