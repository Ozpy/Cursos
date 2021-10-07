var articulos= [
  {nombre:"Carro",precio:300},
  {nombre:"Carro",precio:400},
  {nombre:"PC",precio:150},
  {nombre:"Teclado",precio:500},
  {nombre: "Audifonos",precio:531},
  {nombre: "Laptop",precio:340}
]
////Filter
//console.log("Filter\n");
//var articulosFiltered = articulos.filter(function(articulo) {
	//return articulo.precio<360;
//});
//articulosFiltered[0]
////Map

//console.log("Map\n");
//var articulosMap = articulos.map(function(articulo) {
	//console.log(indexof(articulo));
	//return articulo.nombre;
//});

////find
//console.log("find\n");
//var articulosFind = articulos.find(function(articulo) {
  //return articulo.nombre=="Carro";
//});
//articulosFind;

////ForEach
//console.log("ForEach\n");
var articulosForEach=[];
articulos.forEach(function(articulo) {
	console.log(articulo.nombre);
  articulosForEach.push(articulo.nombre);
});

//console.log(articulosForEach);
//Some
//var articulosSome = articulos.some(function(articulo) {
	//return articulo.precio<100;
//})

