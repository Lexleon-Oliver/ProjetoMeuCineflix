
function getMovie(id){
    let request = new XMLHttpRequest()
    request.open("GET","http://localhost:8080/api/v1/movies/"+id,false)
    request.send()
    let data = request.responseText
    return JSON.parse(data);
}

function putMovie(movie){
    const xhr = new XMLHttpRequest();

// configure a `POST` request
    xhr.open('PUT', 'http://localhost:8080/api/v1/movies/'+movie.id);

// create a JSON object
    const params = {
        id: movie.id,
        name: movie.name,
        nameBr: movie.nameBr,
        year: movie.year,
        description: movie.description,
        thumbnail: movie.thumbnail,
        background: movie.background,
        storage: movie.storage,
        genre: movie.genre,
        rating: movie.rating
    };

// set `Content-Type` header
    xhr.setRequestHeader('Content-Type', 'application/json');

// pass `params` to `send()` method
    xhr.send(JSON.stringify(params));

// listen for `load` event
    xhr.onload = () => {
        console.log(xhr.responseText);
    }
}

function assistir(){
    alert("Aproveite o filme!");
    let request = new XMLHttpRequest()
    request.open("GET","http://localhost:8080/api/v1/movies/player/"+localStorage.getItem("movieId"),false)
    request.send()
     localStorage.clear();
}

function avaliar(){
    if(document.querySelector("#cm_star-5").checked){
        selectedMovie.rating = 5
    }else if(document.querySelector("#cm_star-4").checked){
        selectedMovie.rating = 4
    }else if(document.querySelector("#cm_star-3").checked){
        selectedMovie.rating = 3
    }else if(document.querySelector("#cm_star-2").checked){
        selectedMovie.rating = 2
    }else if(document.querySelector("#cm_star-1").checked){
        selectedMovie.rating = 1
    }else{
        selectedMovie.rating = 0
    }
    putMovie(selectedMovie);

}

function getMovieData(){
    let movie = localStorage.getItem("movieId");
    let selectedMovie = getMovie(movie);
    let nome = document.querySelector(".titulo-filme");
    nome.textContent =selectedMovie.nameBr;
    let sinopse = document.querySelector(".descricao-filme");
    sinopse.textContent = selectedMovie.description;
    let capa = document.querySelector(".filme-selecionado");
    capa.style.backgroundImage="url("+selectedMovie.background+")";
    let nomeUs = document.querySelector(".nome-us-filme");
    nomeUs.textContent = "Nome inglês: "+selectedMovie.name;
    let ano = document.querySelector(".ano-filme");
    ano.textContent = "Ano: "+selectedMovie.year;
    let genero = document.querySelector(".genero-filme");
    genero.textContent = "Gênero: "+selectedMovie.genre;
    let nota = document.querySelector(".nota-filme");
    nota.textContent = "Minha nota: ";
    let note = "#cm_star-" + selectedMovie.rating;
    document.querySelector(note).checked =true;

}

getMovieData();


