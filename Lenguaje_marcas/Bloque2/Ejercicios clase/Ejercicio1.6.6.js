const numbers = [1, 2, 3, 4];

const max = getMax(numbers);

console.log(max);

function getMax(array) {
    let max = numbers[0];
    for (let n of numbers)
        if (n > max) 
            max = n;
    return max;
}