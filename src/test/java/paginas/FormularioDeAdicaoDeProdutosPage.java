package paginas;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormularioDeAdicaoDeProdutosPage extends BasePage {

    public FormularioDeAdicaoDeProdutosPage(WebDriver app){
        super(app);
    }

    public FormularioDeAdicaoDeProdutosPage informarNomeProduto(String produtoNome){
        app.findElement(By.id("com.lojinha:id/productName")).click();
        app.findElement(By.id("com.lojinha:id/productName")).findElement(By.id("com.lojinha:id/editText")).sendKeys(produtoNome);

        return this;
    }

    public FormularioDeAdicaoDeProdutosPage informarValorProduto(String produtoValor){
        app.findElement(By.id("com.lojinha:id/productValue")).click();
        app.findElement(By.id("com.lojinha:id/productValue")).findElement(By.id("com.lojinha:id/editText")).sendKeys(("700001"));

        return this;
    }

    public FormularioDeAdicaoDeProdutosPage informarCoresProduto(String produtoCores){
        app.findElement(By.id("com.lojinha:id/productColors")).click();
        app.findElement(By.id("com.lojinha:id/productColors")).findElement(By.id("com.lojinha:id/editText")).sendKeys(("Preto, Cinza"));

        return this;
    }

    public FormularioDeAdicaoDeProdutosPage submeterFormularioAdicaoComErro(){
        app.findElement(By.id("com.lojinha:id/saveButton")).click();
        return this;
    }

    public String obterMensagemComErro(){
       return capturarMensagemApresentada();
    }


}
