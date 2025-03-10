const pantalla = document.querySelector('.pantalla');
const botones = document.querySelectorAll('.btn');

botones.forEach(boton => {
    boton.addEventListener('click', () => {
        const valor = boton.textContent;
        
        if (boton.id === 'c') {
            pantalla.textContent = '0';
        } else if (boton.id === 'borrar') {
            pantalla.textContent = pantalla.textContent.slice(0, -1) || '0';
        } else if (boton.id === 'igual') {
            try {
                pantalla.textContent = eval(pantalla.textContent);
            } catch {
                pantalla.textContent = 'Error';
            }
        } else {
            if (pantalla.textContent === '0' || pantalla.textContent === 'Error') {
                pantalla.textContent = valor;
            } else {
                pantalla.textContent += valor;
            }
        }
    });
});
