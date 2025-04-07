const paraules = ["abstraction", "adware", "algorithm", "complexity", "architecture", "array", "artificial", "intelligence", "asynchronous", "augmented", "reality", "backend", "bandwidth", "battery", "binary", "bitcoin", "bitrate", "bios", "blockchain", "browser", "cache", "callback", "class", "clock", "speed", "cloud", "computing", "compiler", "computer", "cryptocurrency", "cybersecurity", "database", "debugging", "diode", "docker", "domain", "encryption", "ethernet", "firewall", "firmware", "frontend", "function", "gigabyte", "hacker", "hashing", "hardware", "hosting", "html", "http", "https", "interpreter", "internet", "javascript", "keyboard", "latency", "library", "linux", "machine", "learning", "malware", "megabyte", "modem", "monitor", "motherboard", "network", "node", "nosql", "object", "output", "overclocking", "packet", "phishing", "platform", "polymorphism", "power", "processor", "programming", "protocol", "proxy", "public", "queue", "recursion", "register", "regex", "repository", "resolution", "router", "runtime", "security", "server", "software", "sorting", "stack", "syntax", "terabyte", "token", "transistor", "trojan", "variable", "version", "virtual", "wifi"];

let paraulaSecreta = "";
let paraulaMostrar = [];
let lletresErronies = [];
let maxErrors = 8;
let errors = 0;

function seleccionarParaula() {
    return paraules[Math.floor(Math.random() * paraules.length)];
}

function iniciarJoc() {
    paraulaSecreta = seleccionarParaula();
    paraulaMostrar = Array(paraulaSecreta.length).fill("_");
    lletresErronies = [];
    errors = 0;
    document.getElementById("paraulaOculta").textContent = paraulaMostrar.join(" ");
    document.getElementById("lletresIncorrectes").textContent = "";
    document.getElementById("lletraEntrada").value = "";
}

function gestionarJugada(lletra) {
    if (paraulaSecreta.includes(lletra)) {
        for (let i = 0; i < paraulaSecreta.length; i++) {
            if (paraulaSecreta[i] === lletra) {
                paraulaMostrar[i] = lletra;
            }
        }
    } else {
        if (!lletresErronies.includes(lletra)) {
            lletresErronies.push(lletra);
            errors++;
        }
    }
    actualitzarPantalla();
    comprovarFinal();
}

function actualitzarPantalla() {
    document.getElementById("paraulaOculta").textContent = paraulaMostrar.join(" ");
    document.getElementById("lletresIncorrectes").textContent = "Errors: " + lletresErronies.join(", ");
}

function comprovarFinal() {
    if (paraulaMostrar.join("") === paraulaSecreta) {
        alert("Felicitats! Has encertat la paraula: " + paraulaSecreta);
        iniciarJoc();
    } else if (errors >= maxErrors) {
        alert("Has perdut! La paraula era: " + paraulaSecreta);
        iniciarJoc();
    }
}

document.getElementById("lletraEntrada").addEventListener("keydown", function(event) {
    const lletra = event.key.toLowerCase();
    if (/[a-zç]/.test(lletra) && lletra.length === 1) {
        gestionarJugada(lletra);
        document.getElementById("lletraEntrada").value = "";
    }
});

document.getElementById("reiniciar").addEventListener("click", iniciarJoc);

iniciarJoc();
