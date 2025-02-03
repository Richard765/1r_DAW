showPrimes(20);


function showPrimes(limit) {
    for (let n = 2; n <= limit; n++) {
        let isPrime = true;
        
        for (let f = 2; f < n; f++) {
            if (n % f === 0) {
                isPrime = false;
                break;
            }
        }
        
        if (isPrime) {
            console.log(n + " es primo");
        }
    }
}

/* Solucion 2 [FUNCIONES REUTILIZABLES]
function showPrimes(limit) {
    for (let number = 2; number <= limit; number++)
        if (isPrime(number)) console.log(number);
} 

function isPrime(number) {
    for (let factor = 2; factor < number; factor++)
        if (number % factor === 0)
            return false;

    return true;
} */