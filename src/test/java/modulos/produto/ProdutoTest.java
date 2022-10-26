package modulos.produto;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import paginas.LoginPage;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@DisplayName("Testes Mobile do Módulo Produto")
public class ProdutoTest {

    private WebDriver app;

    @BeforeEach
    //abrir o app
    public void beforeEach()  throws MalformedURLException{
        DesiredCapabilities capacidades = new DesiredCapabilities();
        capacidades.setCapability("devideName", "Google Pixel 3");
        capacidades.setCapability("plataform", "Android");
        capacidades.setCapability("udid", "192.168.56.104:5555");
        capacidades.setCapability("appPackage", "com.lojinha");
        capacidades.setCapability("appActivity", "com.lojinha.ui.MainActivity");
        capacidades.setCapability("app", "C:\\CaminhoParaOAplicativo");

        this.app = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capacidades);
        this.app.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @DisplayName("Validação do Valor de Produto Não Permitido")
    @Test
    public void testValidacaoDoValorDeProdutoNaoPermitido() {
        //fazer login
        String mensagemApresentada = new LoginPage(app)
                .informarUsuario("admin")
                .informarSenha("admin")
                .submeterLogin()
                .acessarFormularioDeAdicaoDeProduto()
                .informarNomeProduto("Iphone")
                .informarValorProduto("700001")
                .informarCoresProduto("Preto, Branco")
                .submeterFormularioAdicaoComErro()
                .obterMensagemComErro();

        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);

    }

    @AfterEach
    public void afterEach(){
        app.quit();
    }

}
