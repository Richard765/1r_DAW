function comptarVocals(text) {
    const vocals = "aeiouàèéíïòóúüAEIOUÀÈÉÍÏÒÓÚÜ";
    return [...text].filter(char => vocals.includes(char)).length;
}

let texto = document.getElementById("textInput");
let button = document.getElementById("countButton");

button.addEventListener("click", function () {
    let resultat = comptarVocals(texto.value);
    document.getElementById("result").textContent = resultat;
});