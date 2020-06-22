let maxProfit = function(prices) {
    let min = Infinity;
    let max = 0;
    for (price of prices) {
        if (price < min) {
            min = price;
        } else if (price - min > max) {
            max = price - min;
        }
    }
    return max;
};

console.log(maxProfit([7,1,5,3,6,4]));