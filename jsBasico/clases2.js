//const Persona= (name,lastname,age)=>{
  //this.name = name;
  //this.age = age;
  //this.lastname=lastname;
 //};
function Persona (name,lastname,age){
  //Constructor
  this.name = name;
  this.age = age;
  this.lastname=lastname;

  //Metodos
  this.saludar = function (number){
    console.log(`Hola ${this.name} y me diste el number ${number}`);
  }
 };

let person = new Persona("Pepe",`Garcia`,30);

console.log(person.name);
console.log(person.age);
console.log(person.lastname);
person.saludar(15)
hal
hola 
:
uhaloeu
aoeuha
hola hol
