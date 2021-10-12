//Objeto literal
const objeto1 = {
  //Atributos
  'Dato1' : 10,
  'Dato2' : 20,
  'Dato3' : 11,
  //Metodos
  //Forma1
  sumar : function() {
    return this.Dato1+this.Dato2+this.Dato3
  },
  //Forma2
  restar(resta){
    return this.Dato1-resta
  }
}
objeto1.restar(1);
objeto1.sumar()
//--------------Prototipo forma 1 (class)
class Objeto2 {
    constructor(name, age, estado) {
        this.name = name;
        this.age = age;
        this.estado = estado;
    }
  //Forma 1 de hacer un metodo(Dentro de la clase)
  metodo1(){
    console.log(`${this.name}`);
  }
  }
//Forma 2 de hacer un metodo(Fuera de la clase)
Objeto2.prototype.metodo2 = function() {
    console.log(`${this.age}`);
}

const obj2 = new Objeto2("Oscar",12,1);
obj2.metodo1()
obj2.metodo2()
//-------------Prototpo Forma2
function Objeto3(name,age,estado) {
  this.name = name;
  this.age = age;
  this.estado = estado;
  
  //Forma 1 de hacer un metodo
  this.metodo1=function() {
    console.log(`${this.age}`);
  }
  //Tambien se puede hacer por afuera de la funicon
}
const obj3 = new Objeto3("Oscar",12,1);
obj3.metodo1()
////----------------RoRo rocibe un objeto y retorna un objeto
class Objeto4 {
  constructor({
    name,
    age,
    email,
    estado,
  }) {
    this.name=name;
    this.age=age;
    this.email=email;
    this.estado=estado;
    }
  //Forma 1 de hacer un metodo(Dentro de la clase)
  metodo1(){
    console.log(`${this.name}`);
  }
  }
const obj4 = new Objeto4({
  age:3,
  name:"Oscar",
  estado:1,
  email:"oscar@gmail.com"
})
obj4.age
obj4.name
obj4.email
obj4.estado
