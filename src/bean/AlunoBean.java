 
package bean;

public class AlunoBean {
    
    public String calculaMedia(float nota1, float nota2) {
        String resp = "";
        float media = (nota1 + nota2) / 2;
        if (media < 3) {
        resp = media + " : Reprovado";
        } else if (media >= 6) {
        resp = media + " : Aprovado";
        } else {
        resp = media + " : Exame";
        }
        return resp;
    }
}
