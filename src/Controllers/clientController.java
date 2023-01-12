package Controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

//import com.jfoenix.controls.JFXButton.ButtonType;


import application.DataBaseConnexion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import models.client;
public class clientController implements Initializable{
	
	    Connection cnx;
	    public PreparedStatement st;
	    public ResultSet result;
	
	 @FXML
	    private TextField txt_client;

	    @FXML
	    private TextField txt_tel;

	    @FXML
	    private TextField txt_nom;

	    @FXML
	    private TextField txt_add;

	    @FXML
	    private TextField txt_pre;

	    @FXML
	    private Button btn_enrg;

	    @FXML
	    private Button btn_mod;

	    @FXML
	    private Button btn_sup;

	    @FXML
	    private TableView<client> table_grand;

	    @FXML
	    private TableColumn<client, Integer> table_code;

	    @FXML
	    private TableColumn<client, String> table_nom;

	    @FXML
	    private TableColumn<client, String> table_pre;

	    @FXML
	    private TableColumn<client, Integer> table_tel;

	    @FXML
	    private TableColumn<client, String> table_add;

	    @FXML
	    private TableColumn<client, String> table_rem;
	    
	    public ObservableList<client> data = FXCollections.observableArrayList();

	    @FXML
	    private TextField txt_area;

	    @FXML
	    private TextField txt_cher;

	    @FXML
	    private Button btn_cher;

	    @FXML
	    void add_client() {
	    	
	    	String codeC=txt_client.getText();
	    	String Nom=txt_nom.getText();
	    	String Prenom=txt_pre.getText();
	    	String Telephone=txt_tel.getText();
	    	String Address=txt_add.getText();
	    	String Remarque=txt_area.getText();
	    	
	    	String sql="INSERT INTO client(codeC,Nom_Cli,Prenom_cli,Telephone,Address,Remarque) VALUES(?,?,?,?,?,?)";
	    	if(!codeC.equals("")&&!Nom.equals("")&&!Prenom.equals("")&&!Telephone.equals("")&&!Address.equals("")&&!Remarque.equals("")) {
	    		
	    		try {
		    		st=cnx.prepareStatement(sql);
		    		st.setString(1, codeC);
		    		st.setString(2, Nom);
		    		st.setString(3, Prenom);
		    		st.setString(4, Telephone);
		    		st.setString(5, Address);
		    		st.setString(6, Remarque);
		    		st.execute();
		    		txt_client.setText("");
		    		txt_nom.setText("");
		    		txt_pre.setText("");
		    		txt_tel.setText("");
		    		txt_add.setText("");
		    		txt_area.setText("");
		    		Alert alert=new Alert(AlertType.CONFIRMATION,"Client Ajouter Sur", javafx.scene.control.ButtonType.OK);
		    		alert.showAndWait();
		    		showclient();
		    	}catch (SQLException e) {
		    		e.printStackTrace();
		    	}
	    	}else {
	    		
	    		Alert alert=new Alert(AlertType.WARNING,"Remplir tout les champs !", javafx.scene.control.ButtonType.OK);
	    		alert.showAndWait();
	    	}

	    }

	    @FXML
	    void cher_client() {
	    	
	    	String sql="select codeC,Nom_Cli,Prenom_Cli,Telephone,Address,Remarque from client where codeC = '"+txt_cher.getText()+"'";
	    	int m=0;
	    	try {
	    		st=cnx.prepareStatement(sql);
	    		result=st.executeQuery();
	    		if(result.next()) {
	    			txt_client.setText(result.getString("codeC"));
	    			txt_nom.setText(result.getString("Nom_Cli"));
	    			txt_pre.setText(result.getString("Prenom_Cli"));
	    			txt_tel.setText(result.getString("Telephone"));
	    			txt_add.setText(result.getString("Address"));
	    			txt_area.setText(result.getString("Remarque"));
	    			m=1;
	    		}
	    		
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}
	    	if(m==0) {
	    		Alert alert=new Alert(AlertType.ERROR,"Aucun Client trouve avec sous code = "+txt_cher.getText()+"",javafx.scene.control.ButtonType.OK);
	    		alert.showAndWait();
	    	}

	    }

	    @FXML
	    void mod_client() {
	    	
	    	String codeC=txt_client.getText();
	    	String Nom=txt_nom.getText();
	    	String Prenom=txt_pre.getText();
	    	String Telephone=txt_tel.getText();
	    	String Address=txt_add.getText();
	    	String Remarque=txt_area.getText();
	    	
	    	String sql="update client set codeC=?, Nom_Cli=?, Prenom_Cli=?, Telephone=?, Address=?, Remarque=? where codeC ='"+txt_cher.getText()+"'";
	    	if(!codeC.equals("")&&!Nom.equals("")&&!Prenom.equals("")&&!Telephone.equals("")&&!Address.equals("")&&!Remarque.equals("")) {
	    		try {
		    		st=cnx.prepareStatement(sql);
		    		st=cnx.prepareStatement(sql);
		    		st.setString(1, codeC);
		    		st.setString(2, Nom);
		    		st.setString(3, Prenom);
		    		st.setString(4, Telephone);
		    		st.setString(5, Address);
		    		st.setString(6, Remarque);
		    		st.executeUpdate();
		    		txt_client.setText("");
		    		txt_nom.setText("");
		    		txt_pre.setText("");
		    		txt_tel.setText("");
		    		txt_add.setText("");
		    		txt_area.setText("");
		    		Alert alert=new Alert(AlertType.CONFIRMATION,"Modifer Client Succés", javafx.scene.control.ButtonType.OK);
		    		alert.showAndWait();
		    		showclient();
		    	}catch(SQLException e) {
		    		
		    		e.printStackTrace();
		    	}

	    	}else {
	    		
	    		Alert alert=new Alert(AlertType.WARNING,"Aucune Client Pour Modifier !", javafx.scene.control.ButtonType.OK);
	    		alert.showAndWait();
	    	}

	    }

	    @FXML
	    void sup_client() {
	    	
	    	String codeC=txt_client.getText();
	    	String Nom=txt_nom.getText();
	    	String Prenom=txt_pre.getText();
	    	String Telephone=txt_tel.getText();
	    	String Address=txt_add.getText();
	    	String Remarque=txt_area.getText();
	    	
	    	String sql="delete from client where codeC = '"+txt_cher.getText()+"'";
	    	if(!codeC.equals("")&&!Nom.equals("")&&!Prenom.equals("")&&!Telephone.equals("")&&!Address.equals("")&&!Remarque.equals("")) {
	    	try {
				st=cnx.prepareStatement(sql);
				st.executeUpdate();
				txt_client.setText("");
	    		txt_nom.setText("");
	    		txt_pre.setText("");
	    		txt_tel.setText("");
	    		txt_add.setText("");
	    		txt_area.setText("");
	    		Alert alert=new Alert(AlertType.CONFIRMATION,"Supprimé Client Succés", javafx.scene.control.ButtonType.OK);
	    		alert.showAndWait();
	    		showclient();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    	}else {
	    		
	    		Alert alert=new Alert(AlertType.WARNING,"Aucune Client Pour Supptimé !", javafx.scene.control.ButtonType.OK);
	    		alert.showAndWait();
	    	}

	    }
	    
	    @FXML
	    void table_mod() {
	    	
	    	client client=table_grand.getSelectionModel().getSelectedItem();
	    	String sql="select * from client where codeC = ?";
	    	try {
				st=cnx.prepareStatement(sql);
				st.setInt(1, client.getCodeC());
				result=st.executeQuery();
				if(result.next()) {
					txt_client.setText(result.getString("codeC"));
	    			txt_nom.setText(result.getString("Nom_Cli"));
	    			txt_pre.setText(result.getString("Prenom_Cli"));
	    			txt_tel.setText(result.getString("Telephone"));
	    			txt_add.setText(result.getString("Address"));
	    			txt_area.setText(result.getString("Remarque"));
	    			txt_cher.setText(result.getString("codeC"));
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

	    }
	    
	    public void showclient() {
        	table_grand.getItems().clear(); //vider la table a chaque foi fait un mis a jour (ajouter nouve client)
	    	String sql="SELECT * FROM client";
	    	try {
				st=cnx.prepareStatement(sql);
				result=st.executeQuery();
			while(result.next()) {
					data.add(new client(result.getInt(1),result.getString(2),result.getString(3),result.getInt(4),result.getString(5),result.getString(6) ));
			}
			} catch (SQLException e) { 
				e.printStackTrace();
			}
	         table_code.setCellValueFactory(new PropertyValueFactory<client,Integer>("codeC"));
	         table_nom.setCellValueFactory(new PropertyValueFactory<client,String>("Nom_Cli"));
	         table_pre.setCellValueFactory(new PropertyValueFactory<client,String>("Prenom_Cli"));
	         table_tel.setCellValueFactory(new PropertyValueFactory<client,Integer>("Telephone"));
	         table_add.setCellValueFactory(new PropertyValueFactory<client,String>("Address"));
	         table_rem.setCellValueFactory(new PropertyValueFactory<client,String>("Remarque"));
	         table_grand.setItems(data);
	    	
	    }


	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		 cnx=DataBaseConnexion.connexionDB();
		 showclient();
		
	}

}

