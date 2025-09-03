package Usuario;

import java.security.MessageDigest; 

import java.security.NoSuchAlgorithmException; 

import java.util.Base64; 

  

public class Usuario { 
    private String nome; 
    private String email; 
    private String senhaHash; 

    public Usuario(String nome, String email) {
        setNome(nome);
        setEmail(email);
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (!validarNome(nome)) {
            throw new IllegalArgumentException("Nome inválido");
        }
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (!validarEmail(email)) {
            throw new IllegalArgumentException("Email inválido");
        }
        this.email = email;
    }

    public boolean validarNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            return false;
        }
        return nome.matches("^[a-zA-ZÀ-ÿ ']+( [a-zA-ZÀ-ÿ ']+)*$");
    }

    public boolean validarEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        return email.matches("^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$");
    }

    public boolean validarCampos() {
        return validarNome(this.nome) && validarEmail(this.email);
    }

    @Override
    public String toString() {
        return "Usuario{nome='" + nome + "', email='" + email + "'}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Usuario usuario = (Usuario) obj;
        return nome.equals(usuario.nome) && email.equals(usuario.email);
    }

    public void setSenha(String senha) { 
        try { 
            MessageDigest digest = MessageDigest.getInstance("SHA-256"); 
            byte[] hashBytes = digest.digest(senha.getBytes()); 
            String hashString = Base64.getEncoder().encodeToString(hashBytes); 
            this.senhaHash = hashString; 
        } catch (NoSuchAlgorithmException e) { 
            throw new RuntimeException("Algoritmo de hash não encontrado", e); 
        } 
    } 

    private TentativaAutenticacaoManager tentativaManager = new TentativaAutenticacaoManager();

    public boolean autenticar(String senha) throws ExceededAttemptsException {
        tentativaManager.registrarTentativa();

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(senha.getBytes());
            String hashString = Base64.getEncoder().encodeToString(hashBytes);

            boolean sucesso = hashString.equals(this.senhaHash);
            if (sucesso) {
                tentativaManager.resetar();
            }
            return sucesso;
        } catch (NoSuchAlgorithmException e) {
            return false;
        }
    }
    
    public boolean autenticar(String senha, String algoritmo) throws ExceededAttemptsException {
        tentativaManager.registrarTentativa();

        try {
        	if (algoritmo.equals("SHA-256")) {
        		MessageDigest digest = MessageDigest.getInstance("SHA-256");
                byte[] hashBytes = digest.digest(senha.getBytes());
                String hashString = Base64.getEncoder().encodeToString(hashBytes);

                boolean sucesso = hashString.equals(this.senhaHash);
                if (sucesso) {
                    tentativaManager.resetar();
                }
                return sucesso;
        	} else if (algoritmo.equals("MD5")) {
        		MessageDigest digest = MessageDigest.getInstance("MD5");
                byte[] hashBytes = digest.digest(senha.getBytes());
                String hashString = Base64.getEncoder().encodeToString(hashBytes);

                boolean sucesso = hashString.equals(this.senhaHash);
                if (sucesso) {
                    tentativaManager.resetar();
                }
                return sucesso;
            
        	} else if (algoritmo.equals("SHA-1")) {
        		MessageDigest digest = MessageDigest.getInstance("SHA-1");
                byte[] hashBytes = digest.digest(senha.getBytes());
                String hashString = Base64.getEncoder().encodeToString(hashBytes);

                boolean sucesso = hashString.equals(this.senhaHash);
                if (sucesso) {
                    tentativaManager.resetar();
                }
                return sucesso;
        	} else 
        		throw new NoSuchAlgorithmException();
        	
        } catch (NoSuchAlgorithmException e) {
            return false;
        }
    }

} 
