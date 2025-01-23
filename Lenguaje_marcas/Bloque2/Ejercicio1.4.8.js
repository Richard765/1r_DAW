console.log(sum(10));

function sum (limit) {
    let contador = 0;
    for (let i = 0; i <= limit; i++) {
        if (1 % 3 === 0 || i % 5 === 0) {
            contador++;
        }
    }
    return contador;
}