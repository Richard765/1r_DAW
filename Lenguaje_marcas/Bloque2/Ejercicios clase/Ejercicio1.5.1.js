let address = {
    street: "Calle Argentina",
    city: "Palma de Mallorca",
    zipcode: "07010"
}

function showAddress(address) {
    for (let i in address) {
        console.log(i + ": " + address[i]);
    }
}

showAddress(address);