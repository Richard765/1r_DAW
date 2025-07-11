fetch("https://jsonplaceholder.typicode.com/users")
    .then((respuesta) => {
      // Si detecta algun problema lanza un nuevo error con el status del HTTP retornado
      if (!respuesta.ok) {
        throw new Error("Error HTTP: ", respuesta.status);
      }
      return respuesta.json();
    })
    .then((datos) => {
      datos.forEach((usuario) => {
        console.log("Name: ", usuario.name);
        console.log("Email: ", usuario.email);
        console.log("Phone number: ", usuario.phone);
        console.log("----");
      });
    })
    .catch((error) => {
      console.log("Ocurrió un error: ", error.message);
    });

//Estructura JSON
/*
"id": 1,
    "name": "Leanne Graham",
    "username": "Bret",
    "email": "Sincere@april.biz",
    "address": {
      "street": "Kulas Light",
      "suite": "Apt. 556",
      "city": "Gwenborough",
      "zipcode": "92998-3874",
      "geo": {
        "lat": "-37.3159",
        "lng": "81.1496"
      }
    },
    "phone": "1-770-736-8031 x56442",
    "website": "hildegard.org",
    "company": {
      "name": "Romaguera-Crona",
      "catchPhrase": "Multi-layered client-server neural-net",
      "bs": "harness real-time e-markets"
    }
*/