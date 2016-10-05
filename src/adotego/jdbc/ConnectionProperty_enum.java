 
package adotego.jdbc;
 
/*
    Enum responsável por definir as Strings necesárias para o MySqlDataSource
    fazer a conexão com banco de dados.
*/
public enum ConnectionProperty_enum {
        
    URL("jdbc:mysql://127.0.0.1:3306/adotego?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"), 
	USERNAME("root"), 
	PASSWORD("root");
        
	private final String value;
	
	private ConnectionProperty_enum(String value) {
		this.value = value;
	}
	
        /*
            Retorna o valor da enum
        */
	public String getValue() {
		return value;
	}
}
