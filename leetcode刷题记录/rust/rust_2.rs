impl Solution {
    pub fn add_two_numbers(l1: Option<Box<ListNode>>, l2: Option<Box<ListNode>>) -> Option<Box<ListNode>> {
        let mut node1 = &l1;
        let mut node2 = &l2;
        let mut result = Some(Box::new(ListNode::new(-1)));
        let mut tmp = &mut result;
        let mut up = 0;
        while node1.is_some() && node2.is_some() {
            let sum = node1.as_ref().unwrap().val + node2.as_ref().unwrap().val + up;
            up = sum / 10;
            tmp.as_mut().unwrap().next = Some(Box::new(ListNode::new(sum % 10)));
            tmp = &mut tmp.as_mut().unwrap().next;
            node1 = &node1.as_ref().unwrap().next;
            node2 = &node2.as_ref().unwrap().next;
        }
        calculate(&mut node1, &mut tmp, up);
        calculate(&mut node2, &mut tmp, up);
        if up == 1 {
            tmp.as_mut().unwrap().next = Some(Box::new(ListNode::new(1)));
        }
        result.unwrap().next
    }
}

fn calculate(node: &Option<Box<ListNode>>, result: &mut Option<Box<ListNode>>, up: i32) {
    let mut up = up;
    let mut node = node;
    let mut result = result;
    while node.is_some() {
        let sum = node.as_ref().unwrap().val + up;
        up = sum / 10;
        result.as_mut().unwrap().next = Some(Box::new(ListNode::new(sum % 10)));
        result = &mut result.as_mut().unwrap().next;
        node = &node.as_ref().unwrap().next;
    }
}