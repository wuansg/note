use std::collections::HashSet;
impl Solution {
    pub fn find_words(words: Vec<String>) -> Vec<String> {
        let mut line1: HashSet<char> = vec!['q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'].into_iter().collect();
        let mut line2: HashSet<char> = vec!['a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'].into_iter().collect();
        let mut line3: HashSet<char> = vec!['z', 'x', 'c', 'v', 'b', 'n', 'm'].into_iter().collect();
        let mut res: Vec<String> = Vec::new();

        for x in words {
            let mut index = 0;
            let mut tmp;
            for &c in x.as_bytes() {
                tmp = c as char;
                tmp.make_ascii_lowercase();
                if line1.contains(&tmp) && (index == 0 || index == 1) {
                    index = 1;
                } else if line2.contains(&tmp) && (index == 0 || index == 2) {
                    index = 2;
                } else if line3.contains(&tmp) && (index == 0 || index == 3) {
                    index = 3;
                } else {
                    index = -1;
                    break;
                }
            }
            if index > 0 {
                res.push(x);
            }
        }

        res
    }
}