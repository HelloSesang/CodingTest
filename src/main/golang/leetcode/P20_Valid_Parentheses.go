package leetcode

type Stack struct {
	Stack []interface{}
}

func (s *Stack) push(something interface{}) {
	s.Stack = append(s.Stack, something)
}

func (s *Stack) pop() {
	s.Stack = s.Stack[:len(s.Stack)-1]
}

func (s *Stack) peek() interface{} {
	return s.Stack[len(s.Stack)-1]
}

func (s *Stack) len() int {
	return len(s.Stack)
}

func isValid(s string) bool {
	result := true
	stack := Stack{}

	for _, rune := range s {
		switch rune {
		case '(', '{', '[':
			stack.push(rune)
		case ')':
			if len(stack.Stack) != 0 && stack.peek() == '(' {
				stack.pop()
			} else {
				result = false
				break
			}
		case '}':
			if len(stack.Stack) != 0 && stack.peek() == '{' {
				stack.pop()
			} else {
				result = false
				break
			}
		case ']':
			if len(stack.Stack) != 0 && stack.peek() == '[' {
				stack.pop()
			} else {
				result = false
				break
			}
		}
	}

	if len(stack.Stack) != 0 {
		result = false
	}

	return result
}
