 
package adotego.modelos;
/**
 * 
 * @author Thomaz
 */
 
public class Endereco {
        private String rua;
	private String cidade;
        private String bairro;
        private int numero;
        private String uf;
	private String cep;
       
        
	public Endereco() {
		numero = -1;
	}
        
        public Endereco(String rua, String cidade, String bairro, int numero, 
                String uf, String cep) {
            this.rua = rua;
            this.cidade = cidade;
            this.bairro = bairro;
            this.numero = numero;
            this.uf = uf;
            this.cep = cep;
        }
        
        public String getUf() {
            return uf;
        }

        public void setUf(String uf) {
            this.uf = uf;
        }

        public String getCidade() {
            return cidade;
        }

        public void setCidade(String cidade) {
            this.cidade = cidade;
        }

        public String getBairro() {
            return bairro;
        }

        public void setBairro(String bairro) {
            this.bairro = bairro;
        }

        public String getRua() {
            return rua;
        }

        public void setRua(String rua) {
            this.rua = rua;
        }

        public String getCep() {
            return cep;
        }

        public void setCep(String cep) {
            this.cep = cep;
        }

        public int getNumero() {
            return numero;
        }

        public void setNumero(int numero) {
            this.numero = numero;
        }

        @Override
        public String toString() {
            return "Endereco{" + "rua=" + rua + ", cidade=" + cidade +
                    ", bairro=" + bairro + ", numero=" + numero + ", uf=" + uf 
                    + ", cep=" + cep + '}';
        }

    boolean isValid() {
        return !(this.getCidade() == null
                || this.getBairro() == null
                || this.getCep() == null
                || this.getUf() == null
                || this.getNumero() == -1
                );
    }
	
        
}
