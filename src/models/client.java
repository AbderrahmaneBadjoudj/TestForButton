package models;

//import java.sql.Date;

public class client {

	private int codeC; // private ajouter
	private String Nom_Cli;
	private String Prenom_Cli;
	private int Telephone;
	private String Address;
	private String Remarque;
	
	public client() {
		super();
	}
	public client(int codeC, String Nom_Cli, String Prenom_Cli, int Telephone, String Address, String Remarque) {
		super(); // super ajouter
		this.codeC=codeC;
		this.Nom_Cli=Nom_Cli;
		this.Prenom_Cli=Prenom_Cli;
		this.Telephone=Telephone;
		this.Address=Address;
		this.Remarque=Remarque;
	}
	public int getCodeC() {
		return codeC;
	}
	public void setCodeC(int codeC) {
		this.codeC = codeC;
	}
	public String getNom_Cli() {
		return Nom_Cli;
	}
	public void setNom_Cli(String nom) {
		Nom_Cli = nom;
	}
	public String getPrenom_Cli() {
		return Prenom_Cli;
	}
	public void setPrenom_Cli(String prenom) {
		Prenom_Cli = prenom;
	}
	public int getTelephone() {
		return Telephone;
	}
	public void setTelephone(int telephone) {
		Telephone = telephone;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getRemarque() {
		return Remarque;
	}
	public void setRemarque(String remarque) {
		Remarque = remarque;
	}
	
	
}
