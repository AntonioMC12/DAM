public class piramide {

  //base = 7
  //altura = 4
  for(int planta=0;planta<altura;planta++){
    //planta 0????
    int espacios=altura-1-planta;  //5-1-4=0
    for(int i=0;i<espacios;i++){
        p(" ");
    }
    p("*");
    int interespacios=0;
    if(planta>0&&planta<altura-1){  
        interespacios=2*planta-1;
    }
    for(int i=0;i<interespacios;i++){
        p(" ");
    }
    if(planta>0){
        p("*");
    }
    for(int i=0;i<base-2&&planta==altura-1;i++){
        p("*");
    }
    //???????
    P("");
}
