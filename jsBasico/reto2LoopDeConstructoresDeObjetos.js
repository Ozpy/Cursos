function objeto(car1, car2){
    this.car2 = car2;
    this.car1 = car1;
}
function crearObjetos(n) {
	for (let i = 0; i < n; i++) {
	objetos[i] =new objeto("este es el objeto numero "+i,"car2 "+i);
	  console.log(objetos[i].car1);
	}
}
        var objetos = [];
crearObjetos(100);
console.log(objetos[5].car1);
