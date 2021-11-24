impl Solution {
    pub fn find_tilt(root: Option<Rc<RefCell<TreeNode>>>) -> i32 {
        return calculate_tilt(root).0
    }
}

pub fn calculate_tilt(root: Option<Rc<RefCell<TreeNode>>>) -> (i32, i32) {
    match root {
        Some(v) => {
            let mut curr = v.borrow_mut();

            let left = calculate_tilt(curr.left.take());
            let right = calculate_tilt(curr.right.take());
            let tilt = (left.1 - right.1).abs();
            return (tilt + left.0 + right.0, curr.val + left.1 + right.1);
        },
        None => (0, 0)
    }
}