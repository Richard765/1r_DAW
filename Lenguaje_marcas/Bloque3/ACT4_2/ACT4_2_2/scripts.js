const empleados = [
    { nombre: "Anna", especialidades: ["Frontend", "UI/UX"], departamento: "Desarrollo Web" },
    { nombre: "Carlos", especialidades: ["Backend", "Bases de Datos"], departamento: "Desarrollo Backend" },
    { nombre: "Beatriz", especialidades: ["DevOps", "Seguridad"], departamento: "Infraestructura" }
];

document.addEventListener("DOMContentLoaded", () => {
    const tabla = document.getElementById("tablaEmpleados");
    empleados.forEach(emp => {
        const fila = document.createElement("tr");
        fila.innerHTML = `<td>${emp.nombre}</td><td>${emp.especialidades.join(", ")}</td><td>${emp.departamento}</td>`;
        tabla.appendChild(fila);
    });
});