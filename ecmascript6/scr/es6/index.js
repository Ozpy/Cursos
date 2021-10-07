//funcion con ecmaSript6
function newFunction(name="Oscar",age=20,contry="MX") {
  console.log(name,age,contry);
}
newFunction();
newFunction("Alejandro",age=24,contry="US");
//Tamlate literals
let hola = "Hola";
let mundo = "mundo";

let frase = `Aqui podremos juntar la variable numero uno que es: ${hola} y la variable numero dos que es ${mundo}`;

console.log(frase);

let mulitlinea = `Esta es la primera linea
y esta es la segunda 
y esta es la tercera`;

console.log(mulitlinea);
