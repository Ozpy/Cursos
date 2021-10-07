function Libro(title,auth,year,gen) {
  this.title=title;
  this.auth=auth;
  this.year=year;
  this.gen=gen;
  thi.gen

  //Methods
  this.getBooks = function() {
	let flag = true; 
  	this.title =  prompt(`Dime el titulo del libro `);
  	this.auth=  prompt(`Dime el autor del libro `);
  	this.year=  prompt(`Dime el anio del libro `);
  	this.gen=  prompt(`Dime el genero del libro `);
    if (this.title || this.auth || this.year || this.gen == ""){
	flag = false; 
	console.log("Vuelve a intentarlo con todos los valores");
    }else if (/\d\d\d\d/.test(this.year)) {
	flag=false;
    	this.year=prompt(`No es un anie valido, intentalo de nuevo`);
    }if(this.gen != ("aventuras" || "terror" || "fantasia") ){
  	this.gen=  prompt(`El gereno No es valido, intentalo de nuevo`);
    }
    else{
      console.log("Todo bien");
    }
  }
  this.showData = function() {
    console.log(`El titulo del libro es ${this.title} 
      el autor es ${this.auth}
      El anio es ${this.year}
      El genero es ${this.gen}`);	
  }
}

let libros = [];

const getArrayBooks= (n)=>{
  for (let i = 0; i < n; i++) {
    libros.push(new Libro("",0,0,0))
    libros[i].getBooks();
}}
const showDataBooks = ()=>{
  libros.forEach((item)=>{
    item.showData})
}

getArrayBooks(3);
libros.forEach(libro => {
 libro.showData()});
showDataBooks();
