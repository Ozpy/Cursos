//objeto
var myObjeto= {
  caracteristica1: 123,
  caracteristica2: 456,
  caracteristica3: 567,
  caracteristica4: 667,
  imprimirCaracteristicas : function() {
  	console.log("Este es un objeto con estas caracteristicas "+this.caracteristica1,this.caracteristica2,this.caracteristica3,this.caracteristica4);
  }

};
myObjeto.caracteristica4;
myObjeto.imprimirCaracteristicas();
}

