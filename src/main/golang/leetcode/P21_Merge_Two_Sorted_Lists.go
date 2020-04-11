package leetcode

type ListNode struct {
	Val int
	Next *ListNode
}

func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
	var (
		head *ListNode
		now  *ListNode
		init *ListNode
	)

	if l1 == nil && l2 == nil {
		return head
	} else if l1 == nil || l2 == nil {
		if l1 == nil {
			init = l2
			l2 = l2.Next
		} else {
			init = l1
			l1 = l1.Next
		}
	} else if l1.Val <= l2.Val {
		init = l1
		l1 = l1.Next
	} else if l2.Val < l1.Val{
		init = l2
		l2 = l2.Next
	}
	head, now = init, init

	for l1 != nil || l2 != nil {
		if l1 == nil {
			now.Next = l2
			now = now.Next
			l2 = l2.Next
			continue
		}

		if l2 == nil {
			now.Next = l1
			now = now.Next
			l1 = l1.Next
			continue
		}

		if l1.Val <= l2.Val {
			now.Next = l1
			l1 = l1.Next
		} else {
			now.Next = l2
			l2 = l2.Next
		}
		now = now.Next
	}


	return head
}