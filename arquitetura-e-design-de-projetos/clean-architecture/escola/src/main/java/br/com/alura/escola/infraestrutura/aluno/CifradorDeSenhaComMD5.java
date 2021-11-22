package br.com.alura.escola.infraestrutura.aluno;

import br.com.alura.escola.dominio.aluno.CifradorDeSenha;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CifradorDeSenhaComMD5 implements CifradorDeSenha {

    @Override
    public String cifrarSenha(String senha) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(senha.getBytes());
            byte[] bytes = md.digest();
            StringBuilder db = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                db.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(i));
            }
            return db.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("erro ao gerar hash da senha");
        }
    }

    @Override
    public boolean validarSenhaCifrada(String senhaCifrada, String senhaAberta) {
        return senhaCifrada.equals(cifrarSenha(senhaAberta));
    }
}
