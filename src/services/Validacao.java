package services;

public class Validacao {
	public static boolean campoVazio(String campo){
		if(campo == null || campo.isEmpty()){
			return true;
		}
		return false;
	}
	

}
