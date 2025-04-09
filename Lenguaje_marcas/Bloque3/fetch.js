//Ejercicio 8
fetch("https://reqres.in/api/users/5")
    .then((response) => {
        if (response.ok) {
            console.log(`Ha funcionado con el código HTTP ${response.status}`);
            return response.json();
        }
        throw new Error(`Ha fallado con código HTTP ${response.status}`);
    })
    .then((data) => console.log(data))
    .catch((error) => console.error("ERROR: " + error.message));

    const request = async () => {
        try {
            const response = await fetch("https://reqres.in/api/users/5");
            const data = await response.json();
            return data;
        } catch (error) {
            console.error("Error al realizar la peticion o procesar los datos: ", error.message);
        }
    }


//Ejercicio 9
async function fetchUser() {
    try {
        const response = await fetch("https://reqres.in/api/users/5");
        if (!response.ok) {
            throw new Error(`Ha fallado con el codigo HTTP ${response.status}`);
        }
        console.log(`Ha funcionado con el codigo HTTP ${response.status}`);
        const data = await response.json();
        console.log(data);
    } catch(error) {
        console.error("ERROR: " + message.error);
    }
}
fetchUser();

//Ejercicio 10
