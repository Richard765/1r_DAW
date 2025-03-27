const cercle = {
    radi: 2,
    get area() {
        return (Math.PI * (this.radi ** 2)).toFixed(4);
    },
    set area(area) {
        try {
            this.radi = Math.sqrt(area / Math.PI);
        } catch (e) {
            console.error(e);
        }
    },
    get longitud() {
        return (2 * Math.PI * this.radi).toFixed(4);
    },
    set longitud(longitud) {
        try {
            this.radi = longitud / (2 * Math.PI);
        } catch(e) {
            console.error(e);
        }
    }
};

console.log("Radi: " + cercle.radi);
console.log("Area: " + cercle.area);
console.log("Longitud: " + cercle.longitud);