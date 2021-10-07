function juego(player) {
     pc="Piedra";
	if (player==pc) {
	 return "Empate";
	}
	else if((player=="Tijera" && pc=="Piedra")||(player=="Piedra" && pc=="Papel") || (player=="Papel" && pc=="Tijera")) {
	  return "Gana PC";
	}
  else{
		 return "Gana Player";
  }
}
juego("Papel");
juego("Piedra");
juego("Tijera");

