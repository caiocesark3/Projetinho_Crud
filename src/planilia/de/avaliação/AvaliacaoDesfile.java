/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package planilia.de.avaliação;

import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;

/**
 *
 * @author ADM
 */
public class AvaliacaoDesfile{
    public static void notaAdicionada(){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Informe o nome do Avaliador: ");
        String avaliador = scanner.nextLine();
        
        System.out.println("Informe o nome da Escola de Samba: ");
        String escola = scanner.nextLine();
        
        System.out.println("Digite o quesito a ser avaliado: ");
        String quesito = scanner.nextLine();
        
        System.out.println("Informe a nota (9,5 a 10,0");
        double nota = scanner.nextDouble();
        
        
        if (nota < 9.5 || nota > 10.0){
            System.out.println("A nota esta invalida! Insira uma nota entre 9.5 e 10.0)");
            return;
        }
            String sql = "INSERT INTO avaliacoes (avaliador,escola,quesito,nota) VALUES(?,?,?,?)";
            
            try(Connection conexao = ConexaoBanco.getConexao();
                    PreparedStatement stmt = conexao.prepareStatement(sql)){
                stmt.setString(1, avaliador);
                stmt.setString(2, escola);
                stmt.setString(3, quesito);
                stmt.setDouble(4, nota);
                int linhasAfetadas = stmt.executeUpdate();
                if(linhasAfetadas>0){
                    System.out.println("Sua nota foi adicionada!");
                }else{
                    System.out.println("Erro ao Adicionar Nota!");
                }
            }catch(SQLException e){
                System.out.println("Erro ao conectar ao banco de dados:" + e.getMessage());
                
            }
    }
    public static void main(String[] args) {
        notaAdicionada();
    }
}
   
    
        
        
    
    
    
    
    

