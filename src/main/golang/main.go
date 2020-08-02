package main

import (
	"fmt"
	"strconv"
)
func main() {
	var input string
	_, err := fmt.Scanln(&input);
	if err != nil {
		panic(err)
	}

	number, _ := strconv.Atoi(input)
	fmt.Println(isOddOrEven(number));
}

func isOddOrEven(number int) string {
	if number % 2 == 0 {
		return "even"
	}
	return "odd"
}