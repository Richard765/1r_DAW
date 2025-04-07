const cercle = {
    _radi: 3,
    get radi() {
        return this._radi;
    },
    set radi(nouRadi) {
        this._radi = nouRadi;
    },
    get area() {
        return Math.PI * (this._radi ** 2);
    },
    get longitud() {
        return 2 * Math.PI * this._radi;
    }
};

console.log("Radi:", cercle.radi);
console.log("Àrea:", cercle.area);
console.log("Longitud:", cercle.longitud);

cercle.longitud = 7;
console.log("Longitud després d'intentar canviar-la:", cercle.longitud);

cercle.radi = 1;
console.log("Radi després de canviar-lo:", cercle.radi);
console.log("Àrea després de canviar radi:", cercle.area);
console.log("Longitud després de canviar radi:", cercle.longitud);
console.log("Àrea en unitats de PI:", cercle.area / Math.PI);
console.log("Longitud en unitats de PI:", cercle.longitud / Math.PI);