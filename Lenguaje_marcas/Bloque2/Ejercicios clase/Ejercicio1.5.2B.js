class Address {
    constructor(street, city, zipCode) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }

    showAddress() {
        return "Dirección: " + this.street + "\nCiudad: " + this.city + "\nCodigo postal: " + this.zipCode;
    }
}

let address = new Address("Calle Mayor 123", "Madrid", "28001");

console.log(address.showAddress());
