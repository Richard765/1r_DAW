function calculaMitjana(a, b) {
    return (a + b) / 2;
}

function calculaIVA(preu) {
    return preu * 0.21;
}

function trobaMajor(a, b) {
    return a > b ? a : b;
}

function comptaAs(string) {
    let count = 0;
    for (let i = 0; i < string.length; i++) {
        if (string.charAt(i) === 'a') {
            count++;
        }
    }
    return count;
}

function calculaTotalAmbDescompte(preu) {
    if (preu > 100) {
        return preu * 0.9;
    } else if (preu > 50) {
        return preu - 10;
    } else if (preu > 10) {
        return preu - 5;
    }
    return preu;
}

function validaEmail(email) {
    let parts = email.split('@');
    if (parts.length !== 2 || parts[0].length > 30 || parts[1].length > 20) {
        return false;
    }
    return parts[1] === "digimon.es" || parts[1].endsWith(".org");
}

function calculaMitjanaNotes(array) {
    let suma = 0;
    for (let i = 0; i < array.length; i++) {
        suma += array[i];
    }
    return array.length ? suma / array.length : 0;
}

function diferenciaDates(data1, data2) {
    let d1 = new Date(data1);
    let d2 = new Date(data2);
    return Math.abs((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
}

function premiat(data) {
    let any = data.split('/')[2];
    return any === any.split('').reverse().join('');
}

function transformaContrasenya(string) {
    return string.replace(/a/g, "@").replace(/e/g, "3").replace(/i/g, "1").replace(/o/g, "0").replace(/s/g, "$") + "*";
}

function determinaGeneracio(any) {
    if (any >= 1883 && any <= 1900) return "Generació Perduda";
    if (any >= 1901 && any <= 1927) return "Generació més gran";
    if (any >= 1928 && any <= 1945) return "Generació del Silenci";
    if (any >= 1946 && any <= 1964) return "Baby Boomers";
    if (any >= 1965 && any <= 1980) return "Generació X";
    if (any >= 1981 && any <= 1996) return "Generació Y (Millennials)";
    if (any >= 1997 && any <= 2012) return "Generació Z";
    if (any >= 2013) return "Generació Alfa";
    return "Fora de rang";
}

function calculaPreuFinal(preu, descompte) {
    return preu - (preu * descompte / 100);
}

function filtraJocs(games) {
    return games.filter(joc => (joc[1] === "shooter" || joc[1] === "RPG") && joc[2] < 60);
}

function calculaFactorial(nombre) {
    let resultat = 1;
    for (let i = 2; i <= nombre; i++) {
        resultat *= i;
    }
    return resultat;
}

function sumaArray(array) {
    let suma = 0;
    for (let i = 0; i < array.length; i++) {
        suma += array[i];
    }
    return suma;
}
