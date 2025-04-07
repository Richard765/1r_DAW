const numbers = [1, 2, 3, 4];

try {
    const count = countOcurrences(numbers, 1);
    console.log(count);
} catch(error) {
    console.error(error);
}

function countOcurrences(array, searchElement) {
    if (!Array.isArray(array)) {
        throw new Error("La constante numbers no es un array");
    }
    return array.reduce((accumulator, current) => {
        const ocurrence = (current === searchElement) ? 1 : 0;
        return accumulator + occurrence;
    }, 0);
}