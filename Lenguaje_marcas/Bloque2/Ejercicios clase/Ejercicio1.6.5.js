const numbers = [1, 2, 3, 4, 1];

const count = countOccurrences(numbers, 1);

console.log(count);

function countOccurrences(array, searchElement) {
    /*let count = 0;
    for (let element of array)
        if (element === searchElement) 
            count ++;
    return count;
    */

    /*Solucion 2
    array.reduce((accumulator, current) => {
        const occurrence = (current === searchElement) ? 1 : 0;
        return accumulator + occurrence;
    }, 0);
    */

    /*Solucion 3
    return array.reduce((accumulator, current) => {
        const occurrence = (current === searchElement);
        console.log(accumulator, current, searchElement);
        return accumulator + occurrence;
    }, 0);
    */
}


