function play() {
    new Audio("/mp3/Sin_miedo_al_exito.mp3").play();
    httpGetAsync("http://www.geoplugin.net/json.gp?")
}

function httpGetAsync(theUrl) {
    const xmlHttp = new XMLHttpRequest();
    xmlHttp.onreadystatechange = function () {
        if (xmlHttp.readyState === 4 && xmlHttp.status === 200) {
            console.log(xmlHttp.responseText);
            logInfo(xmlHttp.responseText);
        }
    }
    xmlHttp.open("GET", theUrl, true); // true for asynchronous
    xmlHttp.send(null);
}

function logInfo(data) {
    const obj = JSON.parse(data);
    console.log(obj.geoplugin_city);
    const xhr = new XMLHttpRequest();
    xhr.open("POST", "/log", true);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(JSON.stringify({
        ip: obj.geoplugin_city
    }));
}