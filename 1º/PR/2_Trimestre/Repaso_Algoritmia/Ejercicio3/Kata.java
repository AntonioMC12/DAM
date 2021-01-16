package Ejercicio3;

public class Kata {
	public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {
		String winner = "none";
		if(fighter1 != null && fighter2 != null && firstAttacker != null){
			if(firstAttacker.equals(fighter1.name) || firstAttacker.equals(fighter2.name)){
				while (fighter1.health > 0 && fighter2.health > 0) {
					if(firstAttacker.equals(fighter1.name)){
						fighter2.health-=fighter1.damagePerAttack;
						if(fighter2.health<=0){
							return fighter1.name;
						}
						fighter1.health-=fighter2.damagePerAttack;
						if(fighter1.health<=0){
							return fighter2.name;
						}
					}else{
						fighter1.health-=fighter2.damagePerAttack;
						if(fighter1.health<=0){
							return fighter2.name;
						}
						fighter2.health-=fighter1.damagePerAttack;
						if(fighter2.health<=0){
							return fighter1.name;
						}		
					}
				}
			}
		}
		return winner;
	}
}

