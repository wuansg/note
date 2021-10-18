impl Solution {
    pub fn find_complement(num: i32) -> i32 {
        let mut i = num;
        let mut j = 0;
        while i > 0 {
            j <<= 1;
            j += 1;
            i >>= 1;
        }
        !num & j
    }
}