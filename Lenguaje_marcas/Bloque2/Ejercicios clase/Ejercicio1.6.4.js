const numbers = [1, 2, 3, 4];

const output = move(numbers, 1, -1);

console.log(output);

function move(array, index, offset) {
    const i = index + offset;

    if (i < 0 || i >= array.length) {
        console.error("Invalid offset");
        return array;
    }

    const newArray = [...array]; 
    const element = newArray.splice(index, 1)[0]; 
    newArray.splice(i, 0, element);

    return newArray;
}