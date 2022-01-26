const serie = localStorage.getItem("serieId");
const selectedSerie= getSerie(serie);
const allSeasons = getAllSeasons(selectedSerie);

function idEpisode(id){
    let request = new XMLHttpRequest()
    request.open("GET","http://localhost:8080/api/v1/series/player/"+id,false)
    request.send()
    localStorage.clear();
}

function getSerie(id){
    let request = new XMLHttpRequest()
    request.open("GET","http://localhost:8080/api/v1/series/"+id,false)
    request.send()
    let data = request.responseText
    return JSON.parse(data);
}

function getSerieData(){
    let nome = document.querySelector(".titulo-serie");
    nome.textContent =selectedSerie.nameBr;
    let sinopse = document.querySelector(".descricao-serie");
    sinopse.textContent = selectedSerie.description;
    let capa = document.querySelector(".serie-selecionada");
    capa.style.backgroundImage="url("+selectedSerie.background+")";
    let nomeUs = document.querySelector(".nome-us-serie");
    nomeUs.textContent = "Nome inglês: "+selectedSerie.name;
    let ano = document.querySelector(".ano-serie");
    ano.textContent = "Ano: "+selectedSerie.year;
    let genero = document.querySelector(".genero-serie");
    genero.textContent = "Gênero: "+selectedSerie.genre;
    let nota = document.querySelector(".nota-serie");
    nota.textContent = "Minha nota: ";
    let note = "#cm_star-" + selectedSerie.rating;
    document.querySelector(note).checked =true;

}

function getAllSeasons(selectedSerie){
    const allSeasons = [];
    selectedSerie.season.map((item=> {
        allSeasons.push(item)
    }))
    return allSeasons;

}

function createSeasonCarousel(h3,textTitle, allEpisodes, divName, div, classImg){
    h3.textContent=textTitle;
    h3.style.marginTop= "20px";
    allEpisodes.map((item)=> {
        let div1 = document.createElement('div');
        let name =document.createElement('label')
        name.textContent= "Episódio 0"+item.numEpisode+": "+item.nameEpisode;
        name.setAttribute('class','info-episode')
        div1.setAttribute('class','item');
        div1.setAttribute('onclick','idEpisode('+item.id+')');
        const img = document.createElement('img');
        img.setAttribute('class',classImg);
        img.setAttribute('src',selectedSerie.thumbnail)
        div1.appendChild(img);
        div1.appendChild(name)
        div.appendChild(div1);
    })
}
function createAllSeasonsCarousel(allSeasons){
    let divSeasons = document.querySelector('.carrossel-temporadas');
    allSeasons.map((item)=>{
        let season = item.numSeason;
        let divSeason = document.createElement('div');
        divSeason.setAttribute('class', 'carrossel-temporada-'+season)
        let h3 = document.createElement('h3');
        h3.setAttribute('class','titulo');
        h3.setAttribute('id','titulo-temporada-'+season);
        let div= document.createElement('div');
        div.setAttribute('class','owl-carousel owl-theme');
        div.setAttribute('id','lista-temporada-'+season);

        createSeasonCarousel(h3,'TEMPORADA '+season,item.episode,"divTemp"+season,div,"box-temp-"+season);
        divSeason.appendChild(h3);
        divSeason.appendChild(div)
        divSeasons.appendChild(divSeason);
    })
}

getSerieData();
createAllSeasonsCarousel(allSeasons);
