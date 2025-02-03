const output = fizzBuzz(30);
console.log(output);

function fizzBuzz(input) {
    if (typeof input !== 'number') {
        return "Not a number";
    } else if ((input % 5 !== 0) && (input % 3 !== 0)) {
        return input;
    } else if ((input % 5 === 0) && (input % 3 === 0)) {
        return "FizzBuzz";
    } else if (input % 5 === 0) {
        return "Buzz";
    } else if (input % 3 === 0) {
        return "Fizz";
    } else {
        return "Not a number";
    }
}