package leetcode

var (
	numbers = make(map[rune]int)
)

func romanToInt(s string) int {
	numbers['I'] = 1
	numbers['V'] = 5
	numbers['X'] = 10
	numbers['L'] = 50
	numbers['C'] = 100
	numbers['D'] = 500
	numbers['M'] = 1000

	runes := []rune(s)
	return recursive(0, runes)
}

func recursive(i int, runes []rune) int {
	if i == len(runes) - 1 {
		return numbers[runes[i]]
	}

	if i == len(runes) - 2 {
		temp := 0
		if numbers[runes[i]] < numbers[runes[i + 1]] {
			temp = -numbers[runes[i]]
		} else {
			temp = numbers[runes[i]]
		}
		return temp + recursive(i + 1, runes)
	}

	now := numbers[runes[i]]
	afterOneBlock := numbers[runes[i + 1]]
	afterTwoBlock := numbers[runes[i + 2]]
	temp := 0

	if now < afterOneBlock || now < afterTwoBlock {
		temp = -now
	} else {
		temp = now
	}

	return temp + recursive(i + 1, runes)
}