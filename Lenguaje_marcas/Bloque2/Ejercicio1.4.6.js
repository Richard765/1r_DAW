const valores = [true, false, null, NaN, undefined, [], {}, 0, 1];

function countTruthy(array) {
    let truthyCount = 0;
    for (const valor of array) {
        if (valor) {
            truthyCount++;
        }
    }

    return truthyCount;
}

const truthyCount = countTruthy(valores);
console.log("Hay " + truthyCount + " valores truthy");
