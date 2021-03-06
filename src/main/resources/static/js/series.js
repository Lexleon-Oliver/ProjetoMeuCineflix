
function idSerie(id){
    localStorage.setItem("serieId", id)
    location.href='serie';
}

function getSeries(url){
    let request = new XMLHttpRequest()
    request.open("GET",url,false)
    request.send()
    let data = request.responseText
    return JSON.parse(data);
}

function getAllSeries(){
    const allSeries = [];
    let pag = 0;
    let contador = 0;

    do{
        let series = getSeries("http://localhost:8080/api/v1/series?page="+pag)
        if(series.length===0){
            localStorage.setItem("lastPage", pag-1)
            contador++
        }else{
            series.map((item)=> {
                allSeries.push(item)
            })
            pag++
        }
    }while(contador === 0);
    return allSeries

}

function createSerieCarrossel(idTitle,textTitle, allMovies, divName, nameSelector, classImg){
            document.querySelector('#'+idTitle).textContent=textTitle;
            divName = document.querySelector(nameSelector);
            allMovies.map((item)=> {
                let div = document.createElement('div');
                div.setAttribute('class','item');
                div.setAttribute('onclick','idSerie('+item.id+')');
                let img = document.createElement('img');
                img.setAttribute('class',classImg);
                img.setAttribute('src',item.thumbnail)
                div.appendChild(img);
                divName.appendChild(div);
            })
}

// function createMoviesCategory(allMovies, categoryName){
//     const category = [];
//     allMovies.map((item)=> {
//         if(item.genre.includes(categoryName)){
//             category.push(item)
//         }
//     })
//     return category
// }

// function createRecentMovies(allMovies){
//     const recents = [];
//     let year = new Date().getFullYear()
//     allMovies.map((item)=> {
//         if(item.year>=year-1){
//             recents.push(item)
//         }
//     })
//     return recents
// }

// function createClassicMovies(allMovies){
//     const classics = [];
//     let year = new Date().getFullYear()
//     allMovies.map((item)=> {
//         if(item.year<=year-15){
//             classics.push(item)
//         }
//     })
//     return classics
// }
// function createLastMovies(allMovies){
//     const last = [];
//     let lastId = 0;
//     let movies = getMovies("http://localhost:8080/api/v1/movies?page=" + localStorage.getItem("lastPage"))
//     movies.map((item)=> {
//         if(item.id>lastId){
//             lastId = item.id;
//         }
//     })
//     allMovies.map((item)=> {
//         if(item.id>=lastId-30){
//             last.push(item)
//         }
//     })
//     return last
// }


function main(){
    const allSeries = getAllSeries();
    // const recentMovies = createRecentMovies(allMovies);
    // const classicMovies = createClassicMovies(allMovies);
    // const lastMovies = createLastMovies(allMovies);
//    Criar todas as series
    createSerieCarrossel("titulo-series","S??RIES",allSeries,"divSeries","#lista-series","box-serie")
// //    Criar recentes
//     createMovieCarrossel("titulo-novidades","NOVIDADES",recentMovies,"divRecents","#lista-recentes","box-recente")
// //    Criar classicos
//     createMovieCarrossel("titulo-classicos","CL??SSICOS",classicMovies,"divClassico","#lista-classicos","box-classico")
// //    Criar ultimos adicionados
//     createMovieCarrossel("titulo-ultimos","??LTIMOS ADICIONADOS",lastMovies,"divUltimos","#lista-ultimos","box-ultimos")
// //    Criar A????o
//     createMovieCarrossel("titulo-acao","A????O",createMoviesCategory(allMovies,"A????o"),"divAcao","#lista-acao","box-acao")
// //    Criar Anima????o
//     createMovieCarrossel("titulo-animacao","ANIMA????O",createMoviesCategory(allMovies,"Anima????o"),"divAnimacao","#lista-animacao","box-animacao")
// //    Criar Aventura
//     createMovieCarrossel("titulo-aventura","AVENTURA",createMoviesCategory(allMovies,"Aventura"),"divAventura","#lista-aventura","box-aventura")
// //    Criar Com??dia
//     createMovieCarrossel("titulo-comedia","COM??DIA",createMoviesCategory(allMovies,"Com??dia"),"divComedia","#lista-comedia","box-comedia")
// //    Criar Drama
//     createMovieCarrossel("titulo-drama","DRAMA",createMoviesCategory(allMovies,"Drama"),"divDrama","#lista-drama","box-drama")
// //    Criar Familia
//     createMovieCarrossel("titulo-familia","FAM??LIA",createMoviesCategory(allMovies,"Fam??lia"),"divFamilia","#lista-familia","box-familia")
// //    Criar Fantasia
//     createMovieCarrossel("titulo-fantasia","FANTASIA",createMoviesCategory(allMovies,"Fantasia"),"divFantasia","#lista-fantasia","box-fantasia")
// //    Criar Fic????o cient??fica
//     createMovieCarrossel("titulo-ficcao","FIC????O CIENT??FICA",createMoviesCategory(allMovies,"Fic????o cient??fica"),"divFiccao","#lista-ficcao","box-ficcao")
// //    Criar Romance
//     createMovieCarrossel("titulo-romance","ROMANCE",createMoviesCategory(allMovies,"Romance"),"divRomance","#lista-romance","box-romance")
// //    Criar Terror
//     createMovieCarrossel("titulo-terror","TERROR",createMoviesCategory(allMovies,"Terror"),"divTerror","#lista-terror","box-terror")
}
main()