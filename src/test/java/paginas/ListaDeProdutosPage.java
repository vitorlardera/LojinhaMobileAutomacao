package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListaDeProdutosPage extends BasePage {

    public ListaDeProdutosPage(WebDriver app){
        super(app);
    }

    public FormularioDeAdicaoDeProdutosPage acessarFormularioDeAdicaoDeProduto(){
        app.findElement(By.id("com.lojinha:id/floatActionButton")).click();

        return new FormularioDeAdicaoDeProdutosPage(app);
    }


}
