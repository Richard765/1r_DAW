const output = checkSpeed(100);
console.log(output);


function checkSpeed(speed) {
    let speedLimit = 70;
    let penalty;
    if (speed < speedLimit + 5) {
        return "OK";
    }

    if (speed >= speedLimit + 5) {
        for (penalty = 0; speedLimit <= speed; penalty++) {
            speedLimit = speedLimit + 5;
        }
        return "Va por encima del limite de velocidad. \nTiene " + penalty + " puntos de penalizacion";
    }

    if (penalty >= 12) {
        return "License suspended";
    }
}
