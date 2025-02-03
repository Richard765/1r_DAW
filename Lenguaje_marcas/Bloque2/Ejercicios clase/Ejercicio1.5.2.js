let address = createAddress("Via Argentina", "Palma de Mallorca", "07011");

function createAddress(street, city, zipCode) {
    return {
        street,
        city,
        zipCode
    };
}

console.log(address);

/*Con funcion constructora*/
/*
let address = {
    street: "a",
    city: "b",
    zipCode: "c",
}

function Address(street, city, zipCode) {
    this.street = street;
    this.city = city;
    this.zipCode = zipCode;
}

function showAddress(object) {
    for (key in address) {
        console.log(key + ": " + object(key));
    }
}

let oriol = createAddress("Establiments", "Palma", "07012");
showAddress(Oriol);

let jaume = new Address("Plaza España", "Palma", "07001");
showAddress(jaume)
*/