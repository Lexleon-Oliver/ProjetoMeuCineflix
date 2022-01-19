
function getMovie(id){
    request = new XMLHttpRequest()
    request.open("GET","http://localhost:8080/api/v1/movies/"+id,false)
    request.send()
    data = request.responseText
    return JSON.parse(data);
}

function assistir(){
    alert("Aproveite o filme!");
    let request = new XMLHttpRequest()
    request.open("GET","http://localhost:8080/api/v1/movies/player/"+localStorage.getItem("movieId"),false)
    request.send()
     localStorage.clear();
}

function getMovieData(){
    movie = localStorage.getItem("movieId");
    selectedMovie = getMovie(movie);
    var nome = document.querySelector(".titulo-filme");
    nome.textContent =selectedMovie.nameBr;
    var sinopse = document.querySelector(".descricao-filme");
    sinopse.textContent = selectedMovie.description;
    var capa = document.querySelector(".filme-selecionado");
    capa.style.backgroundImage="url("+selectedMovie.background+")";
    var nomeUs = document.querySelector(".nome-us-filme");
    nomeUs.textContent = "Nome inglês: "+selectedMovie.name;
    var ano = document.querySelector(".ano-filme");
    ano.textContent = "Ano: "+selectedMovie.year;
    var genero = document.querySelector(".genero-filme");
    genero.textContent = "Gênero: "+selectedMovie.genre;
    var nota = document.querySelector(".nota-filme");
    nota.textContent = "Minha nota: "+selectedMovie.rating;

}

getMovieData();

