const cercleModificat = {
    _radi: 2,
    get radi() {
        return this._radi;
    },
    set radi(nouRadi) {
        this._radi = nouRadi;
    },
    get area() {
        return Math.PI * (this._radi ** 2);
    },
    set area(novaArea) {
        this._radi = Math.sqrt(novaArea / Math.PI);
    },
    get longitud() {
        return 2 * Math.PI * this._radi;
    },
    set longitud(novaLongitud) {
        this._radi = novaLongitud / (2 * Math.PI);
    }
};

cercleModificat.radi = 1;
console.log("Radi:", cercleModificat.radi.toFixed(4));
console.log("Àrea:", cercleModificat.area.toFixed(4));
console.log("Longitud:", cercleModificat.longitud.toFixed(4));

cercleModificat.longitud = 3.141592;
console.log("Radi després de canviar longitud:", cercleModificat.radi.toFixed(4));
console.log("Àrea després de canviar longitud:", cercleModificat.area.toFixed(4));
console.log("Longitud:", cercleModificat.longitud.toFixed(4));

cercleModificat.area = 3.141592;
console.log("Radi després de canviar area:", cercleModificat.radi.toFixed(4));
console.log("Àrea:", cercleModificat.area.toFixed(4));
console.log("Longitud després de canviar area:", cercleModificat.longitud.toFixed(4));