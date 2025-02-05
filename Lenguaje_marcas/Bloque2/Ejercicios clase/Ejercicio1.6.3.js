const numbers = [1, 2, 3, 4, 1, 1];

const excluded = [1, 2];
const output = [];

for (let element of numbers) {
    if (!excluded.includes(element)) {
        output.push(element);
    }
}

console.log(output);
