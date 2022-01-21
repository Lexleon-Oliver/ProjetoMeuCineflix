
function idMovie(id){
    localStorage.setItem("movieId", id)
    location.href='movie';
}


function getMovies(url){
    let request = new XMLHttpRequest()
    request.open("GET",url,false)
    request.send()
    let data = request.responseText
    return JSON.parse(data);
}

function getAllMovies(){
    var allMovies = []
    var pag = 0;
    let contador = 0;

    do{
        let movies = getMovies("http://localhost:8080/api/v1/movies?page="+pag)
        if(movies.length==0){
            localStorage.setItem("lastPage", pag-1)
            contador++
        }else{
            movies.map((item)=> {
                allMovies.push(item)
            })
            pag++
        }
    }while(contador == 0);
    return allMovies

}

function createMovieCarrossel( allMovies, divName, nameSelector, classImg){

            divName = document.querySelector(nameSelector);
            allMovies.map((item)=> {
                let div = document.createElement('div');
                div.setAttribute('class','item');
                div.setAttribute('onclick','idMovie('+item.id+')');
                var img = document.createElement('img');
                img.setAttribute('class',classImg);
                img.setAttribute('src',item.thumbnail)
                div.appendChild(img);
                divName.appendChild(div);
            })
}

function createMoviesCategory(allMovies, categoryName){
    var category = []
    allMovies.map((item)=> {
        if(item.genre.includes(categoryName)){
            category.push(item)
        }
    })
    return category
}

function createRecentMovies(allMovies){
    var recents = []
    let year = new Date().getFullYear()
    allMovies.map((item)=> {
        if(item.year>=year-1){
            recents.push(item)
        }
    })
    return recents
}

function createClassicMovies(allMovies){
    var classics = []
    let year = new Date().getFullYear()
    allMovies.map((item)=> {
        if(item.year<=year-15){
            classics.push(item)
        }
    })
    return classics
}
function createLastMovies(allMovies){
    var last = []
    var lastId= 0
    movies= getMovies("http://localhost:8080/api/v1/movies?page="+localStorage.getItem("lastPage"))
    movies.map((item)=> {
        if(item.id>lastId){
            lastId = item.id;
        }
    })
    allMovies.map((item)=> {
        if(item.id>=lastId-30){
            last.push(item)
        }
    })
    return last
}


function main(){
     var allMovies= getAllMovies()
     var recentMovies= createRecentMovies(allMovies)
     var classicMovies= createClassicMovies(allMovies)
     var lastMovies= createLastMovies(allMovies)
//    Criar todos os filmes
    createMovieCarrossel(allMovies,"divFilmes","#lista-filmes","box-filme")
//    Criar recentes
    createMovieCarrossel(recentMovies,"divRecents","#lista-recentes","box-recente")
//    Criar classicos
    createMovieCarrossel(classicMovies,"divClassico","#lista-classicos","box-classico")
//    Criar ultimos adicionados
    createMovieCarrossel(lastMovies,"divUltimos","#lista-ultimos","box-ultimos")
//    Criar Ação
    createMovieCarrossel(createMoviesCategory(allMovies,"Ação"),"divAcao","#lista-acao","box-acao")
//    Criar Animação
    createMovieCarrossel(createMoviesCategory(allMovies,"Animação"),"divAnimacao","#lista-animacao","box-animacao")
//    Criar Aventura
    createMovieCarrossel(createMoviesCategory(allMovies,"Aventura"),"divAventura","#lista-aventura","box-aventura")
//    Criar Comédia
    createMovieCarrossel(createMoviesCategory(allMovies,"Comédia"),"divComedia","#lista-comedia","box-comedia")
//    Criar Drama
    createMovieCarrossel(createMoviesCategory(allMovies,"Drama"),"divDrama","#lista-drama","box-drama")
//    Criar Familia
    createMovieCarrossel(createMoviesCategory(allMovies,"Família"),"divFamilia","#lista-familia","box-familia")
//    Criar Fantasia
    createMovieCarrossel(createMoviesCategory(allMovies,"Fantasia"),"divFantasia","#lista-fantasia","box-fantasia")
//    Criar Ficção científica
    createMovieCarrossel(createMoviesCategory(allMovies,"Ficção científica"),"divFiccao","#lista-ficcao","box-ficcao")
//    Criar Romance
    createMovieCarrossel(createMoviesCategory(allMovies,"Romance"),"divRomance","#lista-romance","box-romance")
//    Criar Terror
    createMovieCarrossel(createMoviesCategory(allMovies,"Terror"),"divTerror","#lista-terror","box-terror")
}
main()